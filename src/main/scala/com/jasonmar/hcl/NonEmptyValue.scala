package com.jasonmar.hcl

trait NonEmptyValue {
  val value: String
  def quotedValue: String = s""""$value""""
  require(value.nonEmpty)
  override def toString: String = value
}
