package advanceExercises

object ThreadExercises extends App {
  // construct a 50 "inception" threads

  def inceptionThreads(maxThreads: Int, index: Int): Thread = new Thread(() => {
    if (index < maxThreads) {
      val newThread = inceptionThreads(maxThreads, index + 1)
      newThread.start()
      newThread.join()
    }
    println(s"holis desde mi thread $index")
  })

  inceptionThreads(50, 1).start()

  // que imprime X al final?
  var x = 0
  val threads = (1 to 100).map(_ => new Thread(() => x +=1))
  threads.foreach(_.start())
  threads.foreach(_.join())
  // cual es el mayor? pues 100, no? xD // siesciertooo no tienen orden
  // cual es el menor positivo? pues 1(?) // estoy bien
  println("resultado " + x)


}
