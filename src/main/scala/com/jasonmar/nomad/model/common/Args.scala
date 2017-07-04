package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.Parameter

case class Args(args: Seq[String]) extends Parameter {
  override val value: String = "[" + args.map(arg => "\"" + arg + "\"").mkString(", ") + "]"
  override def printHCL: String = s"$parameterName = $value"
}
