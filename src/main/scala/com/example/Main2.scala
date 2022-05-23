package com.example

import io.r2dbc.spi._
import reactor.core.publisher.Flux
  import java.util.function.BiFunction
  
object Main2 extends App:
  val options = ConnectionFactoryOptions.builder
    .option(ConnectionFactoryOptions.HOST, "localhost")
    .option(ConnectionFactoryOptions.PORT, 5432)
    .option(ConnectionFactoryOptions.USER, "postgres")
    .option(ConnectionFactoryOptions.PASSWORD, "postgres")
    .option(ConnectionFactoryOptions.DRIVER, "postgresql")
    .build

  val factory = ConnectionFactories.get(options)

  val conn = factory.create

  val result = Flux.from(conn)
    .flatMap(_.createStatement("DELETE FROM items").execute)
    .flatMap(_.getRowsUpdated)
    .collectList.block

  println(result)
