package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.NonEmptyValue

/**
  *
  * @param value a path relative to the current working directory
  */
case class RelativePath(value: String) extends NonEmptyValue
