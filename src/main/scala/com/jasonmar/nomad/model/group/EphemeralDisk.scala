package com.jasonmar.nomad.model.group

import com.jasonmar.hcl.Stanza


/**
  *
  * @param migrate When `sticky` is true, this specifies that the Nomad client should make a best-effort attempt to migrate the data from a remote machine if placement cannot be made on the original node. During data migration, the task will block starting until the data migration has completed.
  * @param size Specifies the size of the ephemeral disk in MB.  The current Nomad ephemeral storage implementation does not enforce this limit; however, it is used during job placement.
  * @param sticky Specifies that Nomad should make a best-effort attempt to place the updated allocation on the same machine. This will move the `local/` and `alloc/data` directories to the new allocation.
  */
case class EphemeralDisk(migrate: Boolean, size: Int, sticky: Boolean) extends Stanza {
  override def printHCL: String = "" // TODO implement
}
