package scala

object TuplesAndMaps extends App {

  // Tuples
  val aTuple = ("erick", 28)
  println(aTuple._1) // erick
  println(aTuple.copy(_1 = "Solis"))
  println(aTuple.swap) // solo funciona con 2 elementos

  // Maps
  val aMap: Map[String, Int] =  Map()

  val directorio = Map(("Erick", 666), "Monse" -> 555) // 2 maneras de agregar al mapa
  println(directorio)

  // maps operations
  println(directorio.contains("Erick"))
  println(directorio("Erick"))
  val nuevo = "Abril" -> 444
  val nuevoDirectorio = directorio + nuevo
  println(nuevoDirectorio)

  // funciones con mapas
  println(directorio.filterKeys(_.startsWith("E")))

  // mapValues
  println(directorio.mapValues(numero => numero + 1)) // _ + 1

  // convertir a otras colleciones
  println(directorio.toList) // List((Erick,666), (Monse,555))
  val names = List("Erick", "Monse", "Abril", "Mama", "Papa")
  println(names.groupBy(_.charAt(0))) // agrupando por la primera letra del nombre

}
