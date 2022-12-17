package edu.luc.cs.laufer.cs382.cf

import cats.implicits.*
import com.monovore.decline.*

object Main extends CommandApp(
  name = "hello-cf",
  header = "simple test of decline",
  main =
    ( Opts.option[String]("greeting", help = "The desired greeting.", short = "g").withDefault("hello"),
      Opts.flag("quiet", help = "Whether to be quiet.", short = "q").orFalse
    ).mapN { (g, q) =>
      println(s"g = $g, q = $q")
    }
)
