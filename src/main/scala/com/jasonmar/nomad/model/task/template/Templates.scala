package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.{HCLBuilder, NonEmptyValue, Stanza}
import com.jasonmar.hcl.parameter.{BoolParam, StringParam}
import com.jasonmar.nomad.model.common.Durations.Duration
import com.jasonmar.nomad.model.task.template.ChangeModes.{ChangeMode, Signal}
import com.jasonmar.nomad.model.task.template.ChangeSignals.ChangeSignal

object Templates{

  /**
    * The "template" block instantiates an instance of a template renderer. This
  creates a convenient way to ship configuration files that are populated from
  environment variables, Consul data, Vault secrets, or just general
  configurations within a Nomad task.
    */
  sealed trait Template extends Stanza {
    val destination: RelativePath
    val change_mode: Option[ChangeMode]
    val change_signal: Option[ChangeSignal]
    val env: Option[Boolean]
    val left_delimiter: Option[String]
    val perms: Option[OctalPerms]
    val right_delimiter: Option[String]
    val splay: Option[Duration]
    change_mode match {
      case Some(Signal) =>
        require(change_signal.nonEmpty)
      case _ =>
    }
    override val stanza: String = "template"
  }

  /**
    *
    * @param source Specifies the path to the template to be rendered.
    One of `source` or `data` must be specified, but not both. This source can
    optionally be fetched using an [`artifact`][artifact] resource. This template
    must exist on the machine prior to starting the task; it is not possible to
    reference a template inside of a Docker container, for example.
    * @param destination Specifies the location where the
    resulting template should be rendered, relative to the task directory.
    * @param change_mode Specifies the behavior Nomad should take
    if the rendered template changes. Nomad will always write the new contents of
    the template to the specified destination. The possible values below describe
    Nomad's action after writing the template to disk.

    - `"noop"` - take no action (continue running the task)
    - `"restart"` - restart the task
    - `"signal"` - send a configurable signal to the task
    * @param change_signal Specifies the signal to send to the task as a
    string like `"SIGUSR1"` or `"SIGINT"`. This option is required if the
    `change_mode` is `signal`.
    * @param env Specifies the template should be read back in as
    environment variables for the task.
    * @param left_delimiter Specifies the left delimiter to use in the
    template. The default is "{{" for some templates, it may be easier to use a
    different delimiter that does not conflict with the output file itself.
    * @param perms Specifies the rendered template's permissions.
    File permissions are given as octal of the unix file permissions rwxrwxrwx.
    * @param right_delimiter Specifies the right delimiter to use in the
    template. The default is "}}" for some templates, it may be easier to use a
    different delimiter that does not conflict with the output file itself.
    * @param splay Specifies a random amount of time to wait between
    0ms and the given splay value before invoking the change mode. This is
    specified using a label suffix like "30s" or "1h", and is often used to
    prevent a thundering herd problem where all task instances restart at the same
    time.
    */
  case class SourceTemplate(
    source: LocalPath,
    destination: RelativePath,
    change_mode: Option[ChangeMode] = None,
    change_signal: Option[ChangeSignal] = None,
    env: Option[Boolean] = None,
    left_delimiter: Option[String] = None,
    perms: Option[OctalPerms] = None,
    right_delimiter: Option[String] = None,
    splay: Option[Duration] = None
  ) extends Template {
    override def printHCL: String = {
      val hcl = new HCLBuilder()
      hcl.open(stanza)
      hcl.append(StringParam("source", source.value))
      hcl.append(StringParam("destination", destination.value))
      hcl.maybeAppend(change_mode)
      hcl.maybeAppend(change_signal)
      hcl.maybeAppend(env.map(BoolParam("env", _)))
      hcl.maybeAppend(left_delimiter.map(StringParam("left_delimiter", _)))
      hcl.maybeAppend(perms.map(p => StringParam("perms", p.value)))
      hcl.maybeAppend(right_delimiter.map(StringParam("right_delimiter", _)))
      hcl.maybeAppend(splay.map(p => StringParam("splay", p.value)))
      hcl.close()
      hcl.result
    }
  }

  case class RawTemplate(value: String) extends NonEmptyValue

  /**
    *
    * @param data Specifies the raw template to execute. One of `source`
  or `data` must be specified, but not both. This is useful for smaller
  templates, but we recommend using `source` for larger templates.
    * @param destination Specifies the location where the
    resulting template should be rendered, relative to the task directory.
    * @param change_mode Specifies the behavior Nomad should take
    if the rendered template changes. Nomad will always write the new contents of
    the template to the specified destination. The possible values below describe
    Nomad's action after writing the template to disk.

    - `"noop"` - take no action (continue running the task)
    - `"restart"` - restart the task
    - `"signal"` - send a configurable signal to the task
    * @param change_signal Specifies the signal to send to the task as a
    string like `"SIGUSR1"` or `"SIGINT"`. This option is required if the
    `change_mode` is `signal`.
    * @param env Specifies the template should be read back in as
    environment variables for the task.
    * @param left_delimiter Specifies the left delimiter to use in the
    template. The default is "{{" for some templates, it may be easier to use a
    different delimiter that does not conflict with the output file itself.
    * @param perms Specifies the rendered template's permissions.
    File permissions are given as octal of the unix file permissions rwxrwxrwx.
    * @param right_delimiter Specifies the right delimiter to use in the
    template. The default is "}}" for some templates, it may be easier to use a
    different delimiter that does not conflict with the output file itself.
    * @param splay Specifies a random amount of time to wait between
    0ms and the given splay value before invoking the change mode. This is
    specified using a label suffix like "30s" or "1h", and is often used to
    prevent a thundering herd problem where all task instances restart at the same
    time.
    */
  case class DataTemplate(
    data: RawTemplate,
    destination: RelativePath,
    change_mode: Option[ChangeMode] = None,
    change_signal: Option[ChangeSignal] = None,
    env: Option[Boolean] = None,
    left_delimiter: Option[String] = None,
    perms: Option[OctalPerms] = None,
    right_delimiter: Option[String] = None,
    splay: Option[Duration] = None
  ) extends Template {
    override def printHCL: String = {
      val hcl = new HCLBuilder()
      hcl.open(stanza)
      hcl.append(StringParam("data", data.value))
      hcl.append(StringParam("destination", destination.value))
      hcl.maybeAppend(change_mode)
      hcl.maybeAppend(change_signal)
      hcl.maybeAppend(env.map(BoolParam("env", _)))
      hcl.maybeAppend(left_delimiter.map(StringParam("left_delimiter", _)))
      hcl.maybeAppend(perms.map(p => StringParam("perms", p.value)))
      hcl.maybeAppend(right_delimiter.map(StringParam("right_delimiter", _)))
      hcl.maybeAppend(splay.map(p => StringParam("splay", p.value)))
      hcl.close()
      hcl.result
    }
  }

}

