package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object Reduce {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("reduce").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val inputIntegers = List(1, 2, 3, 4, 5)
    val integerRdd = sc.parallelize(inputIntegers)

    val product = integerRdd.reduce((x, y) => x * y)
    println("product is :" + product)
  }
}
