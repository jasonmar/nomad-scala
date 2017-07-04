package com.jasonmar.nomad.model.task

import com.jasonmar.hcl.Stanza
import com.jasonmar.hcl.Printer._

case class Env(envvars: Seq[EnvVar]) extends Stanza {
  override def printHCL: String = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    appendSeq(envvars, sb)
    sb.append("}")
    sb.result()
  }

}
