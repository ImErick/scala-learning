package basics

object LearningScala3 {
  // functions in Scala: def <name>(param name: Type): return Type = {code}

  // example with square
  def square(x: Int): Int = { x * x }

  // another way to do
  def cube(x: Int): Int = {
    x * x * x
  }

  //en Scala se pueden pasar funciones como parametros de otras funciones, OLOVORGO
  def functionInsideFunction(x: Int, f: Int => Int): Int = {f(x)}

  def main(args: Array[String]): Unit = {
    println("cuadrado de 2: " + square(2))
    println("cubo de 2: " + cube(2))

    // funcion dentro de la funcion
    println("funcion dentro de la funcion " + functionInsideFunction(6, cube))

    // tambien existen las funciones lambda o anonimas
    println("expresion lambda " + functionInsideFunction(5, x => x * 10))

    // un poco mas complejo...
    println("mas complejo: " + functionInsideFunction(10, x => {val y = x + 1; y * y}))
  }

}
