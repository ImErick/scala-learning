package scala

object AnonymousFunctions extends App {

  // ejemplo de funcion anonima usando programacion funcional o lambda expression
  val doubler = (x: Int) => x * 2

  // multiples parametros en lambda expression
  val adder = (a: Int, b: Int) => a + b

  // no parametros
  val doSomething = () => "erick es guapo"

  println(doubler(2))

  // OJO aqui: que imprimie esto con funciones que no tienen parametros??
  println(doSomething) // la funcion en si misma junto con su direccion de memoria
  println(doSomething()) // llamada de la funcion

  // usando llaves ppara funciones anonimas que sean grandes
  val stringToInt = { str: String =>
    str.toInt
  }

  // sintaxis WTF de Scala
  val incrementador: Int => Int = _ + 1 // equivalente a x => x + 1
  val sumador: (Int, Int) => Int = _ + _ // equivalente a (a,b) => a + b
}
