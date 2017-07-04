package com.jasonmar.hcl

import com.jasonmar.UnitSpec
import com.jasonmar.hcl.Indentation._

class IndentationSpec extends UnitSpec {
  
  def fixture = new {
    val hcl =
      """job "docs" {
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
    val hclIndented =
      """  job "docs" {
      |    datacenters = ["default"]
      |
      |    group "example" {
      |      task "server" {
      |        driver = "docker"
      |        config {
      |          image = "hashicorp/http-echo"
      |          args  = ["-text", "hello"]
      |        }
      |
      |        resources {
      |          memory = 128
      |        }
      |      }
      |    }
      |  }""".stripMargin
  }

  "Indentation" should "not indent a blank line" in {
    indent("", 2) should be ("")
  }

  it should "indent a single line string" in {
    indent("asdf", 2) should be ("  asdf")
  }

  it should "indent a two line string" in {
    val s = """asdf
            |123""".stripMargin
    val s1 = """  asdf
            |  123""".stripMargin
    indent(s, 2) should be (s1)
  }

  it should "indent a three line string" in {
    val s = """asdf
            |
            |123""".stripMargin
    val s1 = """  asdf
            |
            |  123""".stripMargin
    indent(s, 2) should be (s1)
  }

  it should "indent HCL" in {
    val f = fixture
    indent(f.hcl, 2) should be (f.hclIndented)
  }

}
