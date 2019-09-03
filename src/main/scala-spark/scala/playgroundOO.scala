package scala

object playgroundOO extends App {

  println("ya jala de nuevo?")
  class Person(val name: String , favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def meets(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def isAlive: Boolean = true
    def introduceMySelf(): String = s"hi my name is $name and I like $favoriteMovie"
    def apply(): String = "deeeerp" // check this out!
  }

  val erick = new Person("Erick", "Forrest Gump")
  println(erick.likes("Forrest Gump"))
  println(erick likes "Forrest Gump") // esta es la misma wea usando lenguaje natural, recuerda que es de a 1 o 0 args

  val abril = new Person("Abril", "Mujer Maravilla")
  println(abril meets erick)
  println(erick + abril) // tambien se puede usando OPERADORES aritmeticos paps
  println(erick.+(abril))

  println(erick.isAlive)
  println(erick isAlive) // las mismas weas

  println(abril.introduceMySelf())
  println(abril.introduceMySelf) // si le quitas el parentesis sigue jalando aunque tira un WARNING

  println(abril())
  println(abril.apply()) // la misma wea! WTF
}
