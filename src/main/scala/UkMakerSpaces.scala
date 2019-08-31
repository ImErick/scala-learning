import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SparkSession, functions}

object UkMakerSpaces {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession.builder()
      .appName("UkMakerSpaces")
      .master("local[*]")
      .getOrCreate()

    val makerSpace = session
      .read
      .option("header", "true")
      .csv("files/uk-makerspaces-identifiable-data.csv")

    val postCode = session
      .read
      .option("header", "true")
      .csv("files/uk-postcode.csv") // la wea WTF la de aqui abajo
      .withColumn("PostCode", functions.concat_ws("", functions.col("PostCode"), functions.lit(" ")))

    println("print 20 records of makerspace table")
    makerSpace.select("Name of makerspace", "PostCode").show()

    println("print 20 records of PostCode table")
    postCode.show()

    val joined = makerSpace.join(postCode, makerSpace.col("Postcode")
      .startsWith(postCode.col("Postcode")), "left_outer")

    println("print join's result")
    joined.groupBy("Region").count().show(200)

    session.close()
  }
}
