package RDD

import commons.Utils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object AirportsInUSAProblem {
  def main(args: Array[String]): Unit = {
    /* Create a Spark program to read the airport data from in/airports.text, find all the airports which are located in United States
       and output the airport's name and the city's name to out/airports_in_usa.text.

       Each row of the input file contains the following columns:
       Airport ID, Name of airport, Main city served by airport, Country where airport is located, IATA/FAA code,
       ICAO Code, Latitude, Longitude, Altitude, Timezone, DST, Timezone in Olson format

       Sample output:
       "Putnam County Airport", "Greencastle"
       "Dowagiac Municipal Airport", "Dowagiac"
       ...
     */
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("airports").setMaster("local[*]")
    // * significa que agarre todos los cores, [2] significa que agarrara solo 2 cores y solo local agarrara 1 core
    val sc = new SparkContext(conf)
    val allAirports = sc.textFile("files/airports.text")
    val airportsInUSA = allAirports.filter(line => line.split(Utils.COMMA_DELIMITER)(3) == "\"United States\"") // empieza desde 0, osea agarra el 4

    // a la verga que cagadero
    val airportNameAndCities = airportsInUSA.map(line => {
      val splits = line.split(Utils.COMMA_DELIMITER)
      splits(1) + ", " + splits(2)
    })

    airportNameAndCities.saveAsTextFile("out/airports_result.text")
  }
}
