package com.jasonmar.hcl

trait Parameter extends Printable with HCLValue {
  val parameterName: String = this.getClass.getSimpleName.toLowerCase.replaceAll("[^a-zA-Z0-9]", "")

  override def printHCL: String = {
    if (value.length > 0) s"""$parameterName = "$value""""
    else throw new Exception("empty value")
  }
}
