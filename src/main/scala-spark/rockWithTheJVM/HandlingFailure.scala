package rockWithTheJVM

import scala.io.Source
import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
  val success = Success(43)
  val failed = Failure(new RuntimeException("OMGGG"))
  val result = Try(failed).orElse(Try(success))
  println("should print...Success(43): " + result) //TODO: WTF con el resultado?

  println(success)
  println(failed)

  def unsafeMethod(): String = throw new RuntimeException("dude staph")
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)
  println("regresara false..." + potentialFailure.isSuccess) // deberia regresar false(?)

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterSafeMethod(): Try[String] = Success("holis")
  println("regresara true..." + betterSafeMethod().isSuccess)

  val betterResult = betterUnsafeMethod orElse betterSafeMethod
  println(betterResult)

  // add example of Try Method and an example implementation
  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }

  val filename = "/etc/passwd"
  readTextFile(filename) match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f)
  }
}
