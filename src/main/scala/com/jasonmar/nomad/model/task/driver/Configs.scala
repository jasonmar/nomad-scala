package com.jasonmar.nomad.model.task.driver

import com.jasonmar.hcl.parameter.StringParam
import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.common.{Args, KVPair}
import com.jasonmar.nomad.model.task.template.{LocalPath, RelativePath}

object Configs {
  sealed trait DriverConfig extends Stanza {
    override val stanza: String = "config"
  }

  /**
    *
    * @param command The command to execute. Must be provided. If executing a binary
  that exists on the host, the path must be absolute. If executing a binary that
  is downloaded from an [`artifact`](/docs/job-specification/artifact.html), the
  path can be relative from the allocations's root directory.
    * @param args (Optional) A list of arguments to the `command`. References
  to environment variables or any [interpretable Nomad
  variables](/docs/runtime/interpolation.html) will be interpreted before
  launching the task.
    */
  case class ExecConfig(
    command: String,
    args: Option[Seq[String]]
  ) extends DriverConfig {
    override def printHCL: String = {
      val hcl = new HCLBuilder()
      hcl.open(stanza)
      hcl.append(StringParam("command", command))
      hcl.maybeAppend(args.map(Args))
      hcl.close()
      hcl.result
    }
  }

  /**
    *
    * @param mainClass (Optional) The name of the class to run. If `jar_path` is specified
  and the manifest specifies a main class, this is optional. If shipping classes
  rather than a Jar, please specify the class to run and the `class_path`.
    * @param classPath (Optional) The `class_path` specifies the clath path used by
  Java to lookup classes and Jars.
    * @param jarPath (Optional) The path to the downloaded Jar. In most cases this will just be
  the name of the Jar. However, if the supplied artifact is an archive that
  contains the Jar in a subfolder, the path will need to be the relative path
  (`subdir/from_archive/my.jar`).
    * @param args (Optional) A list of arguments to the Jar's main method. References
  to environment variables or any [interpretable Nomad
  variables](/docs/runtime/interpolation.html) will be interpreted before
  launching the task.
    * @param jvmOptions (Optional) A list of JVM options to be passed while invoking
  java. These options are passed without being validated in any way by Nomad.
    */
  case class JavaConfig(
    mainClass: Option[String],
    classPath: Option[String],
    jarPath: Option[RelativePath],
    args: Option[Seq[String]],
    jvmOptions: Option[Seq[String]]
  ) extends DriverConfig {
    override def printHCL: String = {
      val hcl = new HCLBuilder()
      hcl.open(stanza)
      hcl.maybeAppend(mainClass.map(StringParam("class", _)))
      hcl.maybeAppend(classPath.map(StringParam("class_path", _)))
      hcl.maybeAppend(jarPath.map(p => StringParam("jar_path", p.value)))
      hcl.maybeAppend(args.map(Args))
      hcl.maybeAppend(jvmOptions.map(JVMOptions))
      hcl.close()
      hcl.result
    }
  }

  /**
    *
    * @param image The Docker image to run. The image may include a tag or custom URL
  and should include `https://` if required. By default it will be fetched from
  Docker Hub. If the tag is omitted or equal to `latest` the driver will always
  try to pull the image. If the image to be pulled exists in a registry that
  requires authentication credentials must be provided to Nomad. Please see the
  [Authentication section](#authentication).
    * @param args (Optional) A list of arguments to the optional `command`. If no
  `command` is specified, the args are passed directly to the container.
  References to environment variables or any [interpretable Nomad
  variables](/docs/runtime/interpolation.html) will be interpreted before
  launching the task.
    * @param auth (Optional) Provide authentication for a private registry (see below).
    * @param command (Optional) The command to run when starting the container.
    * @param dns_search_domains (Optional) A list of DNS search domains for the container
  to use.
    * @param dns_servers (Optional) A list of DNS servers for the container to use
  (e.g. ["8.8.8.8", "8.8.4.4"]). *Docker API v1.10 and above only*
    * @param extra_hosts (Optional) A list of hosts, given as host:IP, to be added to
  `/etc/hosts`.
    * @param force_pull (Optional) `true` or `false` (default). Always pull latest image
  instead of using existing local image. Should be set to `true` if repository tags
  are mutable.
    * @param hostname (Optional) The hostname to assign to the container. When
  launching more than one of a task (using `count`) with this option set, every
  container the task starts will have the same hostname.
    * @param interactive (Optional) `true` or `false` (default). Keep STDIN open on
  the container.
    * @param ipc_mode_host (Optional) The IPC mode to be used for the container. The default
  is `none` for a private IPC namespace. Other values are `host` for sharing
  the host IPC namespace or the name or id of an existing container. Note that
  it is not possible to refer to Docker containers started by Nomad since their
  names are not known in advance. Note that setting this option also requires the
  Nomad agent to be configured to allow privileged containers.
    * @param ipv4_address (Optional) The IPv4 address to be used for the container when
  using user defined networks. Requires docker 1.13.0 or greater.
    * @param ipv6_address (Optional) The IPv6 address to be used for the container when
  using user defined networks. Requires docker 1.13.0 or greater.
    * @param labels (Optional) A key-value map of labels to set to the containers on
  start.
    * @param load (Optional) A list of paths to image archive files. If
  this key is not specified, Nomad assumes the `image` is hosted on a repository
  and attempts to pull the image. The `artifact` blocks can be specified to
  download each of the archive files. The equivalent of `docker load -i path`
  would be run on each of the archive files.
    * @param logging (Optional) A key-value map of Docker logging options. The default
  value is `syslog`.
    * @param network_aliases (Optional) A list of network-scoped aliases, provide a way for a
  container to be discovered by an alternate name by any other container within
  the scope of a particular network. Network-scoped alias is supported only for
  containers in user defined networks
    * @param network_mode (Optional) The network mode to be used for the container. In
  order to support userspace networking plugins in Docker 1.9 this accepts any
  value. The default is `bridge` for all operating systems but Windows, which
  defaults to `nat`. Other networking modes may not work without additional
  configuration on the host (which is outside the scope of Nomad).  Valid values
  pre-docker 1.9 are `default`, `bridge`, `host`, `none`, or `container:name`.
    * @param pid_mode_host (Optional) `host` or not set (default). Set to `host` to share
  the PID namespace with the host. Note that this also requires the Nomad agent
  to be configured to allow privileged containers.
  See below for more details.
    * @param port_map (Optional) A key-value map of port labels (see below).
    * @param privileged (Optional) `true` or `false` (default). Privileged mode gives
  the container access to devices on the host. Note that this also requires the
  nomad agent and docker daemon to be configured to allow privileged
  containers.
    * @param security_opt (Optional) A list of string flags to pass directly to
  [`--security-opt`](https://docs.docker.com/engine/reference/run/#security-configuration).
    * @param shm_size (Optional) The size (bytes) of /dev/shm for the container.
    * @param tty (Optional) `true` or `false` (default). Allocate a pseudo-TTY for the
  container.
    * @param uts_mode_host (Optional) `host` or not set (default). Set to `host` to share
  the UTS namespace with the host. Note that this also requires the Nomad agent
  to be configured to allow privileged containers.
    * @param userns_mode_host (Optional) `host` or not set (default). Set to `host` to use
  the host's user namespace when user namespace remapping is enabled on the
  docker daemon.
    * @param volumes (Optional) A list of `host_path:container_path` strings to bind
  host paths to container paths. Mounting host paths outside of the allocation
  directory can be disabled on clients by setting the `docker.volumes.enabled`
  option set to false. This will limit volumes to directories that exist inside
  the allocation directory.
    ```hcl
    config {
      volumes = [
        # Use absolute paths to mount arbitrary paths on the host
        "/path/on/host:/path/in/container",

        # Use relative paths to rebind paths already in the allocation dir
        "relative/to/task:/also/in/container"
      ]
    }
    ```
    * @param volume_driver (Optional) The name of the volume driver used to mount
  volumes. Must be used along with `volumes`.
  Using a `volume_driver` also allows to use `volumes` with a named volume as
  well as absolute paths. If `docker.volumes.enabled` is false then volume
  drivers are disallowed.
    * @param work_dir (Optional) The working directory inside the container.
    */
  case class DockerConfig(
    image: String,
    args: Option[Seq[String]] = None,
    auth: Option[String] = None,
    command: Option[String] = None,
    dns_search_domains: Option[Seq[String]] = None,
    dns_servers: Option[Seq[String]] = None,
    extra_hosts: Option[Seq[String]] = None,
    force_pull: Option[Boolean] = None,
    hostname: Option[String] = None,
    interactive: Option[Boolean] = None,
    ipc_mode_host: Option[Boolean] = None,
    ipv4_address: Option[String] = None,
    ipv6_address: Option[String] = None,
    labels: Option[Seq[KVPair]] = None,
    load: Option[Seq[LocalPath]] = None,
    logging: Option[Seq[KVPair]] = None,
    network_aliases: Option[Seq[String]] = None,
    network_mode: Option[String] = None,
    pid_mode_host: Option[Boolean] = None,
    port_map: Option[Seq[KVPair]] = None,
    privileged: Option[Boolean] = None,
    security_opt: Option[Seq[String]] = None,
    shm_size: Option[Int] = None,
    tty: Option[Boolean] = None,
    uts_mode_host: Option[Boolean] = None,
    userns_mode_host: Option[Boolean] = None,
    volumes: Option[Seq[String]] = None,
    volume_driver: Option[String] = None,
    work_dir: Option[String] = None
  ) extends DriverConfig {
    volumes match {
      case Some(v) =>
        require(volume_driver.nonEmpty)
      case _ =>
    }

    override def printHCL: String = {
      val hcl = new HCLBuilder()
      hcl.open(stanza)
      hcl.append(StringParam("image", image))
      hcl.maybeAppend(args.map(Args))

      hcl.close()
      hcl.result
    }
  }
}
