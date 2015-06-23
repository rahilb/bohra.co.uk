package com.arhob

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.ExceptionHandler
import akka.stream.{ActorFlowMaterializer, FlowMaterializer}
import scala.util.Properties
import scala.concurrent.ExecutionContextExecutor

trait HomepageService {

  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: FlowMaterializer

  val homepage = getFromResource("homepage.html")

  val exceptionHandler = ExceptionHandler {
    case t: Throwable => homepage
  }

  val routes = {
    handleExceptions(exceptionHandler) {
      get {
        homepage
      }
    }
  }
}

object AkkaHttpServer extends App with HomepageService {
  override implicit val system: ActorSystem = ActorSystem()
  override implicit def executor: ExecutionContextExecutor = system.dispatcher
  override implicit val materializer: FlowMaterializer = ActorFlowMaterializer()
  Http().bindAndHandle(routes, "0.0.0.0", Integer.parseInt(Properties.envOrElse("PORT", "8080")))
}