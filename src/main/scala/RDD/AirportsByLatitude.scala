package RDD

import commons.Utils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AirportsByLatitude {
  /*
        Each row of the input file contains the following columns:
        Airport ID, Name of airport, Main city served by airport, Country where airport is located, IATA/FAA code,
        ICAO Code, Latitude, Longitude, Altitude, Timezone, DST, Timezone in Olson format
   */

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("airportsLatitude").setMaster("local")
    val sc = new SparkContext(conf)
    val allAirports = sc.textFile("files/airports.text")
    val airportsLatitude = allAirports.filter(line => line.split(Utils.COMMA_DELIMITER)(6).toFloat > 40)

    val airportNameAndLatitude = airportsLatitude.map(line => {
      val splits = line.split(Utils.COMMA_DELIMITER)
      splits(1) + ", " + splits(6)
    })

    airportNameAndLatitude.saveAsTextFile("out/airportsLatitude_result.text")
  }

}
