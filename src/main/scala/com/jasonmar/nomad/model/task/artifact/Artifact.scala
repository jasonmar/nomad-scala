package com.jasonmar.nomad.model.task.artifact

import com.jasonmar.hcl.Printer._
import com.jasonmar.hcl.Stanza
import com.jasonmar.hcl.parameter.StringParam
import com.jasonmar.nomad.model.task.artifact.Options.ArtifactOption
import com.jasonmar.nomad.model.task.artifact.Sources.Source
import com.jasonmar.nomad.model.task.template.RelativePath

/**
  *
  * @param destination Specifies the directory path to download the artifact, relative to the root of the task's directory. If omitted, the default value is to place the binary in `local/`. The destination is treated as a directory and source files will be downloaded into that directory path.
  * @param options Specifies configuration parameters to fetch the artifact. The key-value pairs map directly to parameters appended to the supplied `source` URL. Please see the [`go-getter` documentation][go-getter] for a complete list of options and examples
  * @param source Specifies the URL of the artifact to download. See [`go-getter`][go-getter] for details.
  */
case class Artifact(
  destination: RelativePath,
  options: Seq[ArtifactOption],
  source: Source
) extends Stanza {
  override def printHCL: String = {
    val hcl = new HCLBuilder()
    hcl.open(stanza)
    hcl.append(StringParam("destination", destination.value))
    hcl.append(ArtifactOptions(options))
    hcl.append(source)
    hcl.close()
    hcl.result
  }
}
