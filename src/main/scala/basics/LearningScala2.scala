package basics

object LearningScala2 {
  def main(args: Array[String]): Unit = {

    // matching es el switch de Scala
    val number = 3 // se le puede no poner el tipo de dato, aca como python
    number match {
        case 1 => println("uno")
        case 2 => println("dos")
        case 3 => println("tres :O!")
        case _ => println("ñam ñam") // este es el default
    }
  }

  // flow control
  if (1 > 3) println("na mames") else println("esto tiene mas sentido")

  // or
  if (1 > 3) {
    println("na mames x2")
  } else {
    println("esto tiene mas sentido x2")
  }

  // for loops
  for (x <- 1 to 10) // como lo hemos hecho ya antes
    println(x*2)

  // while loops
  var x = 10
  while (x >= 0){
    print(x)
    x-=1
  }

  // do-while
  var y = 0
  do {
    println(y)
    y+=1
  } while (y <= 10)

}
