package com.jasonmar.nomad.model.vault

import com.jasonmar.hcl.Stanza

case class Vault(policies: Seq[Policy]) extends Stanza {
  override def printHCL = ""
}
