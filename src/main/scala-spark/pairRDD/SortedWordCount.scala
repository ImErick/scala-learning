package pairRDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object SortedWordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("sorted").setMaster("local[3]")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("files/word_count.text")
    val wordRdd = lines.flatMap(line => line.split(" "))

    val wordPairRdd = wordRdd.map(word => (word, 1))
    val wordToCountPairs = wordPairRdd.reduceByKey((x, y) => x + y)

    val countToWordPairs = wordToCountPairs.map(wordToCount => (wordToCount._2, wordToCount._1))
    val sortedCountToWordParis = countToWordPairs.sortByKey(ascending = false) // ordenando de mayor coincidencias a menor
    val sortedWordToCountPairs = sortedCountToWordParis.map(countToWord => (countToWord._2, countToWord._1))

    for ((word, count) <- sortedWordToCountPairs.collect())
      println(word + " : " + count)
  }
}
