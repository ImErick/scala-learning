package sparkSQL

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object HousePrice {

  val PRICE_SQ_FT = "Price SQ Ft"

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession.builder()
      .appName("HousePrice")
      .master("local[*]")
      .getOrCreate()

    val dataFrameReader = session.read

    val realEstate = dataFrameReader
      .option("header", "true")
      .option("inferSchema", value = true)
      .csv("files/RealEstate.csv")

    realEstate.groupBy("Location") //agrupa
      .avg(PRICE_SQ_FT) // saca el promedio
      .orderBy("avg(Price SQ Ft)") // ordena
      .show() // muestra

    session.stop()
  }
}
