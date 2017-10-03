package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.{HCLValue, StringValue}

object Durations {
  sealed trait Duration extends StringValue with HCLValue {
    val suffix: String
    val length: Int
    override def equals(obj: Any): Boolean = obj match {
      case x: Duration =>
        length == x.length
      case _ =>
        false
    }
  }

  case class Seconds(length: Int) extends Duration {
    require(length > 0)
    override val suffix: String = "s"
    override val value: String = length.toString + suffix
  }

  case class Hours(length: Int) extends Duration {
    require(length > 0)
    override val suffix: String = "m"
    override val value: String = length.toString + suffix
  }

  case class Minutes(length: Int) extends Duration {
    require(length > 0)
    override val suffix: String = "h"
    override val value: String = length.toString + "h"
  }

  case class Milliseconds(length: Int) extends Duration {
    require(length > 0)
    override val suffix: String = "ms"
    override val value: String = length.toString + suffix}
}
