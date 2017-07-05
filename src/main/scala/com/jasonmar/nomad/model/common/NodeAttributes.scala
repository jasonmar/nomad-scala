package com.jasonmar.nomad.model.common

object NodeAttributes {
  /** Metadata value given by key on the client
    * @param key name of meta key
    * @return
    */
  def meta(key: String) = NodeAttribute(s"meta.$key")

  /** Property given by property on the client
    * @param property name of client property
    * @return
    */
  def attr(property: String) = NodeAttribute(s"attr.$property")

  /** See the [task drivers](/docs/drivers/index.html) for property documentation
    * @param property name of driver property
    * @return
    */
  def driverProperty(property: String) = NodeAttribute(s"attr.driver.$property")

  val `node.unique.id` = NodeAttribute("node.unique.id") // 36 character unique client identifier
  val `node.datacenter` = NodeAttribute("node.datacenter") // Client's datacenter
  val `node.unique.name` = NodeAttribute("node.unique.name") // Client's name
  val `node.class` = NodeAttribute("node.class") // Client's class
  val `attr.cpu.arch` = NodeAttribute("attr.cpu.arch") // CPU architecture of the client (e.g. amd64, <tt>386</tt>)
  val `attr.consul.datacenter` = NodeAttribute("attr.consul.datacenter") // The Consul datacenter of the client (if Consul is found)
  val `attr.cpu.numcores` = NodeAttribute("attr.cpu.numcores") // Number of CPU cores on the client
  val `attr.unique.hostname` = NodeAttribute("attr.unique.hostname") // Hostname of the client
  val `attr.unique.network.ip-address` = NodeAttribute("attr.unique.network.ip-address") // The IP address fingerprinted by the client and from which task ports are allocated
  val `attr.kernel.name` = NodeAttribute("attr.kernel.name") // Kernel of the client (e.g. linux, <tt>darwin</tt>)
  val `attr.kernel.version` = NodeAttribute("attr.kernel.version") // Version of the client kernel (e.g. 3.19.0-25-generic, <tt>15.0.0</tt>)
  val `attr.platform.aws.ami-id` = NodeAttribute("attr.platform.aws.ami-id") // AMI ID of the client (if on AWS EC2)
  val `attr.platform.aws.instance-type` = NodeAttribute("attr.platform.aws.instance-type") // Instance type of the client (if on AWS EC2)
  val `attr.os.name` = NodeAttribute("attr.os.name") //Operating system of the client (e.g. ubuntu, <tt>windows</tt>, <tt>darwin</tt>)
  val `attr.os.version` = NodeAttribute("attr.os.version") // Version of the client OS
}
