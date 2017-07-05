package com.jasonmar.nomad.codegen

import scala.collection.mutable

object GoConsts {

  def getConsts(lines: Iterator[String]): String = {
    val l = new mutable.ListBuffer[String]()
    l.append("// generated\n")
    l.append("object Consts {")
    var const = false
    var nConst = 0
    var nNonConst = 0
    var close = 0
    var value = 0
    var comment = 0

    var iota = 0 // auto increment
    while (lines.hasNext){
      lines.next() match {
        case s if !const && s == "const (" =>
          const = true
          nConst += 1
        case s if !const =>
          nNonConst += 1
        case s if const && s == ")" =>
          const = false
          close += 1
        case s if const && s.take(3) != "\t//" && s.length > 1 =>
          val s1: String = if (s.contains(" = iota")) {
            iota = 1 // reset auto increment
            s.substring(1, s.length)
              .replace(" MessageType ", " ")
              .replace("iota","1 // iota")
          } else if (iota > 0 && !s.contains(" = ")) {
            iota += 1
            s.substring(1, s.length) + " = " + iota.toString + " // iota"
          } else {
            iota = 0
            s.substring(1, s.length)
              .replace(" MessageType ", " ")
              .replace("time.Second", "1000 // milliseconds")
          }

          l.append(s"  val $s1")
          value += 1
        case s if s.contains("//") =>
          l.append(s"  ${s.substring(1, s.length)}")
          comment += 1
        case _ =>
      }
    }
    l.append("}")
    System.out.println(s"$nConst\t$nNonConst\t$close\t$value\t$comment")
    l.result().mkString("\n")
  }


}
