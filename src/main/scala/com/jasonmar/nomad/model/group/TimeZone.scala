package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Parameter

case class TimeZone(value: String) extends Parameter {
  override val parameterName: String = "time_zone"
}
