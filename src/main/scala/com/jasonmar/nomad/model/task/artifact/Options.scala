package com.jasonmar.nomad.model.task.artifact

import com.jasonmar.hcl.Parameter

object Options {
  /**
    * See https://github.com/hashicorp/go-getter
    */
  sealed trait ArtifactOption extends Parameter {
    val key: String
    val value: String
  }

  /**
    *
    * @param value The Git ref to checkout. This is a ref, so it can point to a commit SHA, a branch name, etc. If it is a named ref such as a branch name, go-getter will update it to the latest on each get.
    */
  case class GitRef(value: String) extends ArtifactOption {
    override val key: String = "ref"
    override val parameterName: String = key
  }

  case class SSHKey(value: String) extends ArtifactOption {
    override val key: String = "sshkey"
    override val parameterName: String = key
  }

  case class Archive(extract: Boolean) extends ArtifactOption {
    override val key: String = "sshkey"
    override val value: String = if (extract) "true" else "false"
    override val parameterName: String = key

  }
  case class MD5Checksum(md5: String) extends ArtifactOption {
    require(md5.matches("[0-9a-z]{32}"))
    override val key: String = "checksum"
    override val value: String = s"md5:$md5"
    override val parameterName: String = key

  }
  case class SHA1Checksum(sha1: String) extends ArtifactOption {
    require(sha1.matches("[0-9a-z]{40}"))
    override val key: String = "checksum"
    override val value: String = s"sha1:$sha1"
    override val parameterName: String = key

  }
  case class SHA256Checksum(sha256: String) extends ArtifactOption {
    require(sha256.matches("[0-9a-z]{64}"))
    override val key: String = "checksum"
    override val value: String = s"sha256:$sha256"
    override val parameterName: String = key
  }

  case class AWSAccessKeyId(value: String)  extends ArtifactOption {
    // 20-character, uppercase, alphanumeric strings that don’t have any uppercase, alphanumeric characters immediately before or after
    require(value.matches("(?<![A-Z0-9])[A-Z0-9]{20}(?![A-Z0-9])"))
    override val key: String = "aws_access_key_id"
    override val parameterName: String = key
  }
  case class AWSAccessKeySecret(value: String) extends ArtifactOption {
    // 40-character, base-64 strings that don’t have any base 64 characters immediately before or after
    require(value.matches("(?<![A-Za-z0-9/+=])[A-Za-z0-9/+=]{40}(?![A-Za-z0-9/+=])"))
    override val key: String = "aws_access_key_secret"
    override val parameterName: String = key
  }
  case class AWSAccessToken (value: String) extends ArtifactOption {
    require(value.matches("[0-9a-zA-Z]*"))
    override val key: String = "aws_access_token"
    override val parameterName: String = key
  }


}
