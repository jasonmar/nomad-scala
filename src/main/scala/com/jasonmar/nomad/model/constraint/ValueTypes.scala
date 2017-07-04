package com.jasonmar.nomad.model.constraint

import com.jasonmar.hcl.Parameter

object ValueTypes {
  sealed trait Value extends Parameter {
    override val parameterName: String = "value"
  }
  case class Literal(value: String) extends Value { require(value.indexOf("${") == -1) }
  case class Attribute(name: String) extends Value { override val value: String = "${attr." + s"$name}" }
  case class Interpolated(value: String) extends Value { require(value.indexOf("${") > -1 && value.indexOf("}") > -1) }
}
