package com.jasonmar.nomad.model.task.artifact

import com.jasonmar.hcl.Stanza
import com.jasonmar.hcl.Printer.appendSeq
import com.jasonmar.nomad.model.task.artifact.Options.ArtifactOption

case class ArtifactOptions(options: Seq[ArtifactOption]) extends Stanza {
  override val stanza: String = "options"

  override def printHCL: String = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    appendSeq(options, sb)
    sb.append("}")
    sb.result
  }

}
