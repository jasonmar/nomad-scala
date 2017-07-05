package com.jasonmar.nomad.generated

object Types {

  type MessageType = Int

  // QueryOptions is used to specify various flags for read queries
  case class QueryOptions (
    // The target region for this query
    // If set, wait until query exceeds given index. Must be provided
    // with MaxQueryTime.
    // Provided with MinQueryIndex to wait for change.
    // If set, any follower can service the request. Results
    // may be arbitrarily stale.
    // If set, used as prefix for resource list searches
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  case class WriteRequest (
    // The target region for this write
    Region: String
  )


  // QueryMeta allows a query response to include potentially
  // useful metadata about a query
  case class QueryMeta (
    // This is the index associated with the read
    // If AllowStale is used, this is time elapsed since
    // last contact between the follower and leader. This
    // can be used to gauge staleness.
    // Used to indicate if there is a known leader node
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // WriteMeta allows a write response to include potentially
  // useful metadata about the write
  case class WriteMeta (
    // This is the index associated with the write
    Index: Long
  )


  // NodeRegisterRequest is used for Node.Register endpoint
  // to register a node as being a schedulable entity.
  case class NodeRegisterRequest (
    Node: Node,
    Region: String
  )


  // NodeDeregisterRequest is used for Node.Deregister endpoint
  // to deregister a node as being a schedulable entity.
  case class NodeDeregisterRequest (
    NodeID: String,
    Region: String
  )


  // NodeServerInfo is used to in NodeUpdateResponse to return Nomad server
  // information used in RPC server lists.
  case class NodeServerInfo (
    // RPCAdvertiseAddr is the IP endpoint that a Nomad Server wishes to
    // be contacted at for RPCs.
    // RpcMajorVersion is the major version number the Nomad Server
    // supports
    // RpcMinorVersion is the minor version number the Nomad Server
    // supports
    // Datacenter is the datacenter that a Nomad server belongs to
    RPCAdvertiseAddr: String,
    RPCMajorVersion: Int,
    RPCMinorVersion: Int,
    Datacenter: String
  )


  // NodeUpdateStatusRequest is used for Node.UpdateStatus endpoint
  // to update the status of a node.
  case class NodeUpdateStatusRequest (
    NodeID: String,
    Status: String,
    Region: String
  )


  // NodeUpdateDrainRequest is used for updatin the drain status
  case class NodeUpdateDrainRequest (
    NodeID: String,
    Drain: Boolean,
    Region: String
  )


  // NodeEvaluateRequest is used to re-evaluate the ndoe
  case class NodeEvaluateRequest (
    NodeID: String,
    Region: String
  )


  // NodeSpecificRequest is used when we just need to specify a target node
  case class NodeSpecificRequest (
    NodeID: String,
    SecretID: String,
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // JobRegisterRequest is used for Job.Register endpoint
  // to register a job as being a schedulable entity.
  case class JobRegisterRequest (
    // If EnforceIndex is set then the job will only be registered if the passed
    // JobModifyIndex matches the current Jobs index. If the index is zero, the
    // register only occurs if the job is new.
    Job: Job,
    EnforceIndex: Boolean,
    JobModifyIndex: Long,
    Region: String
  )


  // JobDeregisterRequest is used for Job.Deregister endpoint
  // to deregister a job as being a schedulable entity.
  case class JobDeregisterRequest (
    // Purge controls whether the deregister purges the job from the system or
    // whether the job is just marked as stopped and will be removed by the
    // garbage collector
    JobID: String,
    Purge: Boolean,
    Region: String
  )


  // JobEvaluateRequest is used when we just need to re-evaluate a target job
  case class JobEvaluateRequest (
    JobID: String,
    Region: String
  )


  // JobSpecificRequest is used when we just need to specify a target job
  case class JobSpecificRequest (
    JobID: String,
    AllAllocs: Boolean,
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // JobListRequest is used to parameterize a list request
  case class JobListRequest (
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // JobPlanRequest is used for the Job.Plan endpoint to trigger a dry-run
  // evaluation of the Job.
  case class JobPlanRequest (
    Job: Job,
    Region: String
  )


  // JobSummaryRequest is used when we just need to get a specific job summary
  case class JobSummaryRequest (
    JobID: String,
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // JobDispatchRequest is used to dispatch a job based on a parameterized job
  case class JobDispatchRequest (
    JobID: String,
    Payload: Array[Byte],
    Meta: Map[String,String],
    Region: String
  )


  // JobValidateRequest is used to validate a job
  case class JobValidateRequest (
    Job: Job,
    Region: String
  )


  // JobRevertRequest is used to revert a job to a prior version.
  case class JobRevertRequest (
    // JobID is the ID of the job  being reverted
    // JobVersion the version to revert to.
    // EnforcePriorVersion if set will enforce that the job is at the given
    // version before reverting.
    JobID: String,
    JobVersion: Long,
    EnforcePriorVersion: Long,
    Region: String
  )


  // NodeListRequest is used to parameterize a list request
  case class NodeListRequest (
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // EvalUpdateRequest is used for upserting evaluations.
  case class EvalUpdateRequest (
    Evals: Array[Evaluation],
    EvalToken: String,
    Region: String
  )


  // EvalDeleteRequest is used for deleting an evaluation.
  case class EvalDeleteRequest (
    Evals: Array[String],
    Allocs: Array[String],
    Region: String
  )


  // EvalSpecificRequest is used when we just need to specify a target evaluation
  case class EvalSpecificRequest (
    EvalID: String,
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // EvalAckRequest is used to Ack/Nack a specific evaluation
  case class EvalAckRequest (
    EvalID: String,
    Token: String,
    Region: String
  )


  // EvalDequeueRequest is used when we want to dequeue an evaluation
  case class EvalDequeueRequest (
    Schedulers: Array[String],
    Timeout: Long,
    SchedulerVersion: Int,
    Region: String
  )


  // EvalListRequest is used to list the evaluations
  case class EvalListRequest (
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // PlanRequest is used to submit an allocation plan to the leader
  case class PlanRequest (
    Plan: Plan,
    Region: String
  )


  // ApplyPlanResultsRequest is used by the planner to apply a Raft transaction
  // committing the result of a plan.
  case class ApplyPlanResultsRequest (
    // AllocUpdateRequest holds the allocation updates to be made by the
    // scheduler.
    // CreatedDeployment is the deployment created as a result of a scheduling
    // event. Any existing deployment should be cancelled when the new
    // deployment is created.
    // DeploymentUpdates is a set of status updates to apply to the given
    // deployments. This allows the scheduler to cancel any unneeded deployment
    // because the job is stopped or the update block is removed.
    CreatedDeployment: Deployment,
    DeploymentUpdates: Array[DeploymentStatusUpdate]
  )


  // AllocUpdateRequest is used to submit changes to allocations, either
  // to cause evictions or to assign new allocaitons. Both can be done
  // within a single transaction
  case class AllocUpdateRequest (
    // Alloc is the list of new allocations to assign
    // Job is the shared parent job of the allocations.
    // It is pulled out since it is common to reduce payload size.
    Alloc: Array[Allocation],
    Job: Job,
    Region: String
  )


  // AllocListRequest is used to request a list of allocations
  case class AllocListRequest (
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // AllocSpecificRequest is used to query a specific allocation
  case class AllocSpecificRequest (
    AllocID: String,
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // AllocsGetRequest is used to query a set of allocations
  case class AllocsGetRequest (
    AllocIDs: Array[String],
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // PeriodicForceReqeuest is used to force a specific periodic job.
  case class PeriodicForceRequest (
    JobID: String,
    Region: String
  )


  // ServerMembersResponse has the list of servers in a cluster
  case class ServerMembersResponse (
    ServerName: String,
    ServerRegion: String,
    ServerDC: String,
    Members: Array[ServerMember]
  )


  // ServerMember holds information about a Nomad server agent in a cluster
  case class ServerMember (
    Name: String,
    Addr: String,
    Port: Int,
    Tags: Map[String,String],
    Status: String,
    ProtocolMin: Int,
    ProtocolMax: Int,
    ProtocolCur: Int,
    DelegateMin: Int,
    DelegateMax: Int,
    DelegateCur: Int
  )


  // DeriveVaultTokenRequest is used to request wrapped Vault tokens for the
  // following tasks in the given allocation
  case class DeriveVaultTokenRequest (
    NodeID: String,
    SecretID: String,
    AllocID: String,
    Tasks: Array[String],
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // VaultAccessorsRequest is used to operate on a set of Vault accessors
  case class VaultAccessorsRequest (
    Accessors: Array[VaultAccessor]
  )


  // VaultAccessor is a reference to a created Vault token on behalf of
  // an allocation's task.
  case class VaultAccessor (
    // Raft Indexes
    AllocID: String,
    Task: String,
    NodeID: String,
    Accessor: String,
    CreationTTL: Int,
    CreateIndex: Long
  )


  // DeriveVaultTokenResponse returns the wrapped tokens for each requested task
  case class DeriveVaultTokenResponse (
    // Tasks is a mapping between the task name and the wrapped token
    // Error stores any error that occured. Errors are stored here so we can
    // communicate whether it is retriable
    Tasks: Map[String,String],
    Error: RecoverableError,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // GenericRequest is used to request where no
  // specific information is needed.
  case class GenericRequest (
    Region: String,
    MinQueryIndex: Long,
    MaxQueryTime: Long,
    AllowStale: Boolean,
    Prefix: String
  )


  // GenericResponse is used to respond to a request where no
  // specific response information is needed.
  case class GenericResponse (
    Index: Long
  )


  // VersionResponse is used for the Status.Version reseponse
  case class VersionResponse (
    Build: String,
    Versions: Map[String,Int],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobRegisterResponse is used to respond to a job registration
  case class JobRegisterResponse (
    // Warnings contains any warnings about the given job. These may include
    // deprecation warnings.
    EvalID: String,
    EvalCreateIndex: Long,
    JobModifyIndex: Long,
    Warnings: String,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobDeregisterResponse is used to respond to a job deregistration
  case class JobDeregisterResponse (
    EvalID: String,
    EvalCreateIndex: Long,
    JobModifyIndex: Long,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobValidateResponse is the response from validate request
  case class JobValidateResponse (
    // DriverConfigValidated indicates whether the agent validated the driver
    // config
    // ValidationErrors is a list of validation errors
    // Error is a string version of any error that may have occured
    // Warnings contains any warnings about the given job. These may include
    // deprecation warnings.
    DriverConfigValidated: Boolean,
    ValidationErrors: Array[String],
    Error: String,
    Warnings: String
  )


  // NodeUpdateResponse is used to respond to a node update
  case class NodeUpdateResponse (
    // LeaderRPCAddr is the RPC address of the current Raft Leader.  If
    // empty, the current Nomad Server is in the minority of a partition.
    // NumNodes is the number of Nomad nodes attached to this quorum of
    // Nomad Servers at the time of the response.  This value can
    // fluctuate based on the health of the cluster between heartbeats.
    // Servers is the full list of known Nomad servers in the local
    // region.
    HeartbeatTTL: Long,
    EvalIDs: Array[String],
    EvalCreateIndex: Long,
    NodeModifyIndex: Long,
    LeaderRPCAddr: String,
    NumNodes: Int,
    Servers: Array[NodeServerInfo],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // NodeDrainUpdateResponse is used to respond to a node drain update
  case class NodeDrainUpdateResponse (
    EvalIDs: Array[String],
    EvalCreateIndex: Long,
    NodeModifyIndex: Long,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // NodeAllocsResponse is used to return allocs for a single node
  case class NodeAllocsResponse (
    Allocs: Array[Allocation],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // NodeClientAllocsResponse is used to return allocs meta data for a single node
  case class NodeClientAllocsResponse (
    Allocs: Map[String,Long],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // SingleNodeResponse is used to return a single node
  case class SingleNodeResponse (
    Node: Node,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // NodeListResponse is used for a list request
  case class NodeListResponse (
    Nodes: Array[NodeListStub],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // SingleJobResponse is used to return a single job
  case class SingleJobResponse (
    Job: Job,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobSummaryResponse is used to return a single job summary
  case class JobSummaryResponse (
    JobSummary: JobSummary,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  case class JobDispatchResponse (
    DispatchedJobID: String,
    EvalID: String,
    EvalCreateIndex: Long,
    JobCreateIndex: Long,
    Index: Long
  )


  // JobListResponse is used for a list request
  case class JobListResponse (
    Jobs: Array[JobListStub],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobVersionsResponse is used for a job get versions request
  case class JobVersionsResponse (
    Versions: Array[Job],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobPlanResponse is used to respond to a job plan request
  case class JobPlanResponse (
    // Annotations stores annotations explaining decisions the scheduler made.
    // FailedTGAllocs is the placement failures per task group.
    // JobModifyIndex is the modification index of the job. The value can be
    // used when running `nomad run` to ensure that the Job wasn’t modified
    // since the last plan. If the job is being created, the value is zero.
    // CreatedEvals is the set of evaluations created by the scheduler. The
    // reasons for this can be rolling-updates or blocked evals.
    // Diff contains the diff of the job and annotations on whether the change
    // causes an in-place update or create/destroy
    // NextPeriodicLaunch is the time duration till the job would be launched if
    // submitted.
    // Warnings contains any warnings about the given job. These may include
    // deprecation warnings.
    Annotations: PlanAnnotations,
    FailedTGAllocs: Map[String,AllocMetric],
    JobModifyIndex: Long,
    CreatedEvals: Array[Evaluation],
    Diff: JobDiff,
    NextPeriodicLaunch: Long,
    Warnings: String,
    Index: Long
  )


  // SingleAllocResponse is used to return a single allocation
  case class SingleAllocResponse (
    Alloc: Allocation,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // AllocsGetResponse is used to return a set of allocations
  case class AllocsGetResponse (
    Allocs: Array[Allocation],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobAllocationsResponse is used to return the allocations for a job
  case class JobAllocationsResponse (
    Allocations: Array[AllocListStub],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // JobEvaluationsResponse is used to return the evaluations for a job
  case class JobEvaluationsResponse (
    Evaluations: Array[Evaluation],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // SingleEvalResponse is used to return a single evaluation
  case class SingleEvalResponse (
    Eval: Evaluation,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // EvalDequeueResponse is used to return from a dequeue
  case class EvalDequeueResponse (
    Eval: Evaluation,
    Token: String,
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // PlanResponse is used to return from a PlanRequest
  case class PlanResponse (
    Result: PlanResult,
    Index: Long
  )


  // AllocListResponse is used for a list request
  case class AllocListResponse (
    Allocations: Array[AllocListStub],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // EvalListResponse is used for a list request
  case class EvalListResponse (
    Evaluations: Array[Evaluation],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // EvalAllocationsResponse is used to return the allocations for an evaluation
  case class EvalAllocationsResponse (
    Allocations: Array[AllocListStub],
    Index: Long,
    LastContact: Long,
    KnownLeader: Boolean
  )


  // PeriodicForceResponse is used to respond to a periodic job force launch
  case class PeriodicForceResponse (
    EvalID: String,
    EvalCreateIndex: Long,
    Index: Long
  )


  // Node is a representation of a schedulable client node
  case class Node (
    // ID is a unique identifier for the node. It can be constructed
    // by doing a concatenation of the Name and Datacenter as a simple
    // approach. Alternatively a UUID may be used.
    // SecretID is an ID that is only known by the Node and the set of Servers.
    // It is not accessible via the API and is used to authenticate nodes
    // conducting priviledged activities.
    // Datacenter for this node
    // Node name
    // HTTPAddr is the address on which the Nomad client is listening for http
    // requests
    // TLSEnabled indicates if the Agent has TLS enabled for the HTTP API
    // Attributes is an arbitrary set of key/value
    // data that can be used for constraints. Examples
    // include "kernel.name=linux", "arch=386", "driver.docker=1",
    // "docker.runtime=1.8.3"
    // Resources is the available resources on the client.
    // For example 'cpu=2' 'memory=2048'
    // Reserved is the set of resources that are reserved,
    // and should be subtracted from the total resources for
    // the purposes of scheduling. This may be provide certain
    // high-watermark tolerances or because of external schedulers
    // consuming resources.
    // Links are used to 'link' this client to external
    // systems. For example 'consul=foo.dc1' 'aws=i-83212'
    // 'ami=ami-123'
    // Meta is used to associate arbitrary metadata with this
    // client. This is opaque to Nomad.
    // NodeClass is an opaque identifier used to group nodes
    // together for the purpose of determining scheduling pressure.
    // ComputedClass is a unique id that identifies nodes with a common set of
    // attributes and capabilities.
    // Drain is controlled by the servers, and not the client.
    // If true, no jobs will be scheduled to this node, and existing
    // allocations will be drained.
    // Status of this node
    // StatusDescription is meant to provide more human useful information
    // StatusUpdatedAt is the time stamp at which the state of the node was
    // updated
    // Raft Indexes
    ID: String,
    SecretID: String,
    Datacenter: String,
    Name: String,
    HTTPAddr: String,
    TLSEnabled: Boolean,
    Attributes: Map[String,String],
    Resources: Resources,
    Reserved: Resources,
    Links: Map[String,String],
    Meta: Map[String,String],
    NodeClass: String,
    ComputedClass: String,
    Drain: Boolean,
    Status: String,
    StatusDescription: String,
    StatusUpdatedAt: Long,
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // NodeListStub is used to return a subset of job information
  // for the job list
  case class NodeListStub (
    ID: String,
    Datacenter: String,
    Name: String,
    NodeClass: String,
    Drain: Boolean,
    Status: String,
    StatusDescription: String,
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // Resources is used to define the resources available
  // on a client
  case class Resources (
    CPU: Int,
    MemoryMB: Int,
    DiskMB: Int,
    IOPS: Int,
    Networks: Array[NetworkResource]
  )


  case class Port (
    Label: String,
    Value: Int
  )


  // NetworkResource is used to represent available network
  // resources
  case class NetworkResource (

  )


  // Job is the scope of a scheduling request to Nomad. It is the largest
  // scoped object, and is a named collection of task groups. Each task group
  // is further composed of tasks. A task group (TG) is the unit of scheduling
  // however.
  case class Job (
    // Stop marks whether the user has stopped the job. A stopped job will
    // have all created allocations stopped and acts as a way to stop a job
    // without purging it from the system. This allows existing allocs to be
    // queried and the job to be inspected as it is being killed.
    // Region is the Nomad region that handles scheduling this job
    // ID is a unique identifier for the job per region. It can be
    // specified hierarchically like LineOfBiz/OrgName/Team/Project
    // ParentID is the unique identifier of the job that spawned this job.
    // Name is the logical name of the job used to refer to it. This is unique
    // per region, but not unique globally.
    // Type is used to control various behaviors about the job. Most jobs
    // are service jobs, meaning they are expected to be long lived.
    // Some jobs are batch oriented meaning they run and then terminate.
    // This can be extended in the future to support custom schedulers.
    // Priority is used to control scheduling importance and if this job
    // can preempt other jobs.
    // AllAtOnce is used to control if incremental scheduling of task groups
    // is allowed or if we must do a gang scheduling of the entire job. This
    // can slow down larger jobs if resources are not available.
    // Datacenters contains all the datacenters this job is allowed to span
    // Constraints can be specified at a job level and apply to
    // all the task groups and tasks.
    // TaskGroups are the collections of task groups that this job needs
    // to run. Each task group is an atomic unit of scheduling and placement.
    // COMPAT: Remove in 0.7.0. Stagger is deprecated in 0.6.0.
    // Periodic is used to define the interval the job is run at.
    // ParameterizedJob is used to specify the job as a parameterized job
    // for dispatching.
    // Payload is the payload supplied when the job was dispatched.
    // Meta is used to associate arbitrary metadata with this
    // job. This is opaque to Nomad.
    // VaultToken is the Vault token that proves the submitter of the job has
    // access to the specified Vault policies. This field is only used to
    // transfer the token and is not stored after Job submission.
    // Job status
    // StatusDescription is meant to provide more human useful information
    // Stable marks a job as stable. Stability is only defined on "service" and
    // "system" jobs. The stability of a job will be set automatically as part
    // of a deployment and can be manually set via APIs.
    // Version is a monitonically increasing version number that is incremened
    // on each job register.
    // Raft Indexes
    Stop: Boolean,
    Region: String,
    ID: String,
    ParentID: String,
    Name: String,
    Type: String,
    Priority: Int,
    AllAtOnce: Boolean,
    Datacenters: Array[String],
    Constraints: Array[Constraint],
    TaskGroups: Array[TaskGroup],
    Update: UpdateStrategy,
    Periodic: PeriodicConfig,
    ParameterizedJob: ParameterizedJobConfig,
    Payload: Array[Byte],
    Meta: Map[String,String],
    VaultToken: String,
    Status: String,
    StatusDescription: String,
    Stable: Boolean,
    Version: Long,
    CreateIndex: Long,
    ModifyIndex: Long,
    JobModifyIndex: Long
  )


  // JobListStub is used to return a subset of job information
  // for the job list
  case class JobListStub (
    ID: String,
    ParentID: String,
    Name: String,
    Type: String,
    Priority: Int,
    Periodic: Boolean,
    ParameterizedJob: Boolean,
    Stop: Boolean,
    Status: String,
    StatusDescription: String,
    JobSummary: JobSummary,
    CreateIndex: Long,
    ModifyIndex: Long,
    JobModifyIndex: Long
  )


  // JobSummary summarizes the state of the allocations of a job
  case class JobSummary (
    // Summmary contains the summary per task group for the Job
    // Children contains a summary for the children of this job.
    // Raft Indexes
    JobID: String,
    Summary: Map[String,TaskGroupSummary],
    Children: JobChildrenSummary,
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // JobChildrenSummary contains the summary of children job statuses
  case class JobChildrenSummary (
    Pending: Long,
    Running: Long,
    Dead: Long
  )


  // TaskGroup summarizes the state of all the allocations of a particular
  // TaskGroup
  case class TaskGroupSummary (
    Queued: Int,
    Complete: Int,
    Failed: Int,
    Running: Int,
    Starting: Int,
    Lost: Int
  )


  // UpdateStrategy is used to modify how updates are done
  case class UpdateStrategy (
    // COMPAT: Remove in 0.7.0. Stagger is deprecated in 0.6.0.
    // MaxParallel is how many updates can be done in parallel
    // HealthCheck specifies the mechanism in which allocations are marked
    // healthy or unhealthy as part of a deployment.
    // MinHealthyTime is the minimum time an allocation must be in the healthy
    // state before it is marked as healthy, unblocking more alllocations to be
    // rolled.
    // HealthyDeadline is the time in which an allocation must be marked as
    // healthy before it is automatically transistioned to unhealthy. This time
    // period doesn't count against the MinHealthyTime.
    // AutoRevert declares that if a deployment fails because of unhealthy
    // allocations, there should be an attempt to auto-revert the job to a
    // stable version.
    // Canary is the number of canaries to deploy when a change to the task
    // group is detected.
    Stagger: Long,
    MaxParallel: Int,
    HealthCheck: String,
    MinHealthyTime: Long,
    HealthyDeadline: Long,
    AutoRevert: Boolean,
    Canary: Int
  )


  // Periodic defines the interval a job should be run at.
  case class PeriodicConfig (
    // Enabled determines if the job should be run periodically.
    // Spec specifies the interval the job should be run as. It is parsed based
    // on the SpecType.
    // SpecType defines the format of the spec.
    // ProhibitOverlap enforces that spawned jobs do not run in parallel.
    // TimeZone is the user specified string that determines the time zone to
    // launch against. The time zones must be specified from IANA Time Zone
    // database, such as "America/New_York".
    // Reference: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
    // Reference: https://www.iana.org/time-zones
    // location is the time zone to evaluate the launch time against
    Enabled: Boolean,
    Spec: String,
    SpecType: String,
    ProhibitOverlap: Boolean,
    TimeZone: String,
    location: String
  )


  // PeriodicLaunch tracks the last launch time of a periodic job.
  case class PeriodicLaunch (
    // Raft Indexes
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // ParameterizedJobConfig is used to configure the parameterized job
  case class ParameterizedJobConfig (
    // Payload configure the payload requirements
    // MetaRequired is metadata keys that must be specified by the dispatcher
    // MetaOptional is metadata keys that may be specified by the dispatcher
    Payload: String,
    MetaRequired: Array[String],
    MetaOptional: Array[String]
  )


  // DispatchPayloadConfig configures how a task gets its input from a job dispatch
  case class DispatchPayloadConfig (
    // File specifies a relative path to where the input data should be written
    File: String
  )


  // RestartPolicy configures how Tasks are restarted when they crash or fail.
  case class RestartPolicy (
    // Attempts is the number of restart that will occur in an interval.
    // Interval is a duration in which we can limit the number of restarts
    // within.
    // Delay is the time between a failure and a restart.
    // Mode controls what happens when the task restarts more than attempt times
    // in an interval.
    Attempts: Int,
    Interval: Long,
    Delay: Long,
    Mode: String
  )


  // TaskGroup is an atomic unit of placement. Each task group belongs to
  // a job and may contain any number of tasks. A task group support running
  // in many replicas using the same configuration..
  case class TaskGroup (
    // Name of the task group
    // Count is the number of replicas of this task group that should
    // be scheduled.
    // Update is used to control the update strategy for this task group
    // Constraints can be specified at a task group level and apply to
    // all the tasks contained.
    //RestartPolicy of a TaskGroup
    // Tasks are the collection of tasks that this task group needs to run
    // EphemeralDisk is the disk resources that the task group requests
    // Meta is used to associate arbitrary metadata with this
    // task group. This is opaque to Nomad.
    Name: String,
    Count: Int,
    Update: UpdateStrategy,
    Constraints: Array[Constraint],
    RestartPolicy: RestartPolicy,
    Tasks: Array[Task],
    EphemeralDisk: EphemeralDisk,
    Meta: Map[String,String]
  )


  // The ServiceCheck data model represents the consul health check that
  // Nomad registers for a Task
  case class ServiceCheck (

  )


  // Service represents a Consul service definition in Nomad
  case class Service (
    // Name of the service registered with Consul. Consul defaults the
    // Name to ServiceID if not specified.  The Name if specified is used
    // as one of the seed values when generating a Consul ServiceID.
    // PortLabel is either the numeric port number or the `host:port`.
    // To specify the port number using the host's Consul Advertise
    // address, specify an empty host in the PortLabel (e.g. `:port`).
    Name: String,
    PortLabel: String
  )


  // LogConfig provides configuration for log rotation
  case class LogConfig (
    MaxFiles: Int,
    MaxFileSizeMB: Int
  )


  // Task is a single process typically that is executed as part of a task group.
  case class Task (
    // Name of the task
    // Driver is used to control which driver is used
    // User is used to determine which user will run the task. It defaults to
    // the same user the Nomad client is being run as.
    // Config is provided to the driver to initialize
    // Map of environment variables to be used by the driver
    // List of service definitions exposed by the Task
    // Vault is used to define the set of Vault policies that this task should
    // have access to.
    // Templates are the set of templates to be rendered for the task.
    // Constraints can be specified at a task level and apply only to
    // the particular task.
    // Resources is the resources needed by this task
    // DispatchPayload configures how the task retrieves its input from a dispatch
    // Meta is used to associate arbitrary metadata with this
    // task. This is opaque to Nomad.
    // KillTimeout is the time between signaling a task that it will be
    // killed and killing it.
    // LogConfig provides configuration for log rotation
    // Artifacts is a list of artifacts to download and extract before running
    // the task.
    // Leader marks the task as the leader within the group. When the leader
    // task exits, other tasks will be gracefully terminated.
    Name: String,
    Driver: String,
    User: String,
    Config: Map[String,Any],
    Env: Map[String,String],
    Services: Array[Service],
    Vault: Vault,
    Templates: Array[Template],
    Constraints: Array[Constraint],
    Resources: Resources,
    DispatchPayload: DispatchPayloadConfig,
    Meta: Map[String,String],
    KillTimeout: Long,
    LogConfig: LogConfig,
    Artifacts: Array[TaskArtifact],
    Leader: Boolean
  )


  // Template represents a template configuration to be rendered for a given task
  case class Template (
    // SourcePath is the path to the template to be rendered
    // DestPath is the path to where the template should be rendered
    // EmbeddedTmpl store the raw template. This is useful for smaller templates
    // where they are embedded in the job file rather than sent as an artificat
    // ChangeMode indicates what should be done if the template is re-rendered
    // ChangeSignal is the signal that should be sent if the change mode
    // requires it.
    // Splay is used to avoid coordinated restarts of processes by applying a
    // random wait between 0 and the given splay value before signalling the
    // application of a change
    // Perms is the permission the file should be written out with.
    // LeftDelim and RightDelim are optional configurations to control what
    // delimiter is utilized when parsing the template.
    // Envvars enables exposing the template as environment variables
    // instead of as a file. The template must be of the form:
    //
    //	VAR_NAME_1={{ key service/my-key }}
    //	VAR_NAME_2=raw string and {{ env "attr.kernel.name" }}
    //
    // Lines will be split on the initial "=" with the first part being the
    // key name and the second part the value.
    // Empty lines and lines starting with # will be ignored, but to avoid
    // escaping issues #s within lines will not be treated as comments.
    SourcePath: String,
    DestPath: String,
    EmbeddedTmpl: String,
    ChangeMode: String,
    ChangeSignal: String,
    Splay: Long,
    Perms: String,
    LeftDelim: String,
    RightDelim: String,
    Envvars: Boolean
  )


  // TaskState tracks the current state of a task and events that caused state
  // transitions.
  case class TaskState (
    // The current state of the task.
    // Failed marks a task as having failed
    // StartedAt is the time the task is started. It is updated each time the
    // task starts
    // FinishedAt is the time at which the task transistioned to dead and will
    // not be started again.
    // Series of task events that transition the state of the task.
    State: String,
    Failed: Boolean,
    StartedAt: Long,
    FinishedAt: Long,
    Events: Array[TaskEvent]
  )


  // TaskEvent is an event that effects the state of a task and contains meta-data
  // appropriate to the events type.
  case class TaskEvent (
    // FailsTask marks whether this event fails the task
    // Restart fields.
    // Setup Failure fields.
    // Driver Failure fields.
    // Task Terminated Fields.
    // Killing fields
    // Task Killed Fields.
    // KillReason is the reason the task was killed
    // TaskRestarting fields.
    // Artifact Download fields
    // Validation fields
    // The maximum allowed task disk size.
    // Name of the sibling task that caused termination of the task that
    // the TaskEvent refers to.
    // VaultError is the error from token renewal
    // TaskSignalReason indicates the reason the task is being signalled.
    // TaskSignal is the signal that was sent to the task
    // DriverMessage indicates a driver action being taken.
    Type: String,
    FailsTask: Boolean,
    RestartReason: String,
    SetupError: String,
    KillTimeout: Long,
    KillReason: String,
    DiskLimit: Long,
    FailedSibling: String,
    VaultError: String,
    TaskSignalReason: String,
    TaskSignal: String,
    DriverMessage: String
  )


  // TaskArtifact is an artifact to download before running the task.
  case class TaskArtifact (
    // GetterSource is the source to download an artifact using go-getter
    // GetterOptions are options to use when downloading the artifact using
    // go-getter.
    // RelativeDest is the download destination given relative to the task's
    // directory.
    GetterSource: String,
    GetterOptions: Map[String,String],
    RelativeDest: String
  )


  // Constraints are used to restrict placement options.
  case class Constraint (

  )


  // EphemeralDisk is an ephemeral disk object
  case class EphemeralDisk (
    // Sticky indicates whether the allocation is sticky to a node
    // SizeMB is the size of the local disk
    // Migrate determines if Nomad client should migrate the allocation dir for
    // sticky allocations
    Sticky: Boolean,
    SizeMB: Int,
    Migrate: Boolean
  )


  // Vault stores the set of premissions a task needs access to from Vault.
  case class Vault (
    // Policies is the set of policies that the task needs access to
    // Env marks whether the Vault Token should be exposed as an environment
    // variable
    // ChangeMode is used to configure the task's behavior when the Vault
    // token changes because the original token could not be renewed in time.
    // ChangeSignal is the signal sent to the task when a new token is
    // retrieved. This is only valid when using the signal change mode.
    Policies: Array[String],
    Env: Boolean,
    ChangeMode: String,
    ChangeSignal: String
  )


  // Deployment is the object that represents a job deployment which is used to
  // transistion a job between versions.
  case class Deployment (
    // ID is a generated UUID for the deployment
    // JobID is the job the deployment is created for
    // JobVersion is the version of the job at which the deployment is tracking
    // JobModifyIndex is the modify index of the job at which the deployment is tracking
    // JobCreateIndex is the create index of the job which the deployment is
    // tracking. It is needed so that if the job gets stopped and reran we can
    // present the correct list of deployments for the job and not old ones.
    // TaskGroups is the set of task groups effected by the deployment and their
    // current deployment status.
    // The status of the deployment
    // StatusDescription allows a human readable description of the deployment
    // status.
    ID: String,
    JobID: String,
    JobVersion: Long,
    JobModifyIndex: Long,
    JobCreateIndex: Long,
    TaskGroups: Map[String,DeploymentState],
    Status: String,
    StatusDescription: String,
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // DeploymentState tracks the state of a deployment for a given task group.
  case class DeploymentState (
    // Promoted marks whether the canaries have been. Promotion by
    // task group is not allowed since that doesn’t allow a single
    // job to transition into the “stable” state.
    // RequiresPromotion marks whether the deployment is expecting
    // a promotion. This is computable by checking if the job has canaries
    // specified, but is stored in the deployment to make it so that consumers
    // do not need to query job history and deployments to know whether a
    // promotion is needed.
    // DesiredCanaries is the number of canaries that should be created.
    // DesiredTotal is the total number of allocations that should be created as
    // part of the deployment.
    // PlacedAllocs is the number of allocations that have been placed
    // HealthyAllocs is the number of allocations that have been marked healthy.
    // UnhealthyAllocs are allocations that have been marked as unhealthy.
    Promoted: Boolean,
    RequiresPromotion: Boolean,
    DesiredCanaries: Int,
    DesiredTotal: Int,
    PlacedAllocs: Int,
    HealthyAllocs: Int,
    UnhealthyAllocs: Int
  )


  // DeploymentStatusUpdate is used to update the status of a given deployment
  case class DeploymentStatusUpdate (
    // DeploymentID is the ID of the deployment to update
    // Status is the new status of the deployment.
    // StatusDescription is the new status description of the deployment.
    DeploymentID: String,
    Status: String,
    StatusDescription: String
  )


  // Allocation is used to allocate the placement of a task group to a node.
  case class Allocation (
    // ID of the allocation (UUID)
    // ID of the evaluation that generated this allocation
    // Name is a logical name of the allocation.
    // NodeID is the node this is being placed on
    // Job is the parent job of the task group being allocated.
    // This is copied at allocation time to avoid issues if the job
    // definition is updated.
    // TaskGroup is the name of the task group that should be run
    // Resources is the total set of resources allocated as part
    // of this allocation of the task group.
    // SharedResources are the resources that are shared by all the tasks in an
    // allocation
    // TaskResources is the set of resources allocated to each
    // task. These should sum to the total Resources.
    // Metrics associated with this allocation
    // Desired Status of the allocation on the client
    // DesiredStatusDescription is meant to provide more human useful information
    // Status of the allocation on the client
    // ClientStatusDescription is meant to provide more human useful information
    // TaskStates stores the state of each task,
    // PreviousAllocation is the allocation that this allocation is replacing
    // DeploymentID identifies an allocation as being created from a
    // particular deployment
    // DeploymentStatus captures the status of the allocation as part of the
    // given deployment
    // Canary marks this allocation as being a canary
    // Raft Indexes
    // AllocModifyIndex is not updated when the client updates allocations. This
    // lets the client pull only the allocs updated by the server.
    // CreateTime is the time the allocation has finished scheduling and been
    // verified by the plan applier.
    ID: String,
    EvalID: String,
    Name: String,
    NodeID: String,
    JobID: String,
    Job: Job,
    TaskGroup: String,
    Resources: Resources,
    SharedResources: Resources,
    TaskResources: Map[String,Resources],
    Metrics: AllocMetric,
    DesiredStatus: String,
    DesiredDescription: String,
    ClientStatus: String,
    ClientDescription: String,
    TaskStates: Map[String,TaskState],
    PreviousAllocation: String,
    DeploymentID: String,
    DeploymentStatus: AllocDeploymentStatus,
    Canary: Boolean,
    CreateIndex: Long,
    ModifyIndex: Long,
    AllocModifyIndex: Long,
    CreateTime: Long
  )


  // AllocListStub is used to return a subset of alloc information
  case class AllocListStub (
    ID: String,
    EvalID: String,
    Name: String,
    NodeID: String,
    JobID: String,
    TaskGroup: String,
    DesiredStatus: String,
    DesiredDescription: String,
    ClientStatus: String,
    ClientDescription: String,
    TaskStates: Map[String,TaskState],
    CreateIndex: Long,
    ModifyIndex: Long,
    CreateTime: Long
  )


  // AllocMetric is used to track various metrics while attempting
  // to make an allocation. These are used to debug a job, or to better
  // understand the pressure within the system.
  case class AllocMetric (
    // NodesEvaluated is the number of nodes that were evaluated
    // NodesFiltered is the number of nodes filtered due to a constraint
    // NodesAvailable is the number of nodes available for evaluation per DC.
    // ClassFiltered is the number of nodes filtered by class
    // ConstraintFiltered is the number of failures caused by constraint
    // NodesExhausted is the number of nodes skipped due to being
    // exhausted of at least one resource
    // ClassExhausted is the number of nodes exhausted by class
    // DimensionExhausted provides the count by dimension or reason
    // Scores is the scores of the final few nodes remaining
    // for placement. The top score is typically selected.
    // AllocationTime is a measure of how long the allocation
    // attempt took. This can affect performance and SLAs.
    // CoalescedFailures indicates the number of other
    // allocations that were coalesced into this failed allocation.
    // This is to prevent creating many failed allocations for a
    // single task group.
    NodesEvaluated: Int,
    NodesFiltered: Int,
    NodesAvailable: Map[String,Int],
    ClassFiltered: Map[String,Int],
    ConstraintFiltered: Map[String,Int],
    NodesExhausted: Int,
    ClassExhausted: Map[String,Int],
    DimensionExhausted: Map[String,Int],
    Scores: Map[String,Double],
    AllocationTime: Long,
    CoalescedFailures: Int
  )


  // AllocDeploymentStatus captures the status of the allocation as part of the
  // deployment. This can include things like if the allocation has been marked as
  // heatlhy.
  case class AllocDeploymentStatus (
    // Healthy marks whether the allocation has been marked healthy or unhealthy
    // as part of a deployment. It can be unset if it has neither been marked
    // healthy or unhealthy.
    Healthy: Boolean
  )


  // Evaluation is used anytime we need to apply business logic as a result
  // of a change to our desired state (job specification) or the emergent state
  // (registered nodes). When the inputs change, we need to "evaluate" them,
  // potentially taking action (allocation of work) or doing nothing if the state
  // of the world does not require it.
  case class Evaluation (
    // ID is a randonly generated UUID used for this evaluation. This
    // is assigned upon the creation of the evaluation.
    // Priority is used to control scheduling importance and if this job
    // can preempt other jobs.
    // Type is used to control which schedulers are available to handle
    // this evaluation.
    // TriggeredBy is used to give some insight into why this Eval
    // was created. (Job change, node failure, alloc failure, etc).
    // JobID is the job this evaluation is scoped to. Evaluations cannot
    // be run in parallel for a given JobID, so we serialize on this.
    // JobModifyIndex is the modify index of the job at the time
    // the evaluation was created
    // NodeID is the node that was affected triggering the evaluation.
    // NodeModifyIndex is the modify index of the node at the time
    // the evaluation was created
    // Status of the evaluation
    // StatusDescription is meant to provide more human useful information
    // Wait is a minimum wait time for running the eval. This is used to
    // support a rolling upgrade.
    // NextEval is the evaluation ID for the eval created to do a followup.
    // This is used to support rolling upgrades, where we need a chain of evaluations.
    // PreviousEval is the evaluation ID for the eval creating this one to do a followup.
    // This is used to support rolling upgrades, where we need a chain of evaluations.
    // BlockedEval is the evaluation ID for a created blocked eval. A
    // blocked eval will be created if all allocations could not be placed due
    // to constraints or lacking resources.
    // FailedTGAllocs are task groups which have allocations that could not be
    // made, but the metrics are persisted so that the user can use the feedback
    // to determine the cause.
    // ClassEligibility tracks computed node classes that have been explicitly
    // marked as eligible or ineligible.
    // EscapedComputedClass marks whether the job has constraints that are not
    // captured by computed node classes.
    // AnnotatePlan triggers the scheduler to provide additional annotations
    // during the evaluation. This should not be set during normal operations.
    // QueuedAllocations is the number of unplaced allocations at the time the
    // evaluation was processed. The map is keyed by Task Group names.
    // SnapshotIndex is the Raft index of the snapshot used to process the
    // evaluation. As such it will only be set once it has gone through the
    // scheduler.
    // Raft Indexes
    ID: String,
    Priority: Int,
    Type: String,
    TriggeredBy: String,
    JobID: String,
    JobModifyIndex: Long,
    NodeID: String,
    NodeModifyIndex: Long,
    Status: String,
    StatusDescription: String,
    Wait: Long,
    NextEval: String,
    PreviousEval: String,
    BlockedEval: String,
    FailedTGAllocs: Map[String,AllocMetric],
    ClassEligibility: Map[String,Boolean],
    EscapedComputedClass: Boolean,
    AnnotatePlan: Boolean,
    QueuedAllocations: Map[String,Int],
    SnapshotIndex: Long,
    CreateIndex: Long,
    ModifyIndex: Long
  )


  // Plan is used to submit a commit plan for task allocations. These
  // are submitted to the leader which verifies that resources have
  // not been overcommitted before admiting the plan.
  case class Plan (
    // EvalID is the evaluation ID this plan is associated with
    // EvalToken is used to prevent a split-brain processing of
    // an evaluation. There should only be a single scheduler running
    // an Eval at a time, but this could be violated after a leadership
    // transition. This unique token is used to reject plans that are
    // being submitted from a different leader.
    // Priority is the priority of the upstream job
    // AllAtOnce is used to control if incremental scheduling of task groups
    // is allowed or if we must do a gang scheduling of the entire job.
    // If this is false, a plan may be partially applied. Otherwise, the
    // entire plan must be able to make progress.
    // Job is the parent job of all the allocations in the Plan.
    // Since a Plan only involves a single Job, we can reduce the size
    // of the plan by only including it once.
    // NodeUpdate contains all the allocations for each node. For each node,
    // this is a list of the allocations to update to either stop or evict.
    // NodeAllocation contains all the allocations for each node.
    // The evicts must be considered prior to the allocations.
    // Annotations contains annotations by the scheduler to be used by operators
    // to understand the decisions made by the scheduler.
    // CreatedDeployment is the deployment created by the scheduler that should
    // be applied by the planner. A created deployment will cancel all other
    // deployments for a given job as there can only be a single running
    // deployment.
    // DeploymentUpdates is a set of status updates to apply to the given
    // deployments. This allows the scheduler to cancel any unneeded deployment
    // because the job is stopped or the update block is removed.
    EvalID: String,
    EvalToken: String,
    Priority: Int,
    AllAtOnce: Boolean,
    Job: Job,
    NodeUpdate: Map[String,Allocation],
    NodeAllocation: Map[String,Allocation],
    Annotations: PlanAnnotations,
    CreatedDeployment: Deployment,
    DeploymentUpdates: Array[DeploymentStatusUpdate]
  )


  // PlanResult is the result of a plan submitted to the leader.
  case class PlanResult (
    // NodeUpdate contains all the updates that were committed.
    // NodeAllocation contains all the allocations that were committed.
    // RefreshIndex is the index the worker should refresh state up to.
    // This allows all evictions and allocations to be materialized.
    // If any allocations were rejected due to stale data (node state,
    // over committed) this can be used to force a worker refresh.
    // AllocIndex is the Raft index in which the evictions and
    // allocations took place. This is used for the write index.
    NodeUpdate: Map[String,Allocation],
    NodeAllocation: Map[String,Allocation],
    RefreshIndex: Long,
    AllocIndex: Long
  )


  // PlanAnnotations holds annotations made by the scheduler to give further debug
  // information to operators.
  case class PlanAnnotations (
    // DesiredTGUpdates is the set of desired updates per task group.
    DesiredTGUpdates: Map[String,DesiredUpdates]
  )


  // DesiredUpdates is the set of changes the scheduler would like to make given
  // sufficient resources and cluster capacity.
  case class DesiredUpdates (
    Ignore: Long,
    Place: Long,
    Migrate: Long,
    Stop: Long,
    InPlaceUpdate: Long,
    DestructiveUpdate: Long
  )


  // KeyringResponse is a unified key response and can be used for install,
  // remove, use, as well as listing key queries.
  case class KeyringResponse (
    Messages: Map[String,String],
    Keys: Map[String,Int],
    NumNodes: Int
  )


  // KeyringRequest is request objects for serf key operations.
  case class KeyringRequest (
    Key: String
  )


  // RecoverableError wraps an error and marks whether it is recoverable and could
  // be retried or it is fatal.
  case class RecoverableError (
    Err: String,
    Recoverable: Boolean
  )


  type DiffType = String

  // JobDiff contains the diff of two jobs.
  case class JobDiff (
    Type: DiffType,
    ID: String,
    Fields: Array[FieldDiff],
    Objects: Array[ObjectDiff],
    TaskGroups: Array[TaskGroupDiff]
  )


  // TaskGroupDiff contains the diff of two task groups.
  case class TaskGroupDiff (
    Type: DiffType,
    Name: String,
    Fields: Array[FieldDiff],
    Objects: Array[ObjectDiff],
    Tasks: Array[TaskDiff],
    Updates: Map[String,Long]
  )


  // TaskDiff contains the diff of two Tasks
  case class TaskDiff (
    Type: DiffType,
    Name: String,
    Fields: Array[FieldDiff],
    Objects: Array[ObjectDiff],
    Annotations: Array[String]
  )


  // ObjectDiff contains the diff of two generic objects.
  case class ObjectDiff (
    Type: DiffType,
    Name: String,
    Fields: Array[FieldDiff],
    Objects: Array[ObjectDiff]
  )


  case class FieldDiff (
    Type: DiffType,
    Name: String,
    Annotations: Array[String]
  )


  // NetworkIndex is used to index the available network resources
  // and the used network resources on a machine given allocations
  case class NetworkIndex (

  )


  // RaftServer has information about a server in the Raft configuration.
  case class RaftServer (
    // ID is the unique ID for the server. These are currently the same
    // as the address, but they will be changed to a real GUID in a future
    // release of Nomad.
    // Node is the node name of the server, as known by Nomad, or this
    // will be set to "(unknown)" otherwise.
    // Address is the IP:port of the server, used for Raft communications.
    // Leader is true if this server is the current cluster leader.
    // Voter is true if this server has a vote in the cluster. This might
    // be false if the server is staging and still coming online, or if
    // it's a non-voting server, which will be added in a future release of
    // Nomad.
    ID: String,
    Node: String,
    Address: String,
    Leader: Boolean,
    Voter: Boolean
  )


  // RaftConfigrationResponse is returned when querying for the current Raft
  // configuration.
  case class RaftConfigurationResponse (
    // Servers has the list of servers in the Raft configuration.
    // Index has the Raft index of this configuration.
    Servers: Array[RaftServer],
    Index: Long
  )


  // RaftPeerByAddressRequest is used by the Operator endpoint to apply a Raft
  // operation on a specific Raft peer by address in the form of "IP:port".
  case class RaftPeerByAddressRequest (
    // Address is the peer to remove, in the form "IP:port".
    // WriteRequest holds the Region for this request.
    Address: String,
    Region: String
  )


}