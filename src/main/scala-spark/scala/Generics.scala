package scala

object Generics extends App {

  class MyList[A] {
    // definiendo una clase de lista generica
  }

  class MyMap[Key, Value] // mapa generico

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
}
