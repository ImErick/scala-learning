package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object NASASameHost {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("sameHost").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val julyLogs = sc.textFile("files/nasa_19950701.tsv")
    val augustLogs = sc.textFile("files/nasa_19950801.tsv")

    val julyHost = julyLogs.map(line => line.split("\t")(0))
    val augustHost = augustLogs.map(line => line.split("\t")(0))
    val allHost = julyHost.intersection(augustHost)

    //allHost.saveAsTextFile("out/nasa_hosts") // con este devuelve el nombre de la columna AKA host entre la lista xd

    //con esto quito el nombres
    val cleanedHostIntersection = allHost.filter(host => host != "host")
    cleanedHostIntersection.saveAsTextFile("out/nasa_logs_same_hosts.csv")
  }
}
