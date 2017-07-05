package com.jasonmar.nomad.model.common

object EnvironmentVariables {

  /** The job specification also allows you to specify a `meta` block to supply arbitrary
configuration to a task. This allows you to easily provide job-specific
configuration even if you use the same executable unit in multiple jobs.
    *
    * @param key key-value pairs are passed through to the job as `NOMAD_META_<key>=<value>` environment variables
    * @return
    */
  def meta(key: String) = EnvironmentVariable(s"NOMAD_META_$key") // The metadata of the task


  /** The IP of the port with the given label
    * @param label port label
    * @return
    */
  def NOMAD_IP_(label: String) = EnvironmentVariable(s"NOMAD_IP_$label")

  /** The port value with the given label
    * @param label port label
    * @return
    */
  def NOMAD_PORT_(label: String) = EnvironmentVariable(s"NOMAD_PORT_$label")

  /** The IP:Port pair of the port with the given label
    * @param label port label
    * @return
    */
  def NOMAD_ADDR_(label: String) = EnvironmentVariable(s"NOMAD_ADDR_$label")

  /** The allocated address, given as IP:Port for the given label of other tasks in the same group
    * @param task task name
    * @param label port label
    * @return
    */
  def NOMAD_ADDR_(task: String, label: String) = EnvironmentVariable(s"NOMAD_ADDR_${task}_$label")

  /** The allocated port for the given label of other tasks in the same group
    * @param task task name
    * @param label port label
    * @return
    */
  def NOMAD_PORT_(task: String, label: String) = EnvironmentVariable(s"NOMAD_PORT_${task}_$label")

  /** The allocated IP address for the given label of other tasks in the same group
    * @param task task name
    * @param label port label
    * @return
    */
  def NOMAD_IP_(task: String, label: String) = EnvironmentVariable(s"NOMAD_IP_${task}_$label")

  /** The host port for the given label if the port is port mapped
    * @param label port label
    * @return
    */
  def NOMAD_HOST_PORT_(label: String) = EnvironmentVariable(s"NOMAD_HOST_PORT_$label")

  val NOMAD_ALLOC_DIR = EnvironmentVariable("NOMAD_ALLOC_DIR") // Path to the shared alloc directory
  val NOMAD_TASK_DIR = EnvironmentVariable("NOMAD_TASK_DIR") // Path to the local task directory
  val NOMAD_SECRETS_DIR = EnvironmentVariable("NOMAD_SECRETS_DIR") // Path to the task's secrets directory
  val NOMAD_MEMORY_LIMIT = EnvironmentVariable("NOMAD_MEMORY_LIMIT") // The task's memory limit in MB
  val NOMAD_CPU_LIMIT = EnvironmentVariable("NOMAD_CPU_LIMIT") // The task's CPU limit in MHz
  val NOMAD_ALLOC_ID = EnvironmentVariable("NOMAD_ALLOC_ID") // The allocation ID of the task
  val NOMAD_ALLOC_NAME = EnvironmentVariable("NOMAD_ALLOC_NAME") // The allocation name of the task
  val NOMAD_ALLOC_INDEX = EnvironmentVariable("NOMAD_ALLOC_INDEX") // The allocation index; useful to distinguish instances of task groups
  val NOMAD_TASK_NAME = EnvironmentVariable("NOMAD_TASK_NAME") // The task's name
  val NOMAD_JOB_NAME = EnvironmentVariable("NOMAD_JOB_NAME") // The job's name
  val NOMAD_DC = EnvironmentVariable("NOMAD_DC") // The datacenter in which the allocation is running
  val NOMAD_REGION = EnvironmentVariable("NOMAD_REGION") // The region in which the allocation is running
  val VAULT_TOKEN = EnvironmentVariable("VAULT_TOKEN") // The task's Vault token. See [Vault Integration](/docs/vault-integration/index.html) for more details
}
