
/*
 * BASIC INFORMATION
 ********************************************************/

name := "ubirch-elasticsearch-mapping-utils"
version := "3.3.2"
description := "Elasticsearch related utils"
organization := "com.ubirch.util"
homepage := Some(url("http://ubirch.com"))
scalaVersion := "2.11.12"
scalacOptions ++= Seq(
  "-feature"
)
scmInfo := Some(ScmInfo(
  url("https://github.com/ubirch/ubirch-elasticsearch-binary-utils"),
  "https://github.com/ubirch/ubirch-elasticsearch-binary-utils.git"
))

/*
 * CREDENTIALS
 ********************************************************/

(sys.env.get("CLOUDREPO_USER"), sys.env.get("CLOUDREPO_PW")) match {
  case (Some(username), Some(password)) =>
    println("USERNAME and/or PASSWORD found.")
    credentials += Credentials("ubirch.mycloudrepo.io", "ubirch.mycloudrepo.io", username, password)
  case _ =>
    println("USERNAME and/or PASSWORD is taken from /.sbt/.credentials")
    credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
}


/*
 * RESOLVER
 ********************************************************/

val resolverElasticsearch = "elasticsearch-releases" at "https://artifacts.elastic.co/maven"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  resolverElasticsearch)


/*
 * PUBLISHING
 ********************************************************/

val resolverUbirchUtils = "cloudrepo.io" at "https://ubirch.mycloudrepo.io/repositories/ubirch-utils-mvn"

publishTo := Some(resolverUbirchUtils)
publishMavenStyle := true


/*
 * DEPENDENCIES
 ********************************************************/


//version
val elasticsearchV = "6.8.10"
val elasticSearch = "org.elasticsearch" % "elasticsearch" % elasticsearchV
val elasticSearchTransport = "org.elasticsearch.client" % "transport" % elasticsearchV
val elasticsearchXPack = "org.elasticsearch.client" % "x-pack-transport" % elasticsearchV
val luceneCore = "org.apache.lucene" % "lucene-core" % "7.7.1"
val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"


libraryDependencies ++= Seq(
  elasticSearch,
  elasticSearchTransport,
  elasticsearchXPack,
  luceneCore,
  scalaLogging
)


