package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Parameter

case class PortLabel(value: String) extends Parameter {
  override val parameterName: String = "port"
}
