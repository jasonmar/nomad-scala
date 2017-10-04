package com.jasonmar.nomad.model.service

import com.jasonmar.hcl.Parameter

object CheckTypes {
  /** This indicates the check types supported by Nomad. Valid options are `script`, `http`, and `tcp`.
    * // https://www.nomadproject.io/docs/job-specification/service.html#type
    */
  sealed trait CheckType extends Parameter { override val parameterName: String = "type" }
  case object Script extends CheckType { override val value: String = "script" }
  case object HTTP extends CheckType { override val value: String = "http" }
  case object TCP extends CheckType { override val value: String = "tcp" }
}