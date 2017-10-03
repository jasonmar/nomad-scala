package com.jasonmar.nomad.model.common

import com.jasonmar.UnitSpec
import com.jasonmar.nomad.model.group.Cron
import com.jasonmar.nomad.model.job.JobTypes
import com.jasonmar.nomad.model.service.Statuses.Passing
import com.jasonmar.nomad.model.task.artifact.Options.AWSAccessKeyId

import scala.util.Try

class ParameterSpec extends UnitSpec {
  "Parameter" should "be named correctly" in {
    assert(Cron("123").parameterName == "cron")
    assert(JobTypes.Batch.parameterName == "type")
    assert(Passing.parameterName == "passing")
  }

  it should "validate regex" in {
    assert(Try(AWSAccessKeyId("none")).isFailure)
    assert(Try(AWSAccessKeyId("A2345678901234567890")).isSuccess)
    assert(AWSAccessKeyId("A2345678901234567890").parameterName == "aws_access_key_id")
  }

  it should "not allow empty values" in {
    assert(Try(Cron("").printHCL).isFailure)
  }

}
