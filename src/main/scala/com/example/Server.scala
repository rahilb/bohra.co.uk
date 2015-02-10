package com.example

import com.twitter.finagle.{Http, Service}
import com.twitter.util.{Await, Future}
import com.twitter.finagle.http.Response
import java.net.InetSocketAddress
import org.jboss.netty.handler.codec.http._
import spray.routing.SimpleRoutingApp
import util.Properties
import java.net.URI
import java.sql.Connection
import java.sql.DriverManager

object Server extends SimpleRoutingApp with App {
  val port = Integer.parseInt(Properties.envOrElse("PORT", "8080"))
  startServer(interface = "0.0.0.0", port = port) {
    path("ping") {
      get {
        complete("pong")
      }
    }
  }
}