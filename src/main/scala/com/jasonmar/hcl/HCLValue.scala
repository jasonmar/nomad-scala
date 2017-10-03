package com.jasonmar.hcl

trait HCLValue {
  val value: String
  def quotedValue: String = s""""$value""""
  override def toString: String = {
    if (value.length > 0) value
    else throw new Exception("empty config value")
  }
}
