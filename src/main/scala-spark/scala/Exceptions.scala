package scala

object Exceptions extends App {

  val truena: String = null
  // println(truena.length) // esto truena por un NullPointerException
  //throw new NullPointerException // tronando adrede tambien con un NPE

  // tons como las cachamos?

  try{
    // codigo que podria fallar
    println(getSomeErrors(true))

  } catch {
    case e: RuntimeException => println("atrapamos la excepcion")
  } finally {
    // codigo que se ejecutara de awebotl
    println("finally part")
  }

  def getSomeErrors(anError: Boolean): Int = {
    if (anError) throw new RuntimeException ("no Int")
    else 666
  }
}
