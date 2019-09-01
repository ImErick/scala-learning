package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object PersistExample {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("persist").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val inputIntegers = List(1,2,3,4,5)
    val integersRDD = sc.parallelize(inputIntegers)

    integersRDD.persist(StorageLevel.MEMORY_ONLY)
    integersRDD.reduce((x, y) => x * y)
    integersRDD.count()

    // revisar nota en OneNote
  }
}
