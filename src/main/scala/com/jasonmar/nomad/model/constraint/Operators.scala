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

  /** Instructs the scheduler to not co-locate any groups on
  the same machine. When specified as a job constraint, it applies to all groups
  in the job. When specified as a group constraint, the effect is constrained to
  that group. This constraint can not be specified at the task level. Note that
  the `attribute` parameter should be omitted when using this constraint.
    */
  case object DistinctHosts extends Operator { override val value: String = "distinct_hosts" }

  /** Instructs the scheduler to select nodes that have a
  distinct value of the specified property for each allocation. When specified
  as a job constraint, it applies to all groups in the job. When specified as a
  group constraint, the effect is constrained to that group. This constraint can
  not be specified at the task level. Note that the `value` parameter should be
  omitted when using this constraint.
  A potential use case of the `distinct_property` constraint is to spread a
  service with `count > 1` across racks to minimize correlated failure. Nodes can
  be annotated with which rack they are on using [client
  metadata][client-metadata] with values
  such as "rack-12-1", "rack-12-2", etc.
    */
  case object DistinctProperty extends Operator { override val value: String = "distinct_property" }
}
