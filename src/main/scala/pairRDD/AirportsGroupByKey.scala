package pairRDD

import commons.Utils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AirportsGroupByKey {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("airports").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("files/airports.text")

    val countryAndAirportNameAndPair = lines.map(airport => (airport.split(Utils.COMMA_DELIMITER)(3),
      airport.split(Utils.COMMA_DELIMITER)(1)))

    // chingon el group by key (reduce no porque es como una suma u operacion de valores)
    val airportsByCountry = countryAndAirportNameAndPair.groupByKey()

    // ojo aquiiiiii
    for ((country, airportName) <- airportsByCountry.collectAsMap())
      println(country + ": " + airportName.toList)
  }
}
