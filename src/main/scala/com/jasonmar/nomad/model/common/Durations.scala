package com.jasonmar.nomad.model.common

object Durations {
  sealed trait Duration extends NonEmptyValue {
    val length: Int
    val suffix: String
    require(length > 0)
    val value: String = length.toString + suffix
  }
  case class Seconds(length: Int) extends Duration { override val suffix: String = "s" }
  case class Hours(length: Int) extends Duration { override val suffix: String = "m" }
  case class Minutes(length: Int) extends Duration { override val suffix: String = "h" }
}
