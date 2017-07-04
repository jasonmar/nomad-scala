package com.jasonmar.hcl

object Indentation {
  def indent(s: String, n: Int = 2): String = {
    val sb = new StringBuilder()
    for (i <- 0 until n){ sb.append(" ") }
    val replaceWith = sb.result
    s.lines
      .map(s => if (s.nonEmpty) replaceWith + s else s)
      .mkString("\n")
  }
}
