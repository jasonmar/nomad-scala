/**
package com.jasonmar.nomad.generated

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

object JsonFormats {

  object QueryOptionsJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[QueryOptions] = jsonFormat5(QueryOptions)
  }

  object WriteRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[WriteRequest] = jsonFormat1(WriteRequest)
  }

  object QueryMetaJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[QueryMeta] = jsonFormat3(QueryMeta)
  }

  object WriteMetaJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[WriteMeta] = jsonFormat1(WriteMeta)
  }

  object NodeRegisterRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeRegisterRequest] = jsonFormat2(NodeRegisterRequest)
  }

  object NodeDeregisterRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeDeregisterRequest] = jsonFormat2(NodeDeregisterRequest)
  }

  object NodeServerInfoJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeServerInfo] = jsonFormat4(NodeServerInfo)
  }

  object NodeUpdateStatusRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeUpdateStatusRequest] = jsonFormat3(NodeUpdateStatusRequest)
  }

  object NodeUpdateDrainRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeUpdateDrainRequest] = jsonFormat3(NodeUpdateDrainRequest)
  }

  object NodeEvaluateRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeEvaluateRequest] = jsonFormat2(NodeEvaluateRequest)
  }

  object NodeSpecificRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeSpecificRequest] = jsonFormat7(NodeSpecificRequest)
  }

  object JobRegisterRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobRegisterRequest] = jsonFormat4(JobRegisterRequest)
  }

  object JobDeregisterRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobDeregisterRequest] = jsonFormat3(JobDeregisterRequest)
  }

  object JobEvaluateRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobEvaluateRequest] = jsonFormat2(JobEvaluateRequest)
  }

  object JobSpecificRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobSpecificRequest] = jsonFormat7(JobSpecificRequest)
  }

  object JobListRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobListRequest] = jsonFormat5(JobListRequest)
  }

  object JobPlanRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobPlanRequest] = jsonFormat2(JobPlanRequest)
  }

  object JobSummaryRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobSummaryRequest] = jsonFormat6(JobSummaryRequest)
  }

  object JobDispatchRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobDispatchRequest] = jsonFormat4(JobDispatchRequest)
  }

  object JobValidateRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobValidateRequest] = jsonFormat2(JobValidateRequest)
  }

  object JobRevertRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobRevertRequest] = jsonFormat4(JobRevertRequest)
  }

  object NodeListRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeListRequest] = jsonFormat5(NodeListRequest)
  }

  object EvalUpdateRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalUpdateRequest] = jsonFormat3(EvalUpdateRequest)
  }

  object EvalDeleteRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalDeleteRequest] = jsonFormat3(EvalDeleteRequest)
  }

  object EvalSpecificRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalSpecificRequest] = jsonFormat6(EvalSpecificRequest)
  }

  object EvalAckRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalAckRequest] = jsonFormat3(EvalAckRequest)
  }

  object EvalDequeueRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalDequeueRequest] = jsonFormat4(EvalDequeueRequest)
  }

  object EvalListRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalListRequest] = jsonFormat5(EvalListRequest)
  }

  object PlanRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PlanRequest] = jsonFormat2(PlanRequest)
  }

  object ApplyPlanResultsRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ApplyPlanResultsRequest] = jsonFormat2(ApplyPlanResultsRequest)
  }

  object AllocUpdateRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocUpdateRequest] = jsonFormat3(AllocUpdateRequest)
  }

  object AllocListRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocListRequest] = jsonFormat5(AllocListRequest)
  }

  object AllocSpecificRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocSpecificRequest] = jsonFormat6(AllocSpecificRequest)
  }

  object AllocsGetRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocsGetRequest] = jsonFormat6(AllocsGetRequest)
  }

  object PeriodicForceRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PeriodicForceRequest] = jsonFormat2(PeriodicForceRequest)
  }

  object ServerMembersResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ServerMembersResponse] = jsonFormat4(ServerMembersResponse)
  }

  object ServerMemberJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ServerMember] = jsonFormat11(ServerMember)
  }

  object DeriveVaultTokenRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DeriveVaultTokenRequest] = jsonFormat9(DeriveVaultTokenRequest)
  }

  object VaultAccessorsRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[VaultAccessorsRequest] = jsonFormat1(VaultAccessorsRequest)
  }

  object VaultAccessorJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[VaultAccessor] = jsonFormat6(VaultAccessor)
  }

  object DeriveVaultTokenResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DeriveVaultTokenResponse] = jsonFormat5(DeriveVaultTokenResponse)
  }

  object GenericRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[GenericRequest] = jsonFormat5(GenericRequest)
  }

  object GenericResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[GenericResponse] = jsonFormat1(GenericResponse)
  }

  object VersionResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[VersionResponse] = jsonFormat5(VersionResponse)
  }

  object JobRegisterResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobRegisterResponse] = jsonFormat7(JobRegisterResponse)
  }

  object JobDeregisterResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobDeregisterResponse] = jsonFormat6(JobDeregisterResponse)
  }

  object JobValidateResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobValidateResponse] = jsonFormat4(JobValidateResponse)
  }

  object NodeUpdateResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeUpdateResponse] = jsonFormat10(NodeUpdateResponse)
  }

  object NodeDrainUpdateResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeDrainUpdateResponse] = jsonFormat6(NodeDrainUpdateResponse)
  }

  object NodeAllocsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeAllocsResponse] = jsonFormat4(NodeAllocsResponse)
  }

  object NodeClientAllocsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeClientAllocsResponse] = jsonFormat4(NodeClientAllocsResponse)
  }

  object SingleNodeResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[SingleNodeResponse] = jsonFormat4(SingleNodeResponse)
  }

  object NodeListResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeListResponse] = jsonFormat4(NodeListResponse)
  }

  object SingleJobResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[SingleJobResponse] = jsonFormat4(SingleJobResponse)
  }

  object JobSummaryResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobSummaryResponse] = jsonFormat4(JobSummaryResponse)
  }

  object JobDispatchResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobDispatchResponse] = jsonFormat5(JobDispatchResponse)
  }

  object JobListResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobListResponse] = jsonFormat4(JobListResponse)
  }

  object JobVersionsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobVersionsResponse] = jsonFormat4(JobVersionsResponse)
  }

  object JobPlanResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobPlanResponse] = jsonFormat8(JobPlanResponse)
  }

  object SingleAllocResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[SingleAllocResponse] = jsonFormat4(SingleAllocResponse)
  }

  object AllocsGetResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocsGetResponse] = jsonFormat4(AllocsGetResponse)
  }

  object JobAllocationsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobAllocationsResponse] = jsonFormat4(JobAllocationsResponse)
  }

  object JobEvaluationsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobEvaluationsResponse] = jsonFormat4(JobEvaluationsResponse)
  }

  object SingleEvalResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[SingleEvalResponse] = jsonFormat4(SingleEvalResponse)
  }

  object EvalDequeueResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalDequeueResponse] = jsonFormat5(EvalDequeueResponse)
  }

  object PlanResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PlanResponse] = jsonFormat2(PlanResponse)
  }

  object AllocListResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocListResponse] = jsonFormat4(AllocListResponse)
  }

  object EvalListResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalListResponse] = jsonFormat4(EvalListResponse)
  }

  object EvalAllocationsResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EvalAllocationsResponse] = jsonFormat4(EvalAllocationsResponse)
  }

  object PeriodicForceResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PeriodicForceResponse] = jsonFormat3(PeriodicForceResponse)
  }

  object NodeJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Node] = jsonFormat19(Node)
  }

  object NodeListStubJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NodeListStub] = jsonFormat9(NodeListStub)
  }

  object ResourcesJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Resources] = jsonFormat5(Resources)
  }

  object PortJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Port] = jsonFormat2(Port)
  }

  object NetworkResourceJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NetworkResource] = jsonFormat0(NetworkResource)
  }

  object JobJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Job] = jsonFormat24(Job)
  }

  object JobListStubJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobListStub] = jsonFormat14(JobListStub)
  }

  object JobSummaryJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobSummary] = jsonFormat5(JobSummary)
  }

  object JobChildrenSummaryJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobChildrenSummary] = jsonFormat3(JobChildrenSummary)
  }

  object TaskGroupSummaryJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskGroupSummary] = jsonFormat6(TaskGroupSummary)
  }

  object UpdateStrategyJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[UpdateStrategy] = jsonFormat7(UpdateStrategy)
  }

  object PeriodicConfigJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PeriodicConfig] = jsonFormat6(PeriodicConfig)
  }

  object PeriodicLaunchJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PeriodicLaunch] = jsonFormat2(PeriodicLaunch)
  }

  object ParameterizedJobConfigJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ParameterizedJobConfig] = jsonFormat3(ParameterizedJobConfig)
  }

  object DispatchPayloadConfigJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DispatchPayloadConfig] = jsonFormat1(DispatchPayloadConfig)
  }

  object RestartPolicyJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[RestartPolicy] = jsonFormat4(RestartPolicy)
  }

  object TaskGroupJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskGroup] = jsonFormat8(TaskGroup)
  }

  object ServiceCheckJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ServiceCheck] = jsonFormat0(ServiceCheck)
  }

  object ServiceJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Service] = jsonFormat2(Service)
  }

  object LogConfigJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[LogConfig] = jsonFormat2(LogConfig)
  }

  object TaskJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Task] = jsonFormat16(Task)
  }

  object TemplateJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Template] = jsonFormat10(Template)
  }

  object TaskStateJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskState] = jsonFormat5(TaskState)
  }

  object TaskEventJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskEvent] = jsonFormat12(TaskEvent)
  }

  object TaskArtifactJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskArtifact] = jsonFormat3(TaskArtifact)
  }

  object ConstraintJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Constraint] = jsonFormat0(Constraint)
  }

  object EphemeralDiskJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[EphemeralDisk] = jsonFormat3(EphemeralDisk)
  }

  object VaultJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Vault] = jsonFormat4(Vault)
  }

  object DeploymentJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Deployment] = jsonFormat10(Deployment)
  }

  object DeploymentStateJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DeploymentState] = jsonFormat7(DeploymentState)
  }

  object DeploymentStatusUpdateJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DeploymentStatusUpdate] = jsonFormat3(DeploymentStatusUpdate)
  }

  object AllocationJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Allocation] = jsonFormat24(Allocation)
  }

  object AllocListStubJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocListStub] = jsonFormat14(AllocListStub)
  }

  object AllocMetricJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocMetric] = jsonFormat11(AllocMetric)
  }

  object AllocDeploymentStatusJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[AllocDeploymentStatus] = jsonFormat1(AllocDeploymentStatus)
  }

  object EvaluationJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Evaluation] = jsonFormat22(Evaluation)
  }

  object PlanJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[Plan] = jsonFormat10(Plan)
  }

  object PlanResultJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PlanResult] = jsonFormat4(PlanResult)
  }

  object PlanAnnotationsJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[PlanAnnotations] = jsonFormat1(PlanAnnotations)
  }

  object DesiredUpdatesJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[DesiredUpdates] = jsonFormat6(DesiredUpdates)
  }

  object KeyringResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[KeyringResponse] = jsonFormat3(KeyringResponse)
  }

  object KeyringRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[KeyringRequest] = jsonFormat1(KeyringRequest)
  }

  object RecoverableErrorJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[RecoverableError] = jsonFormat2(RecoverableError)
  }

  object JobDiffJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[JobDiff] = jsonFormat5(JobDiff)
  }

  object TaskGroupDiffJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskGroupDiff] = jsonFormat6(TaskGroupDiff)
  }

  object TaskDiffJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[TaskDiff] = jsonFormat5(TaskDiff)
  }

  object ObjectDiffJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[ObjectDiff] = jsonFormat4(ObjectDiff)
  }

  object FieldDiffJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[FieldDiff] = jsonFormat3(FieldDiff)
  }

  object NetworkIndexJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[NetworkIndex] = jsonFormat0(NetworkIndex)
  }

  object RaftServerJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[RaftServer] = jsonFormat5(RaftServer)
  }

  object RaftConfigurationResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[RaftConfigurationResponse] = jsonFormat2(RaftConfigurationResponse)
  }

  object RaftPeerByAddressRequestJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val fmt: RootJsonFormat[RaftPeerByAddressRequest] = jsonFormat2(RaftPeerByAddressRequest)
  }

}
*/
