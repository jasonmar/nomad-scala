package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.parameter.{SeqParam, StringParam}
import com.jasonmar.hcl._
import com.jasonmar.nomad.model.service.Checks.Check

/**
  *
  * @param name   Specifies the name of this
  * service. If not supplied, this will default to the name of the job, group, and
  * task concatenated together with a dash, like `"docs-example-server"`. Each
  * service must have a unique name within the cluster. Names must adhere to
  * [RFC-1123 §2.1](https://tools.ietf.org/html/rfc1123#section-2) and are limited
  * to alphanumeric and hyphen characters (i.e. `[a-z0-9\-]`), and be less than 64
  * characters in length.
  *
  * In addition to the standard [Nomad interpolation][interpolation], the
  *  following keys are also available:
  * - `JOB` - the name of the job
  * - `GROUP` - the name of the group
  * - `TASK` - the name of the task
  * - `BASE` - shorthand for `JOB-GROUP-TASK`
  * @param checks Specifies a health check associated with the service. This can be specified multiple times to define multiple checks for the service. At this time, Nomad supports the `script`, `http` and `tcp` checks.
  * @param port   Specifies the label of the port on which this service is running. Note this is the _label_ of the port and not the port number. The port label must match one defined in the [`network`][network] stanza.
  * @param tags   Specifies the list of tags to associate with this service. If this is not supplied, no tags will be assigned to the service when it is registered.
  */
case class Service(
  name: Option[String],
  checks: Seq[Check],
  port: PortLabel,
  tags: Seq[Tag]
) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(name.map(s => StringParam("name", s)))
    hcl.append(SeqParam("tags", tags))
    hcl.append(port)
    hcl.appendSeq(checks)
    hcl.close()
    hcl.result
  }
}