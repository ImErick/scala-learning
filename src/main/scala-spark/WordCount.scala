import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]", "RatingCounter")
    val lines = sc.textFile("files/word_count.text")
    val words = lines.flatMap(line => line.split(" ")) // separar por espacios en blanco

    val wordCount = words.countByValue() // Map(Twenties, -> 1, II -> 2, industries. -> 1, economy -> 1,  -> 7,...
    for ((word, count) <- wordCount)
      println(word + ": " + count)
  }
}