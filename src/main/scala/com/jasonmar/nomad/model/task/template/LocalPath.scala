package com.jasonmar.nomad.model.task.template

import com.jasonmar.nomad.model.common.NonEmptyValue

/**
  *
  * @param value path to a file which must exist on the host
  */
case class LocalPath(value: String) extends NonEmptyValue

