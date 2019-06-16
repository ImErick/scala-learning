package pairRDD

import commons.Utils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AirpotNotInUSA {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("airports").setMaster("local")
    val sc = new SparkContext(conf)

    val airportsRDD = sc.textFile("files/airports.text")

    val airportPairRDD = airportsRDD.map(line => (line.split(Utils.COMMA_DELIMITER)(1),
      line.split(Utils.COMMA_DELIMITER)(3)))
    val airportsNotInUSA = airportPairRDD.filter(keyValue => keyValue._2 != "\"United States\"")

    airportsNotInUSA.saveAsTextFile("out/airports_not_in_usa_pair_rdd.text")
  }
}
