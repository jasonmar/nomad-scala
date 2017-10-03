package com.jasonmar.nomad.model.task.resources

import com.jasonmar.hcl.parameter.IntParam
import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.nomad.model.service.PortLabel

/** Specifies a TCP/UDP port
  * allocation and can be used to specify both dynamic ports and reserved ports.
  *
  * @param label  The label assigned to the port is used to identify the port in service
  *               discovery, and used in the name of the environment variable that indicates
  *               which port your application should bind to. For example: port "foo" {}
  *               When the task starts, it will be passed the following environment variables:
  *- <tt>NOMAD_IP_foo</tt> - The IP to bind on for the given port label.
  *- <tt>NOMAD_PORT_foo</tt> - The port value for the given port label.
  *- <tt>NOMAD_ADDR_foo</tt> - A combined <tt>ip:port</tt> that can be used for convenience.
  *               The label of the port is just text - it has no special meaning to Nomad.
  * @param static `(int: nil)` - Specifies the static TCP/UDP port to allocate. If omitted, a dynamic port is chosen. We **do not recommend**  using static ports, except
  *               for `system` or specialized jobs like load balancers.
  */
case class PortAllocation(label: String, static: Option[Int] = None) extends Stanza {
  override val stanza: String = "port"

  def port: PortLabel = PortLabel(label)

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza, label)
    hcl.maybeAppend(static.map(IntParam("static", _)))
    hcl.close()
    hcl.result
  }
}

