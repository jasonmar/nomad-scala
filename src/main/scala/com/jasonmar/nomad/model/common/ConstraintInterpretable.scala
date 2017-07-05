package com.jasonmar.nomad.model.common

// Special case of NodeVariable which can be used in a constraint block
// Other NodeVariables such as environment variables are only available at runtime
trait ConstraintInterpretable extends NodeVariable
