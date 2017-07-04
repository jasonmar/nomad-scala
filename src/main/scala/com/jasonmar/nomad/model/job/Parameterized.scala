package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.Stanza
import com.jasonmar.nomad.model.job.Payloads.Payload

case class Parameterized(
  metaOptional: Seq[String],
  metaRequired: Seq[String],
  payload: Payload
) extends Stanza {
  override def printHCL: String = ""
}
