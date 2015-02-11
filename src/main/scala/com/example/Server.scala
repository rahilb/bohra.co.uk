package com.example

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp
import util.Properties

object Server extends SimpleRoutingApp with App {
  implicit val system = ActorSystem("goodnews-system")
  val port = Integer.parseInt(Properties.envOrElse("PORT", "8080"))
  startServer(interface = "0.0.0.0", port = port) {
    path("ping") {
      get {
        complete("pong")
      }
    }
  }
}