package com.jasonmar.nomad.model.task.resources

import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.hcl.parameter.IntParam


/**
  * The "resources" stanza describes the requirements a task needs to execute. Resource requirements include memory, network, cpu, and more.
  *
  * @param cpu Specifies the CPU required to run this task in MHz.
  * @param iops Specifies the number of IOPS required given as a weight between 0-1000.
  * @param memory Specifies the memory required in MB
  * @param network Specifies the network requirements, including static and dynamic port allocations.
  */
case class Resources(
  cpu: Option[Int] = None,
  iops: Option[Int] = None,
  memory: Option[Int] = None,
  network: Option[Network] = None
) extends Stanza {
  cpu match {
    case Some(x) =>
      require(x >= 100)
    case _ =>
  }
  iops match {
    case Some(x) =>
      require(x >= 0 && x <= 1000)
    case _ =>
  }
  memory match {
    case Some(x) =>
      require(x >= 10)
    case _ =>
  }

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.maybeAppend(cpu.map(IntParam("cpu",_)))
    hcl.maybeAppend(iops.map(IntParam("iops",_)))
    hcl.maybeAppend(memory.map(IntParam("memory",_)))
    hcl.maybeAppend(network)
    hcl.close()
    hcl.result
  }
}
