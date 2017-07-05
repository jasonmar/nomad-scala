package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.NonEmptyValue

/**
  *
  * @param value file permissions used by chmod (examples: 600 644 755)
  */
case class OctalPerms(value: String) extends NonEmptyValue { require(value.matches("[0-7]{3}")) }
