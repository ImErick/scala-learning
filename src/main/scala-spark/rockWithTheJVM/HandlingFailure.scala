package rockWithTheJVM

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
  val success = Success(43)
  val failed = Failure(new RuntimeException("OMGGG"))

  println(success)
  println(failed)

  def unsafeMethod(): String = throw new RuntimeException("dude staph")
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterSafeMethod(): Try[String] = Success("holis")

  val betterResult = betterUnsafeMethod orElse betterSafeMethod
  println(betterResult)
}
