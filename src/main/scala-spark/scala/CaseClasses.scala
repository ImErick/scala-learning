package scala

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // los parametros del constructor YA son campos (ya no se necesita 'val'
  val erick = Person("Erick", 28)
  println(erick.name)

  // es accesible a toString
  println(erick.toString)
  println(erick) // lo mismo de arriba

  // equals y hashCode esta implementado
  val otroErick = Person("Erick", 28)
  println(erick == otroErick)

  // tienen metodo pa copiarse
  val nuevoErick = erick.copy() // se le puede pasar valores nuevos en los parentesis


}
