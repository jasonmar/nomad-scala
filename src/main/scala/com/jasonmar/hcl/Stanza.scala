package com.jasonmar.hcl

trait Stanza extends Printable {
  val stanza: String = this.getClass.getSimpleName.toLowerCase
}
