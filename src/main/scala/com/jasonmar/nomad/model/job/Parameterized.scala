package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.parameter.SeqParam
import com.jasonmar.hcl.{HCLBuilder, NonEmptyString, Stanza}
import com.jasonmar.nomad.model.job.Payloads.Payload

/**
  *
  * @param metaOptional Specifies the set of metadata keys that may be provided when dispatching against the job.
  * @param metaRequired Specifies the set of metadata keys that must be provided when dispatching against the job.
  * @param payload Specifies the requirement of providing a
  payload when dispatching against the parameterized job. The **maximum size of a
  `payload` is 16 KiB**. The options for this
  field are:
  - `"optional"` - A payload is optional when dispatching against the job.
  - `"required"` - A payload must be provided when dispatching against the job.
  - `"forbidden"` - A payload is forbidden when dispatching against the job.
  */
case class Parameterized(
  metaOptional: Option[Seq[String]] = None,
  metaRequired: Option[Seq[String]] = None,
  payload: Option[Payload] = None
) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(metaOptional.map(s => SeqParam("meta_optional", s.map(NonEmptyString))))
    hcl.maybeAppend(metaRequired.map(s => SeqParam("meta_required", s.map(NonEmptyString))))
    hcl.maybeAppend(payload)
    hcl.close()
    hcl.result
  }
}
