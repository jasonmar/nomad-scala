package com.jasonmar.nomad.model.group

import com.jasonmar.UnitSpec

class PeriodicSpec extends UnitSpec {

  "Periodic" should "print HCL" in {
    val p = Periodic(cron = Cron("*/15 * * * * *"))
    val pHCL = Seq(
      "periodic {",
      """  cron = "*/15 * * * * *"""",
      "}"
    ).mkString("\n")
    p.printHCL should be (pHCL)
  }

  it should "print HCL with options" in {
    val p = Periodic(
      cron = Cron("*/15 * * * * *"),
      prohibit_overlap = Some(true),
      time_zone = Some(TimeZone("UTC"))
    )
    val pHCL = Seq(
      "periodic {",
      """  cron = "*/15 * * * * *"""",
      "  prohibit_overlap = true",
      """  time_zone = "UTC"""",
      "}"
    ).mkString("\n")
    p.printHCL should be (pHCL)
  }
}
