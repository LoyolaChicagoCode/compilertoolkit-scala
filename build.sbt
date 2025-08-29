name := "compilertoolkit-scala"

version := "0.1"

libraryDependencies ++= Seq(
  "com.monovore"  %% "decline"       % "2.4.1",
  "org.typelevel" %% "cats-parse"    % "1.0.0",
  "org.json4s"    %% "json4s-native" % "4.1.0-M5",
  "org.scalatest" %% "scalatest"     % "3.2.19" % Test
)

enablePlugins(JavaAppPackaging)
