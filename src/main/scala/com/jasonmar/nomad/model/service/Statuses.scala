package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Parameter

// https://www.nomadproject.io/docs/job-specification/service.html#initial_status
object Statuses {
  sealed trait Status extends Parameter  { override val parameterName: String = "initial_status" }
  case object Passing extends Status { override val value: String = "passing" }
  case object Warning extends Status { override val value: String = "warning" }
  case object Critical extends Status { override val value: String = "critical" }
}
