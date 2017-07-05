package com.jasonmar.nomad.model.task.artifact

import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.task.artifact.Options.ArtifactOption

case class ArtifactOptions(options: Seq[ArtifactOption]) extends Stanza {
  override val stanza: String = "options"

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.appendSeq(options)
    hcl.close()
    hcl.result
  }

}
