package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.NonEmptyValue

/**
  *
  * @param value path to a file which must exist on the host
  */
case class LocalPath(value: String) extends NonEmptyValue

