package com.harmeetsingh13.verticles

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.core.Vertx

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by harmeet on 26/6/17.
  */
class HelloWorldFutureVerticle extends ScalaVerticle {

  override def startFuture(): Future[_] = {
    println("Future Verticle Start ... ")
    Future.successful()
  }

  override def stopFuture(): Future[_] = {
    println("Future Verticle Stop ... ")
    Future.successful()
  }
}

object HelloWorldFutureVerticle extends App {
  val vertex = Vertx.vertx()
  vertex.deployVerticleFuture(ScalaVerticle.nameForVerticle[HelloWorldFutureVerticle]).onComplete {
    case Success(result) => println(s"Deployment Id is : ${result}")
    case Failure(cause) => cause.printStackTrace()
  }
}