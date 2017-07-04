package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.Parameter

object JobTypes {

  sealed trait JobType extends Parameter {
    override val parameterName: String = "type"
  }

  case object Service extends JobType {
    override val value = "service"
  }

  case object Batch extends JobType {
    override val value = "batch"
  }

  case object System extends JobType {
    override val value = "system"
  }

}
