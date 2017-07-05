package com.jasonmar.nomad.model.task.driver

import com.jasonmar.hcl.Parameter

case class JVMOptions(args: Seq[String]) extends Parameter {
  override val parameterName: String = "jvm_options"
  override val value: String = "[" + args.map(arg => "\"" + arg + "\"").mkString(", ") + "]"
  override def printHCL: String = s"$parameterName = $value"
}
