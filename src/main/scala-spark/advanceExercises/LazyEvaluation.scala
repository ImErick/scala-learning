package advanceExercises

object LazyEvaluation extends App {
  // lazy evaluation evalua una funcion en runtime peeero solo la primera vez

  //val x: Int  = throw new RuntimeException // truena en runtime
  lazy val x: Int  = throw new RuntimeException // ya no truena

  lazy val y: Int = { // pero para que sirve esto de las evaluaciones
    println("holis")
    42
  }

  println(y)
  println(y)

  // examples of implications

  def sideEffectsCondition: Boolean = {
    println("derp")
    true
  }

  def simpleCondition: Boolean = false

  lazy val sideResult = sideEffectsCondition
  // al ser evaluado como el if tiene un lazy value y la primera condicion YA regresa un false, ni es necesario
  // entrar a la otra funcion, a diferencia que si no tiene el 'lazy' de todas maneras la evalua
  // e imprime el "derp"

  println(if(simpleCondition && sideResult) "yay" else "nein")

  //TODO wtf esta bien raro lo de como usar lazy evaluation

  // Donde quedo el codigo de funciones por nombre/parametros? CBNvsCBV code

}
