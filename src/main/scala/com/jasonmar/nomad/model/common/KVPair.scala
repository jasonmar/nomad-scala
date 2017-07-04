package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.Parameter

case class KVPair(key: String, value: String) extends Parameter {
  override val parameterName: String = key
}
