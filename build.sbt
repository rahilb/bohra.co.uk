packageArchetype.java_server

name := """bohracouk"""

version := "1.0"

scalaVersion := "2.11.5"

val akkaV = "2.3.10"
val sprayV = "1.3.2"
val akkaStreamV = "1.0-RC2"
val scalaTestV  = "2.2.4"

libraryDependencies ++= Seq(
  "postgresql"         % "postgresql"                           % "9.0-801.jdbc4",
  "com.typesafe.akka" %% "akka-actor"                           % akkaV,
  "com.typesafe.akka" %% "akka-stream-experimental"             % akkaStreamV,
  "com.typesafe.akka" %% "akka-http-core-experimental"          % akkaStreamV,
  "com.typesafe.akka" %% "akka-http-scala-experimental"         % akkaStreamV,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental"    % akkaStreamV,
  "com.typesafe.akka" %% "akka-http-testkit-scala-experimental" % akkaStreamV,
  "org.scalatest"     %% "scalatest"                            % scalaTestV % "test"
)
