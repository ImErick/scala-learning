package advanceExercises

import java.util

object Sandox extends App {

  // Given A = [1, 2, 3], the function should return 4.
  //Given A = [−1, −3], the function should return 1.

  def solution(array: Array[Int]): Int = {
    var smallestResult = 1
    if (array.isEmpty) return smallestResult
    val sortedArray = array.sorted
    if (sortedArray(0) > 1) return smallestResult
    sortedArray.foreach(x => if (x == smallestResult) smallestResult += 1)
    smallestResult
  }

  def anotherSolution(array: Array[Int]): Int = {
    var smallestResult = 1
    val sortedArray = array.filter(x => x >= 1).sorted.distinct
    if (array.isEmpty) return smallestResult
    sortedArray.foreach(x => if (x == smallestResult) smallestResult += 1)
    smallestResult
  }

  def streamSolution(string: String): Int = util.Arrays
    .stream(string.split("\\s*+(?:[.!?]\\s*+)+"))
    .mapToInt(x => x.split("\\s+").length)
    .max()
    .orElse(0)

  val test =  "We test coders. Give us a try?"
  println("resutado eeees " + streamSolution(test))

  val anArray = Array(1, 2, 3)
  val resultado = solution(anArray)
  println("debe imprimir un " + resultado)

  val emptyArray: Array[Int] = Array(-1, -3)
  val anotherResult = solution(emptyArray)
  println("debe imprimir un " + anotherResult)

  println("kesesto " + anotherSolution(Array(1, 3, 6, 4, 1, 2)))
}
