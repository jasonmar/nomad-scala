package com.jasonmar.nomad.model.task

import com.jasonmar.hcl.HCLBuilder
import com.jasonmar.hcl.Stanza

case class Env(envvars: Seq[EnvVar]) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.appendSeq(envvars)
    hcl.close()
    hcl.result
  }

}
