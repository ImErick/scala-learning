package rockWithTheJVM

object Options extends App {
  // works with unsafe methods
  def unsafeMethod() = null

  val result = Option(unsafeMethod()) // y asi evitamos revisar si un valor es null o no con el clasico if(a!=null)
  println(result)

  def safeMethod() = "erick wapo"

  val resultado = Option(unsafeMethod()).orElse(Option(safeMethod()))
  println(resultado)

  // diseñando funciones que eviten regresar nulls
  def betterUnsafeMethod(): Option[String] = None
  def betterSafeMethod(): Option[String] = Some("erick wapo wapo")

  val betterResult = betterUnsafeMethod() orElse betterSafeMethod()
  println(betterResult)

  // puede usar map, filter y flatmap
  val myFistOption = Some(4)
  println(myFistOption)

  println(myFistOption.map(_ * 2))
  println(myFistOption.filter(x => x < 5)) // devuelve None si no cumple la condicion o el Some(x) en caso contrario
  println(myFistOption.flatMap(x => Option(x * 10)))
}
