package advanceExercises

object CurriesAndPartialAppliedFunctions extends App {
  // curried functions o funciones que regresan funciones
  val superAdder: Int => Int => Int = x => y => x + y

  val add3 = superAdder(3)
  println(add3(5)) // 8

  println(superAdder(3)(5)) // lo mismo

  def curriedAdder(x: Int)(y: Int): Int = x + y // curried method
  // lifting(ETA-Expansion) es transformar un metodo a una funcion TODO: hay que recapitular los de funciones
  val anotherAdder: Int => Int = curriedAdder(5)
  println(anotherAdder(5)) // 10

  // excercise
  val simpleAddFunction: (Int, Int) => Int = (x: Int, y: Int) => x + y
  def simpleAddMethod(x: Int, y: Int): Int = x + y
  def simpleCurriedMethod(x: Int)(y: Int): Int = x + y

  val add7: Int => Int = (x: Int) => simpleAddFunction(7, x)
  val add7_2 = simpleAddFunction.curried(7)
  val add7_3 = simpleCurriedMethod(7) _ // asi para omitir el segundo valor, partial function

  // esta medio raro el uso del _
  def concatenator(a: String, b: String, c: String): String = a + b + c
  val insertString = concatenator("holis ",  _ , " desde Scala")
  println(insertString("mundis"))

  // https://www.geeksforgeeks.org/currying-functions-in-scala-with-examples/

}
