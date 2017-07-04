package com.jasonmar.hcl

trait Printable {
  def printHCL: String
  def printIndented(sb: StringBuilder, indent: Int = 2): Unit = {
    sb.append(Indentation.indent(printHCL, indent))
    sb.append("\n")
  }
}
