package com.jasonmar.nomad.model.task.resources

import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.hcl.parameter.IntParam


/** The "network" stanza specifies the networking requirements for the task, including the minimum bandwidth and port allocations.
  *
  * @param mbits `(int: 10)` - Specifies the bandwidth required in MBits.
  * @param port Specifies a TCP/UDP port allocation and can be used to specify both dynamic ports and reserved ports.
  */
case class Network(mbits: Option[Int] = None, port: Option[Seq[PortAllocation]] = None) extends Stanza {
  override def printHCL = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(mbits.map(IntParam("mbits", _)))
    hcl.maybeAppendSeq(port)
    hcl.close()
    hcl.result
  }
}

