package com.arhob

import akka.actor.ActorSystem
import spray.routing.{RejectionHandler, SimpleRoutingApp}
import util.Properties

object Server extends SimpleRoutingApp with App {
  implicit val system = ActorSystem("actor-system")
  val port = Integer.parseInt(Properties.envOrElse("PORT", "8080"))
  val homepage = getFromResource("homepage.html")
  val rejectionHandler = RejectionHandler {
    case r =>
      homepage
  }
  startServer(interface = "0.0.0.0", port = port) {
    handleRejections(rejectionHandler) {
      get {
        homepage
      }
    }
  }
}
