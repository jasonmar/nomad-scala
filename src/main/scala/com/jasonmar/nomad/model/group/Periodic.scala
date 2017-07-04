package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Stanza

/** The `periodic` stanza allows a job to run at fixed times, dates, or intervals.
  * The easiest way to think about the periodic scheduler is "Nomad cron" or
  * "distributed cron".
  *
  * @param cron Specifies a cron expression configuring the interval to launch the job. In addition to [cron-specific formats][cron], this option also includes predefined expressions such as `@daily` or `@weekly`.
  * @param prohibit_overlap `(bool: false)` - Specifies if this job should wait until previous instances of this job have completed. This only applies to this job; it does not prevent other periodic jobs from running at the same time.
  * @param time_zone `(string: "UTC")` - Specifies the time zone to evaluate the next launch interval against. This is useful when wanting to account for day light savings in various time zones. The time zone must be parsable by Golang's [LoadLocation](https://golang.org/pkg/time/#LoadLocation).
  */
case class Periodic(
  cron: Cron,
  prohibit_overlap: Option[Boolean] = None,
  time_zone: Option[TimeZone] = None
) extends Stanza {
  override def printHCL: String = {
    val sb = new StringBuilder()
    sb.append(s"$stanza {\n")
    sb.append(s"  ${cron.printHCL}\n")
    prohibit_overlap match {
      case Some(b) if b =>
        sb.append("  prohibit_overlap = true\n")
      case _ =>
    }
    time_zone match {
      case Some(tz) =>
        sb.append(s"""  ${tz.printHCL}\n""")
      case _ =>
    }
    sb.append("}")
    sb.result
  }
}
