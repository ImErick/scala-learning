package pairRDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object PairRddFromTupleList {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("create").setMaster("local[1]")
    val sc = new SparkContext(conf)

    val tuple = List(("Lily", 23), ("Jack", 29), ("Mary", 29), ("James", 8))
    val pairRDD = sc.parallelize(tuple) // parallelize como la normalmente pasamos la info harcodeada a un RDD

    // para que sirve coalesce? persistir en disco (?)
    pairRDD.coalesce(1).saveAsTextFile("out/pair_rdd_from_tuple_list")
  }
}
