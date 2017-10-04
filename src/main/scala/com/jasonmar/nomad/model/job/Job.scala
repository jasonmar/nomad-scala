package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.parameter.{BoolParam, SeqParam}
import com.jasonmar.hcl.{HCLBuilder, NamedStanza}
import com.jasonmar.nomad.model.common.{KVPair, Meta}
import com.jasonmar.nomad.model.constraint.Constraint
import com.jasonmar.nomad.model.group.{Group, Periodic, Region}
import com.jasonmar.nomad.model.job.JobTypes.JobType
import com.jasonmar.nomad.model.vault.{Token, Vault}

/** The `job` stanza is the top-most configuration option in the job specification.
  * A job is a declarative specification of tasks that Nomad should run. Jobs have a
  * globally unique name, one or many task groups, which are themselves collections
  * of one or many tasks.
  *
  * @param datacenters A list of datacenters in the region which are eligible for task placement. This must be provided, and does not have a default.
  * @param groups Specifies the start of a group of tasks. This can be provided multiple times to define additional groups. Group names must be unique within the job file.
  * @param all_at_once Controls if the entire set of tasks in the job must be placed atomically or if they can be scheduled incrementally. This should only be used for special circumstances.
  * @param constraints This can be provided multiple times to define additional constraints. See the [Nomad constraint reference](/docs/job-specification/constraint.html) for more details.
  * @param meta Specifies a key-value map that annotates with user-defined metadata
  * @param parameterized Specifies the job as a parameterized job such that it can be dispatched against.
  * @param periodic Allows the job to be scheduled at fixed times, dates or intervals.
  * @param priority Specifies the job priority which is used to prioritize scheduling and access to resources. Must be between 1 and 100 inclusively, with a larger value corresponding to a higher priority.
  * @param region The region in which to execute the job.
  * @param jobType Specifies the [Nomad scheduler][scheduler] to use. Nomad provides the `service`, `system: and `batch: schedulers.
  * @param update Specifies the task's update strategy. When omitted, rolling updates are disabled.
  * @param vault Specifies the set of Vault policies required by all tasks in this job.
  * @param vault_token Specifies the Vault token that proves the submitter of the job has access to the specified policies in the [`vault`][vault] stanza. This field is only used to transfer the token and is not stored after job submission.
  *   It is **strongly discouraged** to place the token as a configuration parameter like this, since the token could be checked into source control accidentally. Users should set the `VAULT_TOKEN: environment variable when running the job instead.
  */
case class Job(
  name: String,
  datacenters: Seq[Datacenter],
  groups: Seq[Group],
  all_at_once: Option[Boolean] = None,
  constraints: Option[Seq[Constraint]] = None,
  meta: Option[Seq[KVPair]] = None,
  parameterized: Option[Parameterized] = None,
  periodic: Option[Periodic] = None,
  priority: Option[Priority] = None,
  region: Option[Region] = None,
  jobType: Option[JobType] = None,
  update: Option[Update] = None,
  vault: Option[Vault] = None,
  vault_token: Option[Token] = None
) extends NamedStanza {

  require(datacenters.nonEmpty)
  require(groups.nonEmpty)

  override def printHCL: String = {
    val sb = new HCLBuilder()
    sb.open(stanza, name)
    sb.append(SeqParam("datacenters", datacenters))
    sb.appendSeq(groups)
    sb.maybeAppend(all_at_once.map(BoolParam("all_at_once",_)))
    sb.maybeAppendSeq(constraints)
    sb.maybeAppend(meta.map(Meta))
    sb.maybeAppend(parameterized)
    sb.maybeAppend(periodic)
    sb.maybeAppend(priority)
    sb.maybeAppend(region)
    sb.maybeAppend(jobType)
    sb.maybeAppend(update)
    sb.maybeAppend(vault)
    sb.maybeAppend(vault_token)
    sb.close()
    sb.result
  }
}