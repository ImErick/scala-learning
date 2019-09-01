package scala

object LearningScala4 {
  // data structures

  // creando una tupla. NOTA: puede ser de diferentes tipos de datos, en este caso no mas son Strings
  val names: (String, String, String) = ("Erick", "Javis", "Gaona")

  /*  creando una lista. NOTA: al parecer las listas son solo de un tipo y las listas si empiezan desde 0
      NOTA #2: se puede arreglar con un List[Any] para agarrar de tocho pero Any convierte a los objetos
      en tipo Any y la tupla si mantiene el tipo de objeto original de manera individual
  */
  val fruits: List[String] = List("melon", "limon", "sandia")

  val numbers = List(1,2,3,4,5)
  val moreNumbers = List(6,7,8,9)

  // mas trucos
  val alreves = numbers.reverse
  val ordenados = numbers.sorted
  val maximo =  numbers.max
  val total =  numbers.sum
  val contieneUnTres = numbers.contains(3)

  // Maps
  val organigrama = Map("Erick" -> "Lider", "Javis" -> "Perra #1", "Gaona" -> "Perra #2")

  def main(args: Array[String]): Unit = {
    println(names)

    // extrayendo un valor en especifico. NOTA: al parecer comienzan desde 1 en vez desde cero
    println("el jefe de la tupla es: " + names._1)

    // iterando sobre la tupla
    names.productIterator.foreach(x => println(x))

    // extrayendo un valor
    println("tengo ganas de un agua de " + fruits(1))
    println("primer elemento de la lista: " + fruits.head)
    println("ultimo elemento de la lista: " + fruits.tail) //ultimo elemento de la lista: List(limon, sandia) wut???

    for(fruta <- fruits) println(fruta)

    val sum = numbers.reduce((x: Int, y: Int) => x + y)
    println("total: " + sum)

    val removeFives = numbers.filter(x => x != 5)
    println("ya no hay 5s " + removeFives)

    println("mas numeros alv " + (numbers ++ moreNumbers))

    // en Maps imprime el valor mandando a llamar la llave
    println(organigrama("Erick"))

    // buscando las keys
    println(organigrama.contains("Erick"))
  }

}
