package com.jasonmar.nomad.model.constraint

import com.jasonmar.hcl.Parameter

object Operators {
  sealed trait Operator extends Parameter {
    override val parameterName: String = "operator"
  }
  case object Equal extends Operator { override val value: String = "=" }
  case object NotEqual extends Operator { override val value: String = "!=" }
  case object GreaterThan extends Operator { override val value: String = ">" }
  case object GreaterThanOrEqualTo extends Operator { override val value: String = ">=" }
  case object LessThan extends Operator { override val value: String = "<" }
  case object LessThanOrEqualTo extends Operator { override val value: String = "<=" }
  case object Regexp extends Operator { override val value: String = "regexp" }
  case object SetContains extends Operator { override val value: String = "set_contains" }
  case object Version extends Operator { override val value: String = "version" }
}
