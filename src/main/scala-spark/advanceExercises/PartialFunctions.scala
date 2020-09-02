package advanceExercises

object PartialFunctions extends App {

  val niceFunction = (x: Int) => x match {
    case 1 => 10
    case 2 => 20
    case 3 => 30
  }

  val partialFunction: PartialFunction[Int, Int] = {
    case 1 => 10
    case 2 => 20
    case 3 => 30
  }

  println(partialFunction(2)) // las dos funciones de arriba hacen exactamente lo mismo

  // cosas utiles de las funciones parciales
  println(partialFunction.isDefinedAt(2)) // true
  println(partialFunction.isDefinedAt(666)) // false

  val lifted: Int => Option[Int] = partialFunction.lift
  println(lifted(2))
  println(lifted(666))

  val chainPf = partialFunction.orElse[Int, Int] {
    case 46 => 0
  }

  println(chainPf(1))
  println(chainPf(46))

  /*
  * Partial Functions solo pueden tener un parametro TODO: aun no le veo uso util pero se que lo tendra
  * https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples/
  * Me gusta que ya tengan el pattern matching incluido
  * */

  // creando de manera manual una funcion parcial
  val manual = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x > 0
    override def apply(v1: Int): Int = 666 + v1
  }

  println(manual.isDefinedAt(1)) //true
  println(manual(1)) // 667
  println(manual.apply(1)) // 667, lo mesmo de arriba

}
