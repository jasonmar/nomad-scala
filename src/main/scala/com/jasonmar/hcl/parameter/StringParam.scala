package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.Parameter

case class StringParam(name: String, value: String) extends Parameter {
  override val parameterName: String = name
}
