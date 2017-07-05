package com.jasonmar.nomad.model.constraint

import com.jasonmar.hcl.parameter.{BoolParam, StringParam}
import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.constraint.Operators.Operator

/**
  *
  * @param value Specifies the value to compare the attribute against using the specified operation. This can be a literal value, another attribute, or any [Nomad interpolated values](/docs/runtime/interpolation.html#interpreted_node_vars).
  * @param attribute Specifies the name or reference of the attribute to examine for the constraint. This can be any of the [Nomad interpolated values](/docs/runtime/interpolation.html#interpreted_node_vars).
  *  Example: only run on aws m4.xlarge nodes
  *    attribute = "${attr.platform.aws.instance-type}"
  *    value     = "m4.xlarge"
  *  Example: only run on nodes where binaries are cached by utilizing node [metadata][meta]
  *    attribute    = "${meta.cached_binaries}"
  *    set_contains = "redis,cypress,nginx"
  *
  * @param operator Specifies the comparison operator.The ordering is compared lexically. Possible values include: = != > >= < <= regexp set_contains version For a detailed explanation of these values and their behavior, please see the [operator values section](#operator-values).
  * @param distinct_hosts Instructs the scheduler to not co-locate any groups on
  the same machine. When specified as a job constraint, it applies to all groups
  in the job. When specified as a group constraint, the effect is constrained to
  that group. This constraint can not be specified at the task level. Note that
  the `attribute` parameter should be omitted when using this constraint.
  * @param distinct_property Instructs the scheduler to select nodes that have a
  distinct value of the specified property for each allocation. When specified
  as a job constraint, it applies to all groups in the job. When specified as a
  group constraint, the effect is constrained to that group. This constraint can
  not be specified at the task level. Note that the `value` parameter should be
  omitted when using this constraint.
  */
case class Constraint(
  value: Option[String] = None,
  attribute: Option[String] = None,
  operator: Option[Operator] = None,
  distinct_hosts: Option[Boolean] = None,
  distinct_property: Option[String] = None
) extends Stanza {

  distinct_hosts.foreach(_ => require(attribute.isEmpty))
  distinct_property.foreach(_ => require(value.isEmpty))

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(value.map(StringParam("value",_)))
    hcl.maybeAppend(attribute.map(StringParam("attribute",_)))
    hcl.maybeAppend(operator)
    hcl.maybeAppend(distinct_hosts.map(BoolParam("distinct_hosts", _)))
    hcl.maybeAppend(distinct_property.map(StringParam("distinct_property",_)))
    hcl.close()
    hcl.result
  }
}