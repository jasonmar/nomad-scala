package com.jasonmar.nomad.model.constraint

import com.jasonmar.hcl.Stanza
import com.jasonmar.nomad.model.constraint.ValueTypes.Value
import com.jasonmar.nomad.model.constraint.Operators.Operator

/**
  *
  * @param value Specifies the value to compare the attribute against using the specified operation. This can be a literal value, another attribute, or any [Nomad interpolated values](/docs/runtime/interpolation.html#interpreted_node_vars).
  * @param attribute Specifies the name or reference of the attribute to examine for the constraint. This can be any of the [Nomad interpolated values](/docs/runtime/interpolation.html#interpreted_node_vars).
  * @param operator Specifies the comparison operator.The ordering is compared lexically. Possible values include: = != > >= < <= regexp set_contains version For a detailed explanation of these values and their behavior, please see the [operator values section](#operator-values).
  */
case class Constraint(
  value: Value,
  attribute: Option[String] = None,
  operator: Option[Operator] = None
) extends Stanza {
  override def printHCL: String = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    attribute.foreach{a => sb.append(s"""  attribute = "$a"""")}
    operator.foreach{o => sb.append(s"  ${o.printHCL}")}
    sb.append(s"  ${value.printHCL}")
    sb.append("}")
    sb.result
  }
}