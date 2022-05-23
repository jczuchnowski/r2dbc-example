
resolvers += Resolver.mavenLocal

lazy val root = project
  .in(file("."))
  .settings(
    inThisBuild(
      List(
        name := "r2dbc-example",
        organization := "com.example",
        version := "0.0.1",
        scalaVersion := "3.1.2"
      )
    ),
    libraryDependencies ++= Seq(
      "io.projectreactor" % "reactor-core"     % "3.4.16",
      "io.r2dbc"          % "r2dbc-spi"        % "1.0.0.RELEASE",
      "org.postgresql"    % "r2dbc-postgresql" % "1.0.0.BUILD-SNAPSHOT",
    ),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )
