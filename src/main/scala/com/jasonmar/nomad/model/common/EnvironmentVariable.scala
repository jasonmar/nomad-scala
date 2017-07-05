package com.jasonmar.nomad.model.common

/** Some settings you specify in your [job specification][jobspec] are passed
*to tasks when they start. Other settings are dynamically allocated when your job
*is scheduled. Both types of values are made available to your job through
*environment variables.
  *
  * @param name
  */
case class EnvironmentVariable(name: String) extends NodeVariable
