package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Parameter

object Protocols {
  sealed trait Protocol extends Parameter { override val parameterName: String = "protocol" }
  case object HTTP extends Protocol { override val value: String = "http" }
  case object HTTPS extends Protocol { override val value: String = "https" }
}