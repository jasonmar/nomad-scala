package com.jasonmar.nomad.model.task.artifact

import com.jasonmar.hcl.Parameter


object Sources {
  sealed trait Source extends Parameter
  case class Http(host: String, path: String) extends Source {
    override val value: String = s"http://$host$path"
  }
  case class Https(host: String, path: String) extends Source {
    override val value: String = s"https://$host$path"
  }
  case class S3(region: String, bucket: String, key: String) extends Source {
    override val value: String = s"s3::https://s3-$region.amazonaws.com/$bucket/$key"
  }
  case class GitHttp(repoUrl: String) extends Source {
    override val value: String = s"git::$repoUrl"
  }
  case class Github(account: String, repo: String) extends Source {
    override val value: String = s"git@github.com:$account/$repo"
  }
}

