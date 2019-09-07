package scala

object MapFlatMapFilter extends App {

  val myList = List(1, 2, 3, 4, 5)
  println(myList.head)
  println(myList.tail) // todos menos el primer (?)

  // map
  println(myList.map(_ + 1))
  println(myList.map(_ + " es un numero"))

  // filter
  println(myList.filter(_ % 2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x , x + 1)
  println(myList.flatMap(toPair)) // khe?

  // foreach
  myList.foreach(println)

  // for-comprehensions son un CAGADERO
}
