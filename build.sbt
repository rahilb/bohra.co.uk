import NativePackagerKeys._

packageArchetype.java_server

name := """bohracouk"""

version := "1.0"

scalaVersion := "2.10.4"

val akkaV = "2.3.7"
val sprayV = "1.3.2"

libraryDependencies ++= Seq(
  "io.spray"              %%  "spray-can"             % sprayV,
  "io.spray"              %%  "spray-routing"         % sprayV,
  "com.typesafe.akka"     %%  "akka-actor"            % akkaV,
  "postgresql" % "postgresql" % "9.0-801.jdbc4"
)
