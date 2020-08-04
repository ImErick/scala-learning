package rockWithTheJVM

import scala.annotation.tailrec

object Functions extends App {

  // ejemplo de funcion recursiva, recordar que en programacion funcional de preferencia no usar loops
  def aRepeatedFunction(string: String, n: Int): String = {
    if (n == 1) string
    else string + aRepeatedFunction(string, n - 1)
  }

  println(aRepeatedFunction("putos", 3))

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def superFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = { // TAIL RECURSIVE = use recursive call as the LAST expression
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  //println(superFactorial(50000))
}
