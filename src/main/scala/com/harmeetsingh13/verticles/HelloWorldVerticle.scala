package com.harmeetsingh13.verticles

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.core.Vertx

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by harmeet on 25/6/17.
  */
class HelloWorldVerticle extends ScalaVerticle {

  override def start(): Unit = {
    println("Verticle Start ... ")
  }

  override def stop(): Unit = {
    println("Verticle Stop ... ")
  }
}

object HelloWorldVerticle extends App {
  val vertex = Vertx.vertx()
  vertex.deployVerticleFuture(ScalaVerticle.nameForVerticle[HelloWorldVerticle]).onComplete {
    case Success(result) => println(s"Deployment Id is : ${result}")
    case Failure(cause) => cause.printStackTrace()
  }
}