package scala

import scala.util.Random

object PatternMatching extends App {

  // switch en Scala
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
      case 1 => "uno"
      case 2 => "dos"
      case 3 => "tres"
      case _ => "los demas que me dio webatl" // default case
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val erick = Person("erick", 18)

  val greetings = erick match {
      case Person(n, a) if a < 18 => s"holis ni nombres es $n y soy menor de edad :c"
      case Person(n, a) => s"holis ni nombres es $n y tengo $a años"
      case _ => "la wea :v"
  }

  println(greetings)

  // sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Wolfog")
  animal match {
    case Dog(raza) => println(s"es un lomito de la raza $raza")
  } // el chiste es que va a tirar un warning al no declarar ni el default ni el Parrot
}
