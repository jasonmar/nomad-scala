package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.{NonEmptyValue, Parameter}

case class SeqParam(name: String, s: Seq[NonEmptyValue]) extends Parameter {
  override val parameterName: String = name
  override val value: String = "[" + s.map(_.quotedValue).mkString(", ") + "]"
  override def printHCL: String = s"$parameterName = $value"
}
