package com.jasonmar.nomad

import com.jasonmar.UnitSpec
import com.jasonmar.nomad.model.group.Group
import com.jasonmar.nomad.model.job.{Datacenter, Job}
import com.jasonmar.nomad.model.task.Task
import com.jasonmar.nomad.model.task.driver.Configs.DockerConfig
import com.jasonmar.nomad.model.task.driver.Drivers.Docker
import com.jasonmar.nomad.model.task.resources.Resources

class ModelSpec extends UnitSpec {
  
  def fixture = new {
    val hcl = """job "docs" {
                |  datacenters = ["default"]
                |
                |  group "example" {
                |    task "server" {
                |      driver = "docker"
                |      config {
                |        image = "hashicorp/http-echo"
                |        args  = ["-text", "hello"]
                |      }
                |
                |      resources {
                |        memory = 128
                |      }
                |    }
                |  }
                |}""".stripMargin
    val j = Job(
      name = "docs",
      datacenters = Seq(Datacenter("us-east-1")),
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
  }
  
  "Nomad Model" should "generate HCL" in {
    val f = fixture
    import f._


  }

}
