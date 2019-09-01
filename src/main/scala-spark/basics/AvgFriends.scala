package basics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object AvgFriends {

  def parseLine(line:  String): (Int, Int) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val friends = fields(3).toInt
    (age, friends)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "AvgFriends")
    val lines = sc.textFile("files/fakefriends.csv")

    val rdd = lines.map(parseLine) // output: (33,385) (33,2) (55, 221)...
    val totalByAge = rdd.mapValues(x => (x, 1)).reduceByKey((x, y) => (x._1 + y._1 , x._2 + y._2)) //out: (33,(387, 2))
    val averageByAge = totalByAge.mapValues(x => x._1 / x._2)
    val results = averageByAge.collect().sorted.foreach(println) // yey
  }

}
