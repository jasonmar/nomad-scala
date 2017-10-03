package com.jasonmar.nomad.model.common

import com.jasonmar.UnitSpec

import scala.util.Try

class DurationSpec extends UnitSpec {
  "Duration" should "print hcl" in {
    val duration = Durations.Seconds(60)
    val duration2 = Durations.Seconds(60)
    assert(duration == duration2)
    assert(duration.value == "60s")
    assert(duration.quotedValue == "\"60s\"")
    assert(duration.toString == "60s")
  }

  it should "not allow zero values" in {
    val duration = Try(Durations.Seconds(0))
    val durationValue = Try(Durations.Seconds(0).toString)
    assert(duration.isFailure)
    assert(durationValue.isFailure)
  }
}
