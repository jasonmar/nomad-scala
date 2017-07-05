package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.parameter.{IntParam, StringParam}
import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.common.Durations.Duration
import com.jasonmar.nomad.model.group.RestartModes.RestartMode


/**
  *
  * @param attempts Specifies the number of restarts allowed in the configured interval. Defaults vary by job type, see below for more information.
  * @param delay (string: "15s") Specifies the duration to wait before restarting a task. This is specified using a label suffix like "30s" or "1h". A random jitter of up to 25% is added to the delay.
  * @param interval Specifies the duration which begins when the first task starts and ensures that only `attempts` number of restarts happens within it. If more than `attempts` number of failures happen, behavior is controlled by `mode`. This is specified using a label suffix like "30s" or "1h". Defaults vary by job type, see below for more information.
  * @param mode (string: "delay") Controls the behavior when the task fails more than `attempts` times in an interval. For a detailed explanation of these values and their behavior, please see the [mode values section](#mode-values).
  */
case class Restart(
  attempts: Option[Int] = None,
  delay: Option[Duration] = None,
  interval: Option[Duration] = None,
  mode: Option[RestartMode] = None
) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(attempts.map(IntParam("attempts", _)))
    hcl.maybeAppend(delay.map(d => StringParam("delay", d.value)))
    hcl.maybeAppend(interval.map(i => StringParam("interval", i.value)))
    hcl.maybeAppend(mode)
    hcl.close()
    hcl.result
  }
}
