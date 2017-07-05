package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.parameter.{IntParam, StringParam}
import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.common.Durations.Duration

/**
  *
  * @param maxParallel (int: 0) Specifies the number of task groups that can be updated at the same time.
  * @param stagger (string: "0ms") Specifies the delay between sets of updates. This is specified using a label suffix like "30s" or "1h".
  */
case class Update(
  maxParallel: Option[Int] = None,
  stagger: Option[Duration] = None
) extends Stanza {
  maxParallel.foreach(x => require(x > 0))

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(maxParallel.map(IntParam("max_parallel", _)))
    hcl.maybeAppend(stagger.map(s => StringParam("stagger", s.value)))
    hcl.close()
    hcl.result
  }
}

