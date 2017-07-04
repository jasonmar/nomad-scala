package com.jasonmar.nomad.model.task

import com.jasonmar.hcl.Parameter

case class EnvVar(key: String, value: String) extends Parameter {
  require(key.nonEmpty)
  override val parameterName: String = key
}
