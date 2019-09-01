package basics

object LearningScala1 {
  def main(args: Array[String]): Unit = {
    // VALUES are immutable constant
    val hello: String = "que pasa prros!"
    println(hello)

    // que se note que en Scala primero se define el nombre de la variable y luego el tipo de dato e_e

    // VARIABLES are mutable
    var helloWorld: String = "que pasa con "
    helloWorld += "la bandita hechiza"
    println(helloWorld)

    // recordar que se va a usar lo mas que pueda VALUES, entonces es hacer operaciones con val's
    val immutableHolis = hello + " puto calderon"
    println(immutableHolis)
    val meh = immutableHolis + " y fox"
    println(meh)

    // se puede imprimir los otros tipos dentro del main? SI
    println(numberOne)

    // formato para imprimir
    println(f"Pi is about $piMorePrecision%.3f") // olovorgo como en C!!!
    println(f"zero padding on the left: $numberOne%05d") //00001 -> WTF?

    // usar el simbolo de $ para referenciar a las variables dentro de una cadena
    println(s"checa este cagadero papu $numberOne $booleano $letra")

    println("comparacion de 2 String a la malageña: " + isBest)
  }

  // some other types
  val numberOne: Int = 1
  val booleano: Boolean = true
  val letra:  Char = 'E'
  val pi: Double = 3.141592
  val piMorePrecision: Float = 3.14159265f
  val shortNumber: Short = 6666
  val bigNumber: Long = 123456789
  val smallNumber: Byte = 123

  // String comparation
  val picard: String = "picard"
  val anotherPicard:  String = "picard"
  val isBest: Boolean = picard == anotherPicard
}
