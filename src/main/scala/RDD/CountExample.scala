package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object CountExample {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("count").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val inputWords = List("spark", "hadoop", "spark", "hive", "pig", "cassandra", "hadoop")
    val wordRdd = sc.parallelize(inputWords)
    println("Count: " + wordRdd.count())

    val wordCountByValue = wordRdd.countByValue()
    println("CountByValue:")

    for ((word, count) <- wordCountByValue) println(word + " : " + count)

    // EJEMPLO DE TAKE (me dio weba hacer un object aparte)
    val tomalaWea = wordRdd.take(3)
    println("la wea " + tomalaWea.toList) // lelelel asi no weon, tienes que iterar

    for (w <- tomalaWea) println(w) // asi mejor
  }
}
