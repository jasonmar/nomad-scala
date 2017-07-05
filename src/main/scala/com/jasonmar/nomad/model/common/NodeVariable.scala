package com.jasonmar.nomad.model.common

// Represents an interpretable HCL variable
trait NodeVariable {
  require(name.matches("[0-9a-zA-Z-_.]*"))
  val name: String
  def ref: String = "${" + name + "}"
}
