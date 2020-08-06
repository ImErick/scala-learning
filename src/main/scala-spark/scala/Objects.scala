package scala

object Objects extends App {

  // esto es lo mas cercano a tener statics
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother: String, father: String, name: String): Person = new Person(name)
  }

  class Person(name: String){
    def getName(): String = name
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
  val sofi = Person.apply("abril", "tizoc", "sofi")
  println(sofi.getName())

}
