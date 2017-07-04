package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Stanza

case class Priority(value: Int) extends Stanza {
  require(value >= 1 && value <= 100)
  override def printHCL: String = ""
}