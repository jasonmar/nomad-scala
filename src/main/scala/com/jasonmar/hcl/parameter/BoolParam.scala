package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.UnquotedParameter

case class BoolParam(name: String, boolValue: Boolean) extends UnquotedParameter {
  override val parameterName: String = name
  override val value: String = if (boolValue) "true" else "false"
}
