package com.jasonmar.nomad.model.task

import com.jasonmar.hcl.Stanza
import com.jasonmar.hcl.Printer._
import com.jasonmar.hcl.parameter.StringParam

/**
  *
  * @param file Specifies the file name to write the content of dispatch payload to. The file is written relative to the [task's local directory][localdir].
  */
case class DispatchPayload(file: String) extends Stanza {
  override val stanza: String = "dispatch_payload"

  override def printHCL: String = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    append(StringParam("file", file), sb)
    sb.append("}")
    sb.result
  }
}