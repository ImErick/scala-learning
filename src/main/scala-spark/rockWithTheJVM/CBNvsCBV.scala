package rockWithTheJVM

object CBNvsCBV extends App {

  // Por valor(valor del objeto/parametro): como se manda a llamar siempre
  def functionByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  // Por referencia(direccion de memoria), tambien funciona con el lazy evaluation
  def functionByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  functionByValue(System.nanoTime())
  functionByName(System.nanoTime())

}
