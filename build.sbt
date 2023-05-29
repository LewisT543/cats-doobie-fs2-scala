ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "cats-doobie-fs2-scala"
  )

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.0"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0"