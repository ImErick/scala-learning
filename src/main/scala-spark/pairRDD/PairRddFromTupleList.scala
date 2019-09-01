package pairRDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object PairRddFromTupleList {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("create").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val tuple = List(("Lily", 23), ("Jack", 29), ("Mary", 29), ("James", 8))
    val pairRDD = sc.parallelize(tuple) // pasamos la info harcodeada a un RDD

    //println("tamaño de la particion " + pairRDD.partitions.size) // la particion por default usando todos mis CPU es de 8

    // para que sirve coalesce? coalesce method reduces the number of partitions in a DataFrame
    pairRDD.coalesce(1).saveAsTextFile("out/pair_rdd_from_tuple_list") // el 3 es de test
  }
}
