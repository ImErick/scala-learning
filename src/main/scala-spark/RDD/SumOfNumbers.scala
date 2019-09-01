package RDD

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/*  Create a Spark program to read the first 100 prime numbers from in/prime_nums.text,
    print the sum of those numbers to console.
    Each row of the input file contains 10 prime numbers separated by spaces.
*/

object SumOfNumbers {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("reduce").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("files/prime_nums.text") // lees el archivo
    val numbers = lines.flatMap(line => line.split("\\s+")) // agarras los numeros spliteando por espacio
    val validNumbers = numbers.filter(number => !number.isEmpty) // filtras alv los probables numeros vacios
    val intNumbers = validNumbers.map(number => number.toInt) // lo casteas a enteros

    println("Sum is: " + intNumbers.reduce((x, y) => x + y)) // haces la suma de cada entero y 'ta daaaa

  }
}
