package scala

object InheritanceAndTraits extends App {

  // herencia
  class Animal {
    val creatureType: String = "wild!"
    val sex: String = "undefined"
    protected def eat(): Unit = println("on nom nom nom")
    protected def poop(): Unit = println("poo in the loo")
  }

  // tambien se puede sobrescribir los valores desde el constructor
  class Cat(override val sex: String) extends Animal { // como la de Java, no hay pierde
    // sobrescritura de metodos de la clase padre
    override def eat(): Unit = println("miau miau weon")

    // tambien de values
    override val creatureType: String = "domestic!"

    // usando super
    override def poop(): Unit = super.poop()
  }

  val gato = new Cat("male")
  gato.eat()
  println(gato.creatureType)
  println(gato.sex)
  gato.poop()

  // constructores heredados
  class Person(name: String, age: Int) // otra manera de declarar clases vacias
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // esta es la manera correcta de heredar
}
