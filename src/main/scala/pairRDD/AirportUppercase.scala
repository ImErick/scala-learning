package pairRDD

import commons.Utils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AirportUppercase {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("airports").setMaster("local")
    val sc = new SparkContext(conf)

    val airportsRDD = sc.textFile("files/airports.text")
    // ojo aqui abajo lo castea de una vez como un string para no meterse en problemas
    val airportPairRDD = airportsRDD.map((line: String) => (line.split(Utils.COMMA_DELIMITER)(1),
      line.split(Utils.COMMA_DELIMITER)(3)))

    // ojo aqui, mapValues modificara el valor de la llave como tu quieras
    val upperCase = airportPairRDD.mapValues(countryName => countryName.toUpperCase)

    upperCase.saveAsTextFile("out/airports_uppercase.text")
  }
}
