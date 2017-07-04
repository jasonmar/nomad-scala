package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Stanza
import com.jasonmar.nomad.model.common.Durations.Duration
import com.jasonmar.nomad.model.group.RestartModes.RestartMode


/**
  *
  * @param attempts Specifies the number of restarts allowed in the configured interval. Defaults vary by job type, see below for more information.
  * @param delay Specifies the duration to wait before restarting a task. This is specified using a label suffix like "30s" or "1h". A random jitter of up to 25% is added to the delay.
  * @param interval Specifies the duration which begins when the first task starts and ensures that only `attempts` number of restarts happens within it. If more than `attempts` number of failures happen, behavior is controlled by `mode`. This is specified using a label suffix like "30s" or "1h". Defaults vary by job type, see below for more information.
  * @param mode Controls the behavior when the task fails more than `attempts` times in an interval. For a detailed explanation of these values and their behavior, please see the [mode values section](#mode-values).
  */
case class Restart(
  attempts: Int,
  delay: Duration,
  interval: Duration,
  mode: RestartMode
) extends Stanza {
  override def printHCL: String = "" // TODO implement
}
