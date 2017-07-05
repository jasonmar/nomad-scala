package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.{HCLBuilder, Stanza}

case class Meta(values: Seq[KVPair]) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.appendSeq(values)
    hcl.close()
    hcl.result
  }
}
