package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.hcl.parameter.IntParam
import com.jasonmar.nomad.model.common.{KVPair, Meta}
import com.jasonmar.nomad.model.constraint.Constraint
import com.jasonmar.nomad.model.task.Task
import com.jasonmar.nomad.model.vault.Vault

/** The `group` stanza defines a series of tasks that should be co-located on the
  * same Nomad client. Any [task][] within a group will be placed on the same
  * client.
  *
  * @param name Must be unique within a Job
  * @param tasks Specifies one or more tasks to run within this group. This can be specified multiple times, to add a task as part of the group.
  * @param constraints This can be provided multiple times to define additional constraints.
  * @param count Specifies the number of the task groups that should be running under this group. This value must be non-negative.
  * @param ephemeralDisk Specifies the ephemeral disk requirements of the group. Ephemeral disks can be marked as sticky and support live data migrations.
  * @param meta Specifies a key-value map that annotates with user-defined metadata.
  * @param restart Specifies the restart policy for all tasks in this group. If omitted, a default policy exists for each job type, which can be found in the [restart stanza documentation][restart].
  * @param vault Specifies the set of Vault policies required by all tasks in this group. Overrides a `vault` block set at the `job` level.
  */
case class Group(
  name: String,
  tasks: Seq[Task],
  constraints: Option[Seq[Constraint]] = None,
  count: Option[Int] = None,
  ephemeralDisk: Option[EphemeralDisk] = None,
  meta: Option[Seq[KVPair]] = None,
  restart: Option[Restart] = None,
  vault: Option[Vault] = None
) extends Stanza {
  require(name.nonEmpty)
  count match {
    case Some(x) =>
      require(x >= 0)
    case _ =>
  }
  require(tasks.nonEmpty)
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza, name)
    hcl.appendSeq(tasks)
    hcl.maybeAppendSeq(constraints)
    hcl.maybeAppend(count.map(IntParam("count",_)))
    hcl.maybeAppend(ephemeralDisk)
    hcl.maybeAppend(meta.map(Meta))
    hcl.maybeAppend(restart)
    hcl.maybeAppend(vault)
    hcl.close()
    hcl.result
  }
}