package com.jasonmar.hcl

object Printer {

  class HCLBuilder (indent: Int = 2) {
    private val sb: StringBuilder = new StringBuilder()

    def maybeAppend(opt: Option[Printable]): Unit = {
      opt match {
        case Some(p) =>
          p.printIndented(sb, indent)
        case _ =>
      }
    }

    def maybeAppendSeq(opt: Option[Seq[Printable]]): Unit = {
      opt match {
        case Some(s) =>
          s.foreach(_.printIndented(sb, indent))
        case _ =>
      }
    }

    def appendSeq(s: Seq[Printable]): Unit = s.foreach{_.printIndented(sb, indent)}

    def append(p: Printable): Unit = p.printIndented(sb, indent)

    def open(stanza: String, label: String): Unit = {
      sb.append(stanza)
      sb.append(" \"")
      sb.append(label)
      sb.append("\" {\n")
    }

    def open(stanza: String): Unit = {
      sb.append(stanza)
      sb.append(" {\n")
    }

    def close(): Unit = sb.append("}")

    def result: String = sb.result
  }

}
