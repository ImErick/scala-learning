package advanceExercises

import scala.collection.parallel.immutable.{ParSeq, ParVector}

object ParallelUtils extends App {
  // parallel collections
  val parList: ParSeq[Int] = List(1, 2, 3).par //this could be user by parallels threads at the same time
  val aParVector: ParVector[Int] = ParVector[Int](1, 2, 3)

  /*
  Could be:
  Seq
  Vector
  Array
  Map - Hash, Tree
  Set - Hash, Tree
  */

  def measure[T](operation: => T): Long = { // por referencia
    val time = System.currentTimeMillis()
    operation
    System.currentTimeMillis() - time
  }

  val list: List[Int] = (1 to 10000000).toList // ojo que aveces toma mas tiempo en serial por lo costoso que son los threads

  val serialTime: Long = measure {
    list.map(_ + 1)
  }
  val parallelTime: Long = measure {
    list.par.map(_ + 1)
  }

  println("serial time: " + serialTime)
  println("parallel time: " + parallelTime)

  // tambien aplica para el modelo de map-reduce
  List(1,2,3).reduce(_ - _)
  List(1,2,3).par.reduce(_ - _)
}
