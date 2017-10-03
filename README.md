## Description

Scala DSL for Hashicorp Nomad HCL configuration


## Motivation

Type-safe construction of Nomad job definitions


## Features

* Case classes and traits representing elements of Nomad Job Specification
* Compile-time checks for validity of HCL
* Generate HCL from Scala code
* Files not ending in `.hcl` are not managed by the hcl writer


## Instructions

* Define Task instances as vals in singleton objects
* Create singleton object inheriting TaskInventory trait for each desired subdirectory of hcl files
* Create singleton object inheriting GlobalInventory trait for each collection of hcl files that needs to be printed to a common top-level directory as a complete unit
* Run your GlobalInventory as a main class

### Printing hcl using sbt

#### Safe mode
Won't overwrite existing hcl files
```
sbt "run-main mi.taskdef.Inventory /path/to/tasks"
```

#### Clear all existing hcl files from directory  
Useful for managing all hcl within your Scala project
Target path will typically be a directory with git repository
```
sbt "run-main mi.taskdef.Inventory /path/to/tasks --clear"
```

#### Overwrite hcl files if they already exist
```
sbt "run-main mi.taskdef.Inventory /path/to/tasks --overwrite"
```  


### Example GlobalInventory

```
import com.jasonmar.nomad.{GlobalInventory, TaskInventory}

object Inventory extends GlobalInventory {
  override val inventories: Seq[TaskInventory] = Seq(
    Production.Services,
    Production.Tasks,
    Research.Services,
    Research.Tasks
  )
}
```

### Example TaskInventory

```
import com.jasonmar.nomad.model.task.Task
import com.jasonmar.nomad.TaskInventory
import prod.ScheduledTasks
import prod.ServiceTasks

object Production {
  object Services extends TaskInventory {
    override val outDir = "prod/services"
    override val tasks: Seq[Task] = Seq(
      ServiceTasks.vault,
      ServiceTasks.consul,
      ServiceTasks.statsite,
    )
  }

  object Tasks extends TaskInventory {
    override val outDir = "prod/tasks"
    override val tasks: Seq[Task] = Seq(
      ScheduledTasks.broker,
      ScheduledTasks.logShip,
      ScheduledTasks.publisher,
      ScheduledTasks.subscriber
    )
  }
}
```


## Publishing

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


## Running jobs

```
nomad validate /path/to/job.hcl
nomad plan /path/to/job.hcl
nomad run /path/to/job.hcl
nomad status
nomad logs -tail -f -job <job-id>
```

### Stopping a job

```
nomad stop -yes -detach <job>
```


## Authors and Copyright

Copyright (C) 2017 Jason Mar
