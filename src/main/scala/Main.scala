package edu.luc.cs.laufer.cs382.ctk

import cats.implicits.*
import com.monovore.decline.*

import java.io.OutputStream
import scala.io.Source

object Main extends CommandApp(
  name = "hello-ctk",
  header = "simple test of decline",
  main =
    ( Opts.option[String]("greeting", help = "The desired greeting.", short = "g").withDefault("hello"),
      Opts.flag("quiet", help = "Whether to be quiet.", short = "q").orFalse
    ).mapN { (g, q) =>
      println(s"g = $g, q = $q")
      val (_, result) = SimpleInterpreter.interpret(Source.stdin, ())
      println(s"result = $result")
    }
)

trait Parser:
  type Cst
  def parse: Source => Cst

trait AstBuilder:
  type Cst
  type Ast
  def buildAst: Cst => Ast

trait Evaluator:
  type Ast
  type Env
  type Result
  def evaluate: Env => Ast => (Env, Result)

trait CodeGenerator:
  type Ast
  def generateCode: OutputStream => Ast => Unit

trait Interpreter extends Parser, AstBuilder, Evaluator:
  def interpret(input: Source, env: Env): (Env, Result) =
    val cst = parse(input)
    val ast = buildAst(cst)
    evaluate(env)(ast)

object SimpleInterpreter extends Interpreter:
  type Cst = String
  type Ast = Int
  type Env = Unit
  type Result = Int
  override val parse: Source => String = _.getLines().next().trim.nn
  override val buildAst: String => Int = _.toInt
  override val evaluate: Unit => Int => (Unit, Int) = _ => i => ((), i)
