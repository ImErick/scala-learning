package scala

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence =  Seq(1,2,3,4)
  println(aSequence) // devuelve una List
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to  10 // cuenta del 1 al 10
  val otherRange: Seq[Int] = 1 until  10 // cuenta del 1 al 9
  aRange.foreach(println)
  otherRange.foreach(println)

  // List
  val aList = List(1,2,3)
  println(43 +: aList :+ 666) // prepend and append

  val apples5 = List.fill(5)("apples")
  println(apples5)
  println(aList.mkString(" $ "))

  // Arrays
  val numbers = Array(1,2,3,4)
  numbers(2) = 666
  numbers.foreach(println) // mutables!

  // arrays vs seq
  val numberSeq: Seq[Int] = numbers // implicit conversion
  println(numberSeq) // devuelve un WrappedArray

  // Vectors
  val aVector: Vector[Int] = Vector(1,2,3)
  println(aVector)

  // vectors vs list
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      i <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector)) // vector es mas rapido!

}
