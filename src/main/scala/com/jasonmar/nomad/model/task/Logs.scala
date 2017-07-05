package com.jasonmar.nomad.model.task

import com.jasonmar.hcl.{HCLBuilder, Stanza}
import com.jasonmar.hcl.parameter.IntParam

/**
  *
  * @param maxFiles    Specifies the maximum number of rotated files Nomad
  *                    will retain for `stdout` and `stderr`. Each stream is tracked individually, so
  *                    specifying a value of 2 will create 4 files - 2 for stdout and 2 for stderr
  * @param maxFileSize Specifies the maximum size of each rotated file
  *                    in `MB`. If the amount of disk resource requested for the task is less than
  *                    the total amount of disk space needed to retain the rotated set of files,
  *                    Nomad will return a validation error when a job is submitted.
  */
case class Logs(maxFiles: Int, maxFileSize: Int) extends Stanza {
  require(maxFiles > 0)
  require(maxFileSize > 0)

  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.append(IntParam("max_files", maxFiles))
    hcl.append(IntParam("max_file_size", maxFileSize))
    hcl.close()
    hcl.result
  }
}
