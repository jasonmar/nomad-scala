package com.jasonmar.hcl

trait UnquotedParameter extends Parameter {
  override def printHCL: String = s"""$parameterName = $value"""
}
