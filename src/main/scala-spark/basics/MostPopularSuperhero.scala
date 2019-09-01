package basics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object MostPopularSuperhero {

  // Function to extract the hero ID and number of connections from each line
  def countCoOccurences(line: String): (Int, Int) = {
    var elements = line.split("\\s+") // expresion regular para separar la wea por espacios en blanco
    (elements(0).toInt, elements.length - 1)
  }

  // Function to extract hero ID -> hero name tuples (or None in case of failure)
  def parseNames(line: String) : Option[(Int, String)] = {
    var fields = line.split('\"') // expresion regular para separar por comillas
    if (fields.length > 1) {
      Some(fields(0).trim().toInt, fields(1))
    } else {
      None
    }
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("MostPopularSuperhero").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // first part
    val names = sc.textFile("files/Marvel-names.txt")
    val namesRdd = names.flatMap(parseNames)

    // second part
    val lines = sc.textFile("files/Marvel-graph.txt")
    val pairings = lines.map(countCoOccurences)
    val totalFriendsByCharacter = pairings.reduceByKey((x,y) => x + y) // Combine entries that span more than one line

    val flipped = totalFriendsByCharacter.map( x => (x._2, x._1) ) // Flip it to # of connections, hero ID

    val mostPopular = flipped.max()

    // Look up the name (lookup returns an array of results, so we need to access the first result with (0)).
    val mostPopularName = namesRdd.lookup(mostPopular._2)(0) //TODO: revisar mas sobre lookup

    // Print out our answer!
    println(s"$mostPopularName is the most popular superhero with ${mostPopular._1} co-appearances.")

    // solution TODO: porque el signo de menos antes de tomar los valores?
    val results = flipped.collect()
    for (r <- results.sortBy(-_._1).take(10)) {
      val namesito = namesRdd.lookup(r._2)(0)
      println(namesito)
    }
  }
}
