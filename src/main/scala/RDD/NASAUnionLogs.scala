package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/*      "in/nasa_19950701.tsv" file contains 10000 log lines from one of NASA's apache server for July 1st, 1995.
        "in/nasa_19950801.tsv" file contains 10000 log lines for August 1st, 1995

       Create a Spark program to generate a new RDD which contains the log lines from both July 1st and August 1st,
       take a 0.1 sample of those log lines and save it to "out/sample_nasa_logs.tsv" file.

       Keep in mind, that the original log files contains the following header lines.
       host	logname	time	method	url	response	bytes

       Make sure the head lines are removed in the resulting RDD.
     */

object NASAUnionLogs {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("unionLogs").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val julyLogs = sc.textFile("files/nasa_19950701.tsv")
    val augustLogs = sc.textFile("files/nasa_19950801.tsv")

    val allLogsLines = julyLogs.union(augustLogs)
    val cleanLogsLines = allLogsLines.filter(line => isNotHeader(line))
    val sample = cleanLogsLines.sample(withReplacement = true, fraction = 0.1)
    // www.level-up.one/sampling-with-replacement-sampling-without-replacement/

    sample.saveAsTextFile("out/sample_nasa_logs.csv")

  }

  // TODO: como hacer funciones en Scala?
  def isNotHeader(line: String): Boolean = !(line.startsWith("host") & line.contains("bytes")) // esta madre tambien
}
