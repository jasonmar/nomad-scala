package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Parameter

object Statuses {
  sealed trait Status extends Parameter
  case object Passing extends Status { override val value: String = "passing" }
  case object Warning extends Status { override val value: String = "warning" }
  case object Critical extends Status { override val value: String = "critical" }
}
