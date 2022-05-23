package com.example

import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
  
object Main extends App:
  val config = PostgresqlConnectionConfiguration.builder
    .host("localhost")
    .port(5432)
    .username("postgres")
    .password("postgres")
    .build
  
  val factory = PostgresqlConnectionFactory(config)

  val conn = factory.create

  val result = conn.flux
    .flatMap(_.createStatement("DELETE FROM items").execute)
    .flatMap(_.getRowsUpdated)
    .collectList.block

  println("Removed " + result + " items")
  