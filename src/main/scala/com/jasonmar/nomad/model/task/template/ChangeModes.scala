package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.Parameter

object ChangeModes {
  sealed trait ChangeMode extends Parameter
  case object NoOp extends ChangeMode { override val value: String = "noop" }
  case object Restart extends ChangeMode { override val value: String = "restart" }
  case object Signal extends ChangeMode { override val value: String = "signal" }
}
