package com.jasonmar.hcl.parameter

import com.jasonmar.hcl.Parameter

case class IntParam(name: String, x: Int) extends Parameter {
  override val parameterName: String = name
  override val value: String = x.toString
  override def printHCL: String = s"""$parameterName = $value"""
}
