package com.example

import akka.actor.ActorSystem
import spray.routing.{RejectionHandler, SimpleRoutingApp}
import util.Properties

object Server extends SimpleRoutingApp with App {
  implicit val system = ActorSystem("goodnews-system")
  val port = Integer.parseInt(Properties.envOrElse("PORT", "8080"))
  val homepage = getFromFile(getClass.getClassLoader.getResource("homepage.html").getFile)
  val rejectionHandler = RejectionHandler {
    case _ => homepage
  }
  startServer(interface = "0.0.0.0", port = port) {
    handleRejections(rejectionHandler) {
      get {
        homepage
      }
    }
  }
}