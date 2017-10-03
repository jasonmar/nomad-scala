package com.jasonmar.nomad.model.common

// Represents an interpretable HCL variable
trait NodeVariable extends Named {
  require(name.matches("[0-9a-zA-Z-_.]*"))
  def ref: String = "${" + name + "}"
}
