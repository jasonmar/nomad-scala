package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.HCLValue

/**
  *
  * @param value a path relative to the current working directory
  */
case class RelativePath(value: String) extends HCLValue
