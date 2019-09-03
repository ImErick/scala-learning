package scala

object Objects extends App {

  // esto es lo mas cercano a tener statics
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
  }

  class Person(name: String){

  }
  // COMPANIONS TODO: investigar mas sobre companions

  val erick = Person
  val monse = Person

  // definiendo como statics
  println(Person.N_EYES)
  println(Person canFly)

  println(erick == monse) // same memory space? True

  val mama = new Person("Silvia")
  val papa = new Person("Chuy")

  println(mama == papa) // same memory space? False

}
