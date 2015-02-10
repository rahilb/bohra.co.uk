import NativePackagerKeys._

packageArchetype.java_application

name := """goodnews"""

version := "1.0"

scalaVersion := "2.10.4"

val akkaV = "2.3.7"
val sprayV = "1.3.2"

libraryDependencies ++= Seq(
  "io.spray"              %%  "spray-can"             % sprayV,
  "io.spray"              %%  "spray-routing"         % sprayV,
  "com.typesafe.akka"     %%  "akka-actor"            % akkaV,
  "com.twitter" % "finagle-http_2.10" % "6.18.0",
  "postgresql" % "postgresql" % "9.0-801.jdbc4"
)
