package com.jasonmar.nomad.model.job

import com.jasonmar.UnitSpec
import com.jasonmar.nomad.model.group.Group
import com.jasonmar.nomad.model.task.Task
import com.jasonmar.nomad.model.task.driver.Configs.DockerConfig
import com.jasonmar.nomad.model.task.driver.Drivers.Docker
import com.jasonmar.nomad.model.task.resources.Resources

class JobSpec extends UnitSpec {
  "Job" should "print hcl" in {
    val hcl = Seq(
      """job "docs" {""",
      """  datacenters = ["us-east-1", "eu-west-1"]""",
      """  group "example" {""",
      """    task "server" {""",
      """      driver = "docker"""",
      """      config {""",
      """        image = "hashicorp/http-echo"""",
      """        args = ["-text", "hello"]""",
      """      }""",
      """      resources {""",
      """        memory = 128""",
      """      }""",
      """    }""",
      """  }""",
      """}"""
    ).mkString("\n")
    val j = Job(
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
    
    j.printHCL should be (hcl)
  }
}
