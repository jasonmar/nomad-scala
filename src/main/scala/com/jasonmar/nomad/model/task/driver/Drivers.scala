package com.jasonmar.nomad.model.task.driver

import com.jasonmar.hcl.Parameter

object Drivers {
  sealed trait Driver extends Parameter { override val parameterName: String = "driver" }

  /** The `java` driver is used to execute Java applications packaged into a Java Jar
    * file. The driver requires the Jar file to be accessible from the Nomad
    * client via the [`artifact` downloader](/docs/job-specification/artifact.html).
    * https://www.nomadproject.io/docs/drivers/java.html
    */
  case object Java extends Driver { override val value: String = "java" }

  /** The `exec` driver is used to simply execute a particular command for a task.
    * However, unlike [`raw_exec`](raw_exec.html) it uses the underlying isolation
    * primitives of the operating system to limit the task's access to resources. While
    * simple, since the `exec` driver  can invoke any command, it can be used to call
    * scripts or other wrappers which provide higher level features.
    * https://www.nomadproject.io/docs/drivers/exec.html
    */
  case object Exec extends Driver { override val value: String = "exec" }

  /** The raw_exec driver is used to execute a command for a task without any isolation.
    * Further, the task is started as the same user as the Nomad process.
    * As such, it should be used with extreme care and is disabled by default.
    * https://www.nomadproject.io/docs/drivers/raw_exec.html
    */
  case object RawExec extends Driver { override val value: String = "raw_exec" }

  /** The `docker` driver provides a first-class Docker workflow on Nomad. The Docker
    * driver handles downloading containers, mapping ports, and starting, watching,
    * and cleaning up after containers.
    * https://www.nomadproject.io/docs/drivers/docker.html
    */
  case object Docker extends Driver { override val value: String = "docker" }
}

