package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Printer._
import com.jasonmar.hcl._
import com.jasonmar.hcl.parameter.{BoolParam, StringParam}
import com.jasonmar.nomad.model.common.Durations.Duration
import com.jasonmar.nomad.model.common.{Args, Meta}
import com.jasonmar.nomad.model.service.CheckTypes.{CheckType, HTTP, Script, TCP}
import com.jasonmar.nomad.model.service.Protocols.Protocol
import com.jasonmar.nomad.model.service.Statuses.Status
import com.jasonmar.nomad.model.task.Env

object Checks {

  sealed trait Check extends Stanza {
    val initialStatus: Status
    val interval: Duration
    val timeout: Duration
    val checkType: CheckType
    override val stanza: String = "check"
  }

  /**
    *
    * @param command Specifies the command to run for performing
  the health check. The script must exit: 0 for passing, 1 for warning, or any
  other value for a failing health check. This is required for script-based
  health checks.

    ~> **Caveat:** The command must be the path to the command on disk, and no
    shell exists by default. That means operators like `||` or `&&` are not
    available. Additionally, all arguments must be supplied via the `args`
    parameter. To achieve the behavior of shell operators, specify the command
    as a shell, like `/bin/bash` and then use `args` to run the check.
    * @param args Specifies additional arguments to the
  `command`. This only applies to script-based health checks.
    * @param initialStatus Specifies the originating status of the
  service. Valid options are the empty string, `passing`, `warning`, and
  `critical`.
    * @param interval Specifies the frequency of the health checks
  that Consul will perform. This is specified using a label suffix like "30s"
  or "1h". This must be greater than or equal to "1s"
    * @param timeout Specifies how long Consul will wait for a
  health check query to succeed. This is specified using a label suffix like
  "30s" or "1h". This must be greater than or equal to "1s"
    */
  case class ScriptCheck(
    command: String,
    args: Seq[String],
    initialStatus: Status,
    interval: Duration,
    timeout: Duration
  ) extends Check {
    override val checkType: CheckType = Script

    override def printHCL: String = {
      val sb = new StringBuilder()
      sb.append(s"$stanza {")
      append(StringParam("command", command), sb)
      append(Args(args), sb)
      append(initialStatus, sb)
      append(StringParam("interval", interval.value), sb)
      append(StringParam("timeout", timeout.value), sb)
      sb.append("}")
      sb.result
    }
  }

  /**
    *
    * @param port Specifies the label of the port on which the
  check will be performed. Note this is the _label_ of the port and not the port
  number. The port label must match one defined in the [`network`][network]
  stanza. If a port value was declared on the `service`, this will inherit from
  that value if not supplied. If supplied, this value takes precedence over the
  `service.port` value. This is useful for services which operate on multiple
  ports.
    * @param initialStatus Specifies the originating status of the
  service. Valid options are the empty string, `passing`, `warning`, and
  `critical`.
    * @param interval Specifies the frequency of the health checks
  that Consul will perform. This is specified using a label suffix like "30s"
  or "1h". This must be greater than or equal to "1s"
    * @param timeout Specifies how long Consul will wait for a
  health check query to succeed. This is specified using a label suffix like
  "30s" or "1h". This must be greater than or equal to "1s"
    */
  case class TcpCheck(
    port: Port,
    initialStatus: Status,
    interval: Duration,
    timeout: Duration
  ) extends Check {
    override val checkType: CheckType = TCP

    override def printHCL: String = {
      val sb = new StringBuilder()
      sb.append(s"$stanza {")
      append(port, sb)
      append(initialStatus, sb)
      append(StringParam("interval", interval.value), sb)
      append(StringParam("timeout", timeout.value), sb)
      sb.append("}")
      sb.result
    }
  }

  /**
    *
    * @param path Specifies the path of the HTTP endpoint which
  Consul will query to query the health of a service. Nomad will automatically
  add the IP of the service and the port, so this is just the relative URL to
  the health check endpoint. This is required for http-based health checks.
    * @param port Specifies the label of the port on which the
  check will be performed. Note this is the _label_ of the port and not the port
  number. The port label must match one defined in the [`network`][network]
  stanza. If a port value was declared on the `service`, this will inherit from
  that value if not supplied. If supplied, this value takes precedence over the
  `service.port` value. This is useful for services which operate on multiple
  ports.
    * @param initialStatus Specifies the originating status of the
  service. Valid options are the empty string, `passing`, `warning`, and
  `critical`.
    * @param interval Specifies the frequency of the health checks
  that Consul will perform. This is specified using a label suffix like "30s"
  or "1h". This must be greater than or equal to "1s"
    * @param timeout Specifies how long Consul will wait for a
  health check query to succeed. This is specified using a label suffix like
  "30s" or "1h". This must be greater than or equal to "1s"
    * @param protocol Specifies the protocol for the http-based
  health checks. Valid options are `http` and `https`.
    * @param tlsSkipVerify Skip verifying TLS certificates for HTTPS
  checks. Requires Consul >= 0.7.2.
    */
  case class HttpCheck (
    path: String,
    port: Port,
    initialStatus: Status,
    interval: Duration,
    timeout: Duration,
    protocol: Option[Protocol] = None,
    tlsSkipVerify: Option[Boolean] = None
  ) extends Check {
    override val checkType: CheckType = HTTP
    tlsSkipVerify match {
      case Some(t) if t =>
        require(protocol.nonEmpty && protocol.getOrElse(Protocols.HTTP) == Protocols.HTTPS)
      case _ =>
    }

    override def printHCL: String = {
      val sb = new StringBuilder()
      sb.append(s"$stanza {")
      append(StringParam("path", path), sb)
      append(port, sb)
      append(initialStatus, sb)
      append(StringParam("interval", interval.value), sb)
      append(StringParam("timeout", timeout.value), sb)
      maybeAppend(protocol, sb)
      maybeAppend(tlsSkipVerify.map(BoolParam("tls_skip_verify", _)), sb)
      sb.append("}")
      sb.result
    }
  }

}
