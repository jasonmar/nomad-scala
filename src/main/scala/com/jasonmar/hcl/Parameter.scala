package com.jasonmar.hcl

trait Parameter extends Printable {
  val value: String
  val parameterName: String = this.getClass.getSimpleName.toLowerCase

  override def printHCL: String = s"""$parameterName = "$value""""
}
