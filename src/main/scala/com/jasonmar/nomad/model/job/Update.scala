package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.Stanza
import com.jasonmar.nomad.model.common.Durations.Duration

/**
  *
  * @param maxParallel Specifies the number of task groups that can be updated at the same time.
  * @param stagger Specifies the delay between sets of updates. This is specified using a label suffix like "30s" or "1h".
  */
case class Update(
  maxParallel: Int,
  stagger: Duration) extends Stanza
{
  require(maxParallel > 0)
  override def printHCL: String = ""
}

