package basics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object TestThings {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "testing")
    val lines = sc.textFile("files/test.text")

    // no lo esta imprimiendo como yo creeria
    println("printing values of map rdd:")
    val mapa = lines.map(_.split(" ")).collect()
    for (i <- mapa) for (j <- i) print(j)

    println("printing values of a flatmap: ") // definitivamente este ejemplo es mas facil con flatmap
    val mapaflat: Unit = lines.flatMap(x => x.split(" ")).collect().foreach(println)
  }
}
