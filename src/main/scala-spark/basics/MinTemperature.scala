package basics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import scala.math.min

object MinTemperature {

  def parseLine(line: String): (String, String, Float) = {
    val fields = line.split(",")
    val stationID = fields(0)
    val entryType = fields(2)
    val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f // convert Celsius to Fahrenheit
    (stationID, entryType, temperature)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "MinTemperature")
    val lines = sc.textFile("files/1800.csv")

    val parsedLines = lines.map(parseLine)
    val minTemps = parsedLines.filter(x => x._2 == "TMIN")
    val stationTemps = minTemps.map(x => (x._1, x._3.toFloat)) // create (stationID, temperature) key/values pairs
    val minTemperatureByStation = stationTemps.reduceByKey((x, y) => min(x, y))

    val results = minTemperatureByStation.collect()
    for (r <- results.sorted) {
      val station = r._1
      val temp = r._2
      val formattedTemp = f"$temp%.2f F"
      println(s"$station minimum temperature: $formattedTemp")
    }
  }
}
