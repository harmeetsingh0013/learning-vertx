package com.harmeetsingh13.verticles

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.core.Vertx

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by harmeet on 26/6/17.
  */
class HelloWorldEventBusVerticle extends ScalaVerticle {

  override def startFuture(): Future[_] = {
    vertx
      .eventBus()
      .consumer[String]("com.harmeetsingh13.verticle")
      .handler { msg =>
        msg.body() match {
          case user: String => println(s"Hello $user!! message")
        }
      }
      .completionFuture()
  }
}

object HelloWorldEventBusVerticle extends App {
  val vertex = Vertx.vertx()
  vertex.deployVerticleFuture(ScalaVerticle.nameForVerticle[HelloWorldEventBusVerticle]).onComplete {
    case Success(result) => vertex.eventBus().send("com.harmeetsingh13.verticle", "James")
    case Failure(cause) => cause.printStackTrace()
  }

}
