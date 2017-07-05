package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.UnquotedParameter

case class Priority(intValue: Int) extends UnquotedParameter {
  require(intValue >= 1 && intValue <= 100)
  override val value: String = intValue.toString
}