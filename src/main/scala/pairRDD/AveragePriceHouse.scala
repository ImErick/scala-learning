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

    // hace una dupla donde la llave es el numero de cuartos y el valor es un contador empezando en (1) el precio de la casa
    val housePricePairRdd = cleanLines.map(line => (line.split(",")(3), AvgCount(1, line.split(",")(2).toDouble)))

    val housePriceTotal = housePricePairRdd.reduceByKey((x, y) => AvgCount(x.count + y.count, x.total + y.total))
    println("housePriceTotal: ")
    for ((bedroom, total) <- housePriceTotal.collect()) println(bedroom + " : " + total)

    // sacando el promedio
    val housePriceAvg = housePriceTotal.mapValues(avgCount => avgCount.total / avgCount.count) // la suma de todos los valores / los valores
    println("housePriceAvg: ")
    for ((bedroom, avg) <- housePriceAvg.collect()) println(bedroom + " : " + avg)
  }
}

// no mas sigo sin entender claramente el la creacion de la case class AVgCount