package com.jasonmar.nomad.model.task

import com.jasonmar.hcl._
import com.jasonmar.hcl.Printer._
import com.jasonmar.hcl.parameter.{BoolParam, StringParam}
import com.jasonmar.nomad.model.common.Durations.Duration
import com.jasonmar.nomad.model.common.{KVPair, Meta}
import com.jasonmar.nomad.model.constraint.Constraint
import com.jasonmar.nomad.model.service.{Service, User}
import com.jasonmar.nomad.model.task.artifact.Artifact
import com.jasonmar.nomad.model.task.driver.Configs.DriverConfig
import com.jasonmar.nomad.model.task.driver.Drivers.Driver
import com.jasonmar.nomad.model.task.template.Templates.Template
import com.jasonmar.nomad.model.task.resources.Resources
import com.jasonmar.nomad.model.vault.Vault

/** The `task` stanza creates an individual unit of work, such as a Docker
  * container, web application, or batch processing.
  *
  * @param name Must be unique within a Group
  * @param driver Specifies the task driver that should be used to run the task. See the [driver documentation](/docs/drivers/index.html) for what is available. Examples include `docker`, `qemu`, `java` and `exec`.
  * @param config Specifies the driver configuration, which is passed directly to the driver to start the task. The details of configurations are specific to each driver, so please see specific driver documentation for more information.
  * @param resources Specifies the minimum resource requirements such as RAM, CPU and network.
  * @param artifacts Defines an artifact to download before running the task. This may be specified multiple times to download multiple artifacts.
  * @param constraint Specifies user-defined constraints on the task. This can be provided multiple times to define additional constraints.
  * @param dispatch_payload Configures the task to have access to dispatch payloads.
  * @param env Specifies environment variables that will be passed to the running process.
  * @param kill_timeout Specifies the duration to wait for an application to gracefully quit before force-killing. Nomad sends an `SIGINT`. If the task does not exit before the configured timeout, `SIGKILL` is sent to the task. Note that the value set here is capped at the value set for [`max_kill_timeout`][max_kill] on the agent running the task, which has a default value of 30 seconds.
  * @param leader Specifies whether the task is the leader task of the task group. If set to true, when the leader task completes, all other tasks within the task group will be gracefully shutdown.
  * @param logs Specifies logging configuration for the `stdout` and `stderr` of the task.
  * @param meta Specifies a key-value map that annotates with user-defined metadata.
  * @param service Specifies integrations with [Consul][] for service discovery. Nomad automatically registers when a task is started and de-registers it when the task dies.
  * @param user Specifies the user that will run the task. Defaults to `nobody` for the [`exec`][exec] and [`java`][java] drivers. [Docker][] and [rkt][] images specify their own default users.  This can only be set on Linux platforms, and clients can restrict [which drivers][user_drivers] are allowed to run tasks as [certain users][user_blacklist].
  * @param template Specifies the set of templates to render for the task. Templates can be used to inject both static and dynamic configuration with data populated from environment variables, Consul and Vault.
  * @param vault Specifies the set of Vault policies required by the task. This overrides any `vault` block set at the `group` or `job` level.
  */
case class Task(
  name: String,
  driver: Driver,
  config: DriverConfig,
  resources: Resources,
  artifacts: Option[Seq[Artifact]] = None,
  constraint: Option[Seq[Constraint]] = None,
  dispatch_payload: Option[DispatchPayload] = None,
  env: Option[Seq[EnvVar]] = None,
  kill_timeout: Option[Duration] = None,
  leader: Option[Boolean] = None,
  logs: Option[Logs] = None,
  meta: Option[Seq[KVPair]] = None,
  service: Option[Service] = None,
  user: Option[User] = None,
  template: Option[Seq[Template]] = None,
  vault: Option[Vault] = None
) extends Stanza {
  require(name.nonEmpty)

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza, name)
    hcl.append(driver)
    hcl.append(config)
    hcl.append(resources)
    hcl.maybeAppendSeq(artifacts)
    hcl.maybeAppendSeq(constraint)
    hcl.maybeAppend(dispatch_payload)
    hcl.maybeAppend(env.map(Env))
    hcl.maybeAppend(kill_timeout.map(d => StringParam("kill_timeout", d.value)))
    hcl.maybeAppend(leader.map(BoolParam("leader", _)))
    hcl.maybeAppend(logs)
    hcl.maybeAppend(meta.map(Meta))
    hcl.maybeAppend(service)
    hcl.maybeAppend(user.map(u => StringParam("user", u.value)))
    hcl.maybeAppendSeq(template)
    hcl.maybeAppend(vault)
    hcl.close()
    hcl.result
  }
}
