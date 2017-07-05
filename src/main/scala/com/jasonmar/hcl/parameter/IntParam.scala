package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.{Parameter, UnquotedParameter}

case class IntParam(name: String, x: Int) extends UnquotedParameter {
  override val parameterName: String = name
  override val value: String = x.toString
}
