name := "compilertoolkit-scala"

version := "0.1"

scalaVersion := "3.3.0"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls", "-Ysafe-init", "-language:strictEquality")

libraryDependencies ++= Seq(
  "com.monovore"  %% "decline"       % "2.4.1",
  "org.typelevel" %% "cats-parse"    % "0.3.10",
  "org.json4s"    %% "json4s-native" % "4.1.0-M3",
  "org.scalatest" %% "scalatest"     % "3.2.16" % Test
)

enablePlugins(JavaAppPackaging)
