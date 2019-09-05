package sparkSQL

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object playground {
  // https://stackoverflow.com/questions/48114340/how-to-update-existing-sparksession-instance-or-create-a-new-one-in-spark-shell


  /*val anotherSession = SparkSession.builder()
    .appName("playground")
    .master("local[1]")
    .getOrCreate()*/

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession.builder()
      .appName("playground")
      .master("local[1]")
      .getOrCreate()

    println("sesion de dentro recien definida " + session.conf.getAll)
    println("primer master " + session.conf.get("spark.master"))
    session.conf.set("spark.master", "local[*]")
    println(session.conf.getAll)
    println("master cambbiadirijillo antes del if " + session.conf.get("spark.master"))

    val x = 42: Int
    if (x == 42) {
      session.conf.set("spark.master", "local[2]")
      println("master cambbiadirijillo dentro del if " + session.conf.get("spark.master"))
    } else {
      session.conf.set("spark.master", "local[3]")
      println("master cambbiadirijillo dentro del else " + session.conf.get("spark.master"))
    }

    //session.newSession()
    println("master final antes de cerrar " + session.conf.get("spark.master"))
    //println("another session " + anotherSession.conf.getAll)
    session.close()
  }
}
