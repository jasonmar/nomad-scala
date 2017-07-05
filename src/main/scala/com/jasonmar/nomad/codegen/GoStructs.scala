package com.jasonmar.nomad.codegen

import com.jasonmar.nomad.codegen.GoTypes.replaceTypes
import scala.collection.mutable

object GoStructs {

  def getCaseClasses(lines: Iterator[String]): String = {
    val l = new mutable.ListBuffer[String]()
    val l1 = new mutable.ListBuffer[String]()
    val m = mutable.Map[String, String]()
    var lastComment: Option[String] = None

    l.append("// generated\n")
    l.append("object Types {\n")
    var struct = false
    var nStruct = 0
    var nNonStruct = 0
    var close = 0
    var value = 0
    var name: Option[String] = None
    var comment = 0
    while (lines.hasNext){
      lines.next() match {
        case s if !struct && s.matches("^type [a-zA-Z0-9-_]* struct \\{$") =>
          s.split(" ") match {
            case a if a.length == 4 =>
              name = Some(a(1))
              lastComment.foreach(l.append(_))
              l.append(s"case class ${a(1)} (")
            case _ =>
          }
          struct = true
          nStruct += 1
        case s if !struct && s.matches("^type [a-zA-Z0-9-_]* [a-zA-Z0-9-_]*$") =>
          s.split(" ") match {
            case a if a.length == 3 =>
              l.append(s"type ${a(1)} = ${replaceTypes(a.last)}\n") // type alias
            case _ =>
          }

        case s if !struct =>
          if (s.take(2) == "//"){
            if (lastComment.nonEmpty) lastComment = Some(lastComment.getOrElse("") + "\n" + s)
            else lastComment = Some(s)
          } else {
            lastComment = None
          }
          nNonStruct += 1
        case s if struct && s == "}" =>
          struct = false
          val cached = l1.result().mkString("\n")
          l1.clear()
          name.foreach(s => m.put(s, cached))
          l.append(cached)
          l.append(")\n\n")
          close += 1
        case s if struct && s.take(3) != "\t//" && s.nonEmpty =>
          s.substring(1, s.length).split(" ").filter(_.nonEmpty) match {
            case a if a.length == 2 =>
              l1.append(s"  ${a.head}: ${replaceTypes(a.last)},")
            case a if a.length == 1 =>
              m.get(a.head).foreach(l1.append(_)) // append cached contents
            case _ =>
          }
          value += 1
        case s if s.take(3) == "\t//" =>
          l.append(s"  ${s.substring(1, s.length)}")
          comment += 1
        case _ =>
      }
    }
    l.append("}")
    System.out.println(s"$nStruct\t$nNonStruct\t$close\t$value\t$comment")
    l.result().mkString("\n").replace(",\n)","\n)")
  }


  def getJsonFormats(lines: Iterator[String]): String = {
    val l = new mutable.ListBuffer[String]()

    var thisFields = 0
    val m = mutable.Map[String, Int]()
    l.append("// generated\n")
    l.append("import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport")
    l.append("import spray.json._\n")
    l.append("object JsonFormats {\n")
    var struct = false
    var nStruct = 0
    var nNonStruct = 0
    var close = 0
    var value = 0
    var comment = 0
    var fields = 0
    var name: Option[String] = None
    while (lines.hasNext){
      lines.next() match {
        case s if !struct && s.matches("^type [a-zA-Z0-9-_]* struct \\{$") =>
          s.split(" ") match {
            case a if a.length == 4 =>
              name = Option(a(1)).filter(_.nonEmpty)
            case _ =>
          }
          struct = true
          nStruct += 1
        case s if !struct =>
          nNonStruct += 1
        case s if struct && s == "}" && name.nonEmpty =>
          struct = false
          name match {
            case Some(className) =>
              l.append(s"  object ${className}JsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {")
              l.append(s"    implicit val fmt: RootJsonFormat[${className}] = jsonFormat${fields.toString}(${className})")
              l.append("  }\n")
              m.put(className, thisFields)
            case _ =>
          }
          name = None
          thisFields = 0
          fields = 0
          close += 1
        case s if struct && s.take(3) != "\t//" && s.nonEmpty =>
          s.substring(1, s.length).split(" ").filter(_.nonEmpty) match {
            case a if a.length == 2 =>
              value += 1
              fields += 1
              thisFields += 1
            case a if a.length == 1 =>
              m.get(a.head).foreach(fields += _)
              value += 1
            case _ =>
          }
        case s if s.take(3) == "\t//" =>
          comment += 1
        case _ =>
      }
    }
    l.append("}")
    System.out.println(s"$nStruct\t$nNonStruct\t$close\t$value\t$comment")
    l.result().mkString("\n").replace(",\n)","\n)")
  }


}
