package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.Parameter

case class BoolParam(name: String, b: Boolean) extends Parameter {
  override val parameterName: String = name
  override val value: String = if (b) "true" else "false"

  override def printHCL: String = {
    if (b) s"$parameterName = true"
    else s"$parameterName = false"
  }
}
