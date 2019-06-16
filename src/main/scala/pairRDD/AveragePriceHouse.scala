package pairRDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AveragePriceHouse {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("average").setMaster("local[3]")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("files/RealEstate.csv")
    val cleanLines = lines.filter(line => !line.contains("Bedrooms")) // basicamente eliminamos el primer weon renglon

    // WTF? porque le pone el 1 en el value? WTF? ya lo vi y aun no le entiendo xd
    val housePricePairRdd = cleanLines.map(line => (line.split(",")(3), (1, line.split(",")(2).toDouble)))

    val housePriceTotal = housePricePairRdd.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
    println("housePriceTotal: ")
    for ((bedroom, total) <- housePriceTotal.collect()) println(bedroom + " : " + total)

    val housePriceAvg = housePriceTotal.mapValues(avgCount => avgCount._2 / avgCount._1) // la suma de todos los valores / los valores
    println("housePriceAvg: ")
    for ((bedroom, avg) <- housePriceAvg.collect()) println(bedroom + " : " + avg)
  }
}

// zupa blow mind con este ejercicio