package com.jasonmar.nomad.model.job

import com.jasonmar.hcl.Parameter


object Payloads {

  sealed trait Payload extends Parameter { override val parameterName: String = "payload" }

  /**
    * A payload is optional when dispatching against the job.
    */
  case object Optional extends Payload {
    override val value: String = "optional"
  }

  /**
    * A payload must be provided when dispatching against the job.
    */
  case object Required extends Payload {
    override val value: String = "optional"
  }

  /**
    * A payload is forbidden when dispatching against the job.
    */
  case object Forbidden extends Payload {
    override val value: String = "optional"
  }
}
