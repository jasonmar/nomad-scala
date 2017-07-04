package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.Stanza

case class Meta(values: Seq[KVPair]) extends Stanza {
  override def printHCL = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    values.foreach{kv =>
      kv.printIndented(sb)
    }
    sb.append("\n")
    sb.result
  }
}
