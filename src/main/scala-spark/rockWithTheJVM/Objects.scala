package rockWithTheJVM

object Objects extends App {

  class Animal {
    def eat(): Unit = println("ñam ñam")
  }

  class Dog extends Animal {
    // ejemplo de override y de overload
    override def eat(): Unit = println("ñom ñom")
    def eat(food: String): Unit = println(s"ñum ñum the $food")
  }

  val dog = new Dog
  dog.eat()
  dog.eat("pito")

}
