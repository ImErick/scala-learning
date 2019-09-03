package scala

object AbstractDataTypes extends App {

  // clases abstractas as usual, puede o no tener solo metodos con parametros, tambien los traits
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "perritu"
    override def eat(): Unit = println("woof ñom ñom woof")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait BloodType {
    def kindOfBlood(): String
  }

  // example
  class Crocodile extends Animal with Carnivore with BloodType {
    override val creatureType: String = "cocrodilo"
    override def eat(): Unit = println("ÑAM ÑAM!")
    override def eat(animal: Animal): Unit = println(s"im a $creatureType and I'm eating ${animal.creatureType}")
    override def kindOfBlood(): String = "cold blood"
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)
  println(s"my crocodile has ${crocodile.kindOfBlood()}")

}
