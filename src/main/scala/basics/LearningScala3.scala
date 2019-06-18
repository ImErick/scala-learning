package basics

object LearningScala3 {
  // functions in Scala: def <name>(param name: Type): return Type = {code}

  // example with square
  def square(x: Int): Int = { x * x }

  // another way to do
  def cube(x: Int): Int = {
    x * x * x
  }

  //TODO: en Scala se pueden pasar funciones como parametros de otras funciones, OLOVORGO

  def main(args: Array[String]): Unit = {
    println("cuadrado de 2: " + square(2))
    println("cubo de 2: " + cube(2))
  }

}
