package com.jasonmar

package object hcl {

  trait HCLValue {
    val value: String
    def quotedValue: String = s""""$value""""
    override def toString: String = {
      if (value.length > 0) value
      else throw new Exception("empty config value")
    }
  }

  trait Printable {
    def printHCL: String
    def printIndented(sb: StringBuilder, indent: Int = 2): Unit = {
      sb.append(Indentation.indent(printHCL, indent))
      sb.append("\n")
    }
  }

  trait Stanza extends Printable {
    val stanza: String = this.getClass.getSimpleName.toLowerCase
  }

  trait NamedStanza extends Stanza {
    val name: String
  }

  trait UnquotedParameter extends Parameter {
    override def printHCL: String = s"""$parameterName = $value"""
  }

  trait Parameter extends Printable with HCLValue {
    val parameterName: String = this.getClass.getSimpleName.toLowerCase.replaceAll("[^a-zA-Z0-9]", "")

    override def printHCL: String = {
      if (value.length > 0) s"""$parameterName = "$value""""
      else throw new Exception("empty value")
    }
  }

  case class NonEmptyString(value: String) extends HCLValue

  trait StringValue {
    val value: String
  }
}
