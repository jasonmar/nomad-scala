package com.jasonmar.nomad.model.common

import com.jasonmar.hcl.NonEmptyValue

object Durations {
  sealed trait Duration extends NonEmptyValue {
    val length: Int
    val suffix: String
    require(length > 0)
    override val value: String = length.toString + suffix
  }
  case class Seconds(length: Int) extends Duration { override val suffix: String = "s" }
  case class Hours(length: Int) extends Duration { override val suffix: String = "m" }
  case class Minutes(length: Int) extends Duration { override val suffix: String = "h" }
  case class Milliseconds(length: Int) extends Duration { override val suffix: String = "ms" }
}
