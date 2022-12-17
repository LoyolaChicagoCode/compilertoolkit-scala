name := "compilerframework-scala"

version := "0.1"

scalaVersion := "3.2.1"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls", "-Ysafe-init", "-language:strictEquality")

libraryDependencies ++= Seq(
  "com.monovore"           %% "decline"                  % "2.4.1",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
  "org.json4s"             %% "json4s-native"            % "4.1.0-M2",
  "org.scalatest"          %% "scalatest"                % "3.2.14" % Test
)

enablePlugins(JavaAppPackaging)
