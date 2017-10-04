# Nomad-Scala

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
* Create singleton object inheriting HCLInventory trait for each desired subdirectory of hcl files
* Create singleton object inheriting GlobalInventory trait for each collection of hcl files that needs to be printed to a common top-level directory as a complete unit
* Run your GlobalInventory as a main class


### Example HCLInventories

```
import com.jasonmar.nomad.{HCLInventories, HCLInventory}

object Inventory extends HCLInventories {
  override val inventories: Seq[HCLInventory] = Seq(
    Production.Services,
    Production.Scheduled
  )
}
```


### Example HCLInventory

```
import com.jasonmar.hcl.NamedStanza
import com.jasonmar.nomad.HCLInventory

object Production {
  object Services extends HCLInventory {
    override val outDir = "prod/services"
    override val tasks: Seq[NamedStanza] = Seq(
      Job(...),
      ...
    )
  }

  object Scheduled extends HCLInventory {
    override val outDir = "prod/scheduled"
    override val tasks: Seq[NamedStanza] = Seq(
      Job(...),
      ...
    )
  }
}
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



## Generating hcl

### Set Inventory as main class in build.sbt

This enables sbt run without specifying main class

```
mainClass in (Compile, run) := Some("Inventory")
```

### Modes of operation

#### Default: Clear all existing hcl files from directory  
Useful for managing all hcl within your Scala project
Target path will typically be a directory with git repository
```
sbt "run /path/to/tasks --clear"
```

#### Overwrite: removes hcl files that already exist
```
sbt "run /path/to/tasks --overwrite"
```  

#### Safe mode: throws exception if hcl files already exist
```
sbt "run /path/to/tasks"
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


## Links

[Nomad Job Specification](https://www.nomadproject.io/docs/job-specification/index.html)


## Authors and Copyright

Copyright (C) 2017 Jason Mar
