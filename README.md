## Description

Scala DSL for Hashicorp Nomad HCL configuration


## Motivation

Type-safe construction of Nomad job definitions


## Features

* Case classes and traits representing elements of Nomad Job Specification
* Compile-time checks for validity of HCL
* Generate HCL from Scala code


## Instructions

```
sbt compile
sbt publish-local
```


## Example Job Definition

```scala
import com.jasonmar.nomad.model.job.Job
import com.jasonmar.nomad.model.job.Datacenter
import com.jasonmar.nomad.model.group.Group
import com.jasonmar.nomad.model.task.Task
import com.jasonmar.nomad.model.task.driver.Configs.DockerConfig
import com.jasonmar.nomad.model.task.driver.Drivers.Docker
import com.jasonmar.nomad.model.task.resources.Resources

val j: Job = Job(
  name = "docs",
  datacenters = Seq(Datacenter("us-east-1"), Datacenter("eu-west-1")),
  groups = Seq(
    Group(
      name = "example",
      tasks = Seq(
        Task(
          name = "server",
          driver = Docker,
          config = DockerConfig(
            image = "hashicorp/http-echo",
            args = Some(Seq("-text", "hello"))
          ),
          resources = Resources(
            memory = Some(128)
          )
        )
      )
    )
  )
)

val hcl: String = j.printHCL
```

## Authors and Copyright

Copyright (C) 2017 Jason Mar
