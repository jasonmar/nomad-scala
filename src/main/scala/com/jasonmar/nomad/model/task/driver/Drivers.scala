package com.jasonmar.nomad.model.task.driver

import com.jasonmar.hcl.Parameter

object Drivers {
  sealed trait Driver extends Parameter { override val parameterName: String = "driver" }

  /**
    * The `java` driver is used to execute Java applications packaged into a Java Jar
    * file. The driver requires the Jar file to be accessible from the Nomad
    * client via the [`artifact` downloader](/docs/job-specification/artifact.html).
    */
  case object Java extends Driver { override val value: String = "java" }

  /**
    * The `exec` driver is used to simply execute a particular command for a task.
    * However, unlike [`raw_exec`](raw_exec.html) it uses the underlying isolation
    * primitives of the operating system to limit the task's access to resources. While
    * simple, since the `exec` driver  can invoke any command, it can be used to call
    * scripts or other wrappers which provide higher level features.
    */
  case object Exec extends Driver { override val value: String = "exec" }

  /** The `docker` driver provides a first-class Docker workflow on Nomad. The Docker
    * driver handles downloading containers, mapping ports, and starting, watching,
    * and cleaning up after containers.
    */
  case object Docker extends Driver { override val value: String = "docker" }
}

