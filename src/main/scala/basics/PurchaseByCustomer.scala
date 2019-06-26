package basics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object PurchaseByCustomer {

  def extractCustomerValues(line: String): (Int, Float) = {
    val fields = line.split(",")
    (fields(0).toInt, fields(2).toFloat)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "PurchaseByCustomer")
    val lines = sc.textFile("files/customer-orders.csv")

    val mappingValues = lines.map(extractCustomerValues)
    val totalByCustomer = mappingValues.reduceByKey((x,y) => x + y)
    // sorting the values by VALUES and ascending FALSE in order to show the results
    val results: Unit = totalByCustomer.sortBy(_._2, ascending = false).collect().foreach(println) // x => x._2
  }

}
