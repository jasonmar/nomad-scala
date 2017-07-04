package com.jasonmar.nomad.model.vault

import com.jasonmar.hcl.Parameter

case class Token(value: String) extends Parameter {
  override val parameterName: String = "vault_token"
}
