package com.jasonmar.nomad.generated

object Consts {
  val NodeRegisterRequestType = 1 // iota
  val NodeDeregisterRequestType = 2 // iota
  val NodeUpdateStatusRequestType = 3 // iota
  val NodeUpdateDrainRequestType = 4 // iota
  val JobRegisterRequestType = 5 // iota
  val JobDeregisterRequestType = 6 // iota
  val EvalUpdateRequestType = 7 // iota
  val EvalDeleteRequestType = 8 // iota
  val AllocUpdateRequestType = 9 // iota
  val AllocClientUpdateRequestType = 10 // iota
  val ReconcileJobSummariesRequestType = 11 // iota
  val VaultAccessorRegisterRequestType = 12 // iota
  val VaultAccessorDegisterRequestType = 13 // iota
  val ApplyPlanResultsRequestType = 14 // iota
  // IgnoreUnknownTypeFlag is set along with a MessageType
  // to indicate that the message type can be safely ignored
  // if it is not recognized. This is for future proofing, so
  // that new commands can be added in a way that won't cause
  // old servers to crash when the FSM attempts to process them.
  val IgnoreUnknownTypeFlag = 128
  // ApiMajorVersion is returned as part of the Status.Version request.
  // It should be incremented anytime the APIs are changed in a way
  // that would break clients for sane client versioning.
  val ApiMajorVersion = 1
  // ApiMinorVersion is returned as part of the Status.Version request.
  // It should be incremented anytime the APIs are changed to allow
  // for sane client versioning. Minor changes should be compatible
  // within the major version.
  val ApiMinorVersion = 1
  val ProtocolVersion = "protocol"
  val APIMajorVersion = "api.major"
  val APIMinorVersion = "api.minor"
  val NodeStatusInit  = "initializing"
  val NodeStatusReady = "ready"
  val NodeStatusDown  = "down"
  val BytesInMegabyte = 1024 * 1024
  // JobTypeNomad is reserved for internal system tasks and is
  // always handled by the CoreScheduler.
  val JobTypeCore    = "_core"
  val JobTypeService = "service"
  val JobTypeBatch   = "batch"
  val JobTypeSystem  = "system"
  val JobStatusPending = "pending" // Pending means the job is waiting on scheduling
  val JobStatusRunning = "running" // Running means the job has non-terminal allocations
  val JobStatusDead    = "dead"    // Dead means all evaluation's and allocations are terminal
  // JobMinPriority is the minimum allowed priority
  val JobMinPriority = 1
  // JobDefaultPriority is the default priority if not
  // not specified.
  val JobDefaultPriority = 50
  // JobMaxPriority is the maximum allowed priority
  val JobMaxPriority = 100
  // Ensure CoreJobPriority is higher than any user
  // specified job so that it gets priority. This is important
  // for the system to remain healthy.
  val CoreJobPriority = JobMaxPriority * 2
  // JobTrackedVersions is the number of historic job versions that are
  // kept.
  val JobTrackedVersions = 6
  // Checks uses any registered health check state in combination with task
  // states to determine if a allocation is healthy.
  val UpdateStrategyHealthCheck_Checks = "checks"
  // TaskStates uses the task states of an allocation to determine if the
  // allocation is healthy.
  val UpdateStrategyHealthCheck_TaskStates = "task_states"
  // Manual allows the operator to manually signal to Nomad when an
  // allocations is healthy. This allows more advanced health checking that is
  // outside of the scope of Nomad.
  val UpdateStrategyHealthCheck_Manual = "manual"
  // PeriodicSpecCron is used for a cron spec.
  val PeriodicSpecCron = "cron"
  // PeriodicSpecTest is only used by unit tests. It is a sorted, comma
  // separated list of unix timestamps at which to launch.
  val PeriodicSpecTest = "_internal_test"
  // PeriodicLaunchSuffix is the string appended to the periodic jobs ID
  // when launching derived instances of it.
  val PeriodicLaunchSuffix = "/periodic-"
  val DispatchPayloadForbidden = "forbidden"
  val DispatchPayloadOptional  = "optional"
  val DispatchPayloadRequired  = "required"
  // DispatchLaunchSuffix is the string appended to the parameterized job's ID
  // when dispatching instances of it.
  val DispatchLaunchSuffix = "/dispatch-"
  // RestartPolicyModeDelay causes an artificial delay till the next interval is
  // reached when the specified attempts have been reached in the interval.
  val RestartPolicyModeDelay = "delay"
  // RestartPolicyModeFail causes a job to fail if the specified number of
  // attempts are reached within an interval.
  val RestartPolicyModeFail = "fail"
  // RestartPolicyMinInterval is the minimum interval that is accepted for a
  // restart policy.
  val RestartPolicyMinInterval = 5 * 1000 // milliseconds
  val ServiceCheckHTTP   = "http"
  val ServiceCheckTCP    = "tcp"
  val ServiceCheckScript = "script"
  // minCheckInterval is the minimum check interval permitted.  Consul
  // currently has its MinInterval set to 1s.  Mirror that here for
  // consistency.
  val minCheckInterval = 1 * 1000 // milliseconds
  // minCheckTimeout is the minimum check timeout permitted for Consul
  // script TTL checks.
  val minCheckTimeout = 1 * 1000 // milliseconds
  // DefaultKillTimeout is the default timeout between signaling a task it
  // will be killed and killing it.
  val DefaultKillTimeout = 5 * 1000 // milliseconds
  // TemplateChangeModeNoop marks that no action should be taken if the
  // template is re-rendered
  val TemplateChangeModeNoop = "noop"
  // TemplateChangeModeSignal marks that the task should be signaled if the
  // template is re-rendered
  val TemplateChangeModeSignal = "signal"
  // TemplateChangeModeRestart marks that the task should be restarted if the
  // template is re-rendered
  val TemplateChangeModeRestart = "restart"
  val TaskStatePending = "pending" // The task is waiting to be run.
  val TaskStateRunning = "running" // The task is currently running.
  val TaskStateDead    = "dead"    // Terminal state of task.
  // TaskSetupFailure indicates that the task could not be started due to a
  // a setup failure.
  val TaskSetupFailure = "Setup Failure"
  // TaskDriveFailure indicates that the task could not be started due to a
  // failure in the driver.
  val TaskDriverFailure = "Driver Failure"
  // TaskReceived signals that the task has been pulled by the client at the
  // given timestamp.
  val TaskReceived = "Received"
  // TaskFailedValidation indicates the task was invalid and as such was not
  // run.
  val TaskFailedValidation = "Failed Validation"
  // TaskStarted signals that the task was started and its timestamp can be
  // used to determine the running length of the task.
  val TaskStarted = "Started"
  // TaskTerminated indicates that the task was started and exited.
  val TaskTerminated = "Terminated"
  // TaskKilling indicates a kill signal has been sent to the task.
  val TaskKilling = "Killing"
  // TaskKilled indicates a user has killed the task.
  val TaskKilled = "Killed"
  // TaskRestarting indicates that task terminated and is being restarted.
  val TaskRestarting = "Restarting"
  // TaskNotRestarting indicates that the task has failed and is not being
  // restarted because it has exceeded its restart policy.
  val TaskNotRestarting = "Not Restarting"
  // TaskRestartSignal indicates that the task has been signalled to be
  // restarted
  val TaskRestartSignal = "Restart Signaled"
  // TaskSignaling indicates that the task is being signalled.
  val TaskSignaling = "Signaling"
  // TaskDownloadingArtifacts means the task is downloading the artifacts
  // specified in the task.
  val TaskDownloadingArtifacts = "Downloading Artifacts"
  // TaskArtifactDownloadFailed indicates that downloading the artifacts
  // failed.
  val TaskArtifactDownloadFailed = "Failed Artifact Download"
  // TaskBuildingTaskDir indicates that the task directory/chroot is being
  // built.
  val TaskBuildingTaskDir = "Building Task Directory"
  // TaskSetup indicates the task runner is setting up the task environment
  val TaskSetup = "Task Setup"
  // TaskDiskExceeded indicates that one of the tasks in a taskgroup has
  // exceeded the requested disk resources.
  val TaskDiskExceeded = "Disk Resources Exceeded"
  // TaskSiblingFailed indicates that a sibling task in the task group has
  // failed.
  val TaskSiblingFailed = "Sibling Task Failed"
  // TaskDriverMessage is an informational event message emitted by
  // drivers such as when they're performing a long running action like
  // downloading an image.
  val TaskDriverMessage = "Driver"
  // TaskLeaderDead indicates that the leader task within the has finished.
  val TaskLeaderDead = "Leader Task Dead"
  val ConstraintDistinctProperty = "distinct_property"
  val ConstraintDistinctHosts    = "distinct_hosts"
  val ConstraintRegex            = "regexp"
  val ConstraintVersion          = "version"
  val ConstraintSetContains      = "set_contains"
  // VaultChangeModeNoop takes no action when a new token is retrieved.
  val VaultChangeModeNoop = "noop"
  // VaultChangeModeSignal signals the task when a new token is retrieved.
  val VaultChangeModeSignal = "signal"
  // VaultChangeModeRestart restarts the task when a new token is retrieved.
  val VaultChangeModeRestart = "restart"
  // DeploymentStatuses are the various states a deployment can be be in
  val DeploymentStatusRunning    = "running"
  val DeploymentStatusFailed     = "failed"
  val DeploymentStatusSuccessful = "successful"
  val DeploymentStatusCancelled  = "cancelled"
  val DeploymentStatusPaused     = "paused"
  val AllocDesiredStatusRun   = "run"   // Allocation should run
  val AllocDesiredStatusStop  = "stop"  // Allocation should stop
  val AllocDesiredStatusEvict = "evict" // Allocation should stop, and was evicted
  val AllocClientStatusPending  = "pending"
  val AllocClientStatusRunning  = "running"
  val AllocClientStatusComplete = "complete"
  val AllocClientStatusFailed   = "failed"
  val AllocClientStatusLost     = "lost"
  val EvalStatusBlocked   = "blocked"
  val EvalStatusPending   = "pending"
  val EvalStatusComplete  = "complete"
  val EvalStatusFailed    = "failed"
  val EvalStatusCancelled = "canceled"
  val EvalTriggerJobRegister    = "job-register"
  val EvalTriggerJobDeregister  = "job-deregister"
  val EvalTriggerPeriodicJob    = "periodic-job"
  val EvalTriggerNodeUpdate     = "node-update"
  val EvalTriggerScheduled      = "scheduled"
  val EvalTriggerRollingUpdate  = "rolling-update"
  val EvalTriggerFailedFollowUp = "failed-follow-up"
  val EvalTriggerMaxPlans       = "max-plan-attempts"
  // CoreJobEvalGC is used for the garbage collection of evaluations
  // and allocations. We periodically scan evaluations in a terminal state,
  // in which all the corresponding allocations are also terminal. We
  // delete these out of the system to bound the state.
  val CoreJobEvalGC = "eval-gc"
  // CoreJobNodeGC is used for the garbage collection of failed nodes.
  // We periodically scan nodes in a terminal state, and if they have no
  // corresponding allocations we delete these out of the system.
  val CoreJobNodeGC = "node-gc"
  // CoreJobJobGC is used for the garbage collection of eligible jobs. We
  // periodically scan garbage collectible jobs and check if both their
  // evaluations and allocations are terminal. If so, we delete these out of
  // the system.
  val CoreJobJobGC = "job-gc"
  // CoreJobForceGC is used to force garbage collection of all GCable objects.
  val CoreJobForceGC = "force-gc"
  // MinDynamicPort is the smallest dynamic port generated
  val MinDynamicPort = 20000
  // MaxDynamicPort is the largest dynamic port generated
  val MaxDynamicPort = 60000
  // maxRandPortAttempts is the maximum number of attempt
  // to assign a random port
  val maxRandPortAttempts = 20
  // maxValidPort is the max valid port number
  val maxValidPort = 65536
  // NodeUniqueNamespace is a prefix that can be appended to node meta or
  // attribute keys to mark them for exclusion in computed node class.
  val NodeUniqueNamespace = "unique."
}