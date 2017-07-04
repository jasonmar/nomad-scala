package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Parameter

object RestartModes {
  sealed trait RestartMode extends Parameter

  /**
    * Instructs the scheduler to delay the next restart until the next `interval` is reached. This is the default behavior.
    */
  case object Delay extends RestartMode { override val value: String = "delay" }

  /**
    * Instructs the scheduler to not attempt to res { override val name: String = "delay" }tart the task on failure. This mode is useful for non-idempotent jobs which are unlikely to succeed after a few failures.
    */
  case object Fail extends RestartMode  { override val value: String = "fail" }

}
