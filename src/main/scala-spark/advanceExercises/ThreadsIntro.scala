package advanceExercises

import java.util.concurrent.Executors

object ThreadsIntro extends App {
  // jvm threads
  val runnable = new Runnable {
    override def run(): Unit = println("runnung in paralelou")
  }

  val aThread = new Thread(runnable) // tambien se puede meter el runnable directamente en el new Thread()

  aThread.start() // create a JVM thread
  aThread.join() // joins until aThread finishes running

  val threadHello = new Thread(() => (1 to 5).foreach(_ => println("holis"))) // otra manera de declarar el runaable
  val threadBye = new Thread(() => (1 to 5).foreach(_ => println("bai")))

  threadHello.start()
  threadBye.start()

  // executors
  val pool = Executors.newFixedThreadPool(10) // tengo 10 threads a mi disposicion y se pueden reusar

  pool.execute(() => println("something in the thread pool"))

  pool.execute(() => {
    Thread.sleep(1000)
    println("done after 1 second")
  }) //TODO: deje una pregunta para Daniel espero que la conteste

  pool.shutdown() // si no lo ponemos se puede ciclar
  println(pool.isShutdown)

  def runInParallel(): Unit = {
    var x = 0
    val t1 = new Thread(() => x = 1)
    val t2 = new Thread(() => x = 2)
    t1.start()
    t2.start()
    println(x)
  } // provocando un RACE CONDITION que es cuando 2 threads quieren acceder al mismo recurso!!

  for (_ <- 1 to 100) runInParallel()

  // como resolvemos esto? con syncronized() o con @volatile
  /**
   * t1.synchronized(
   * t1.start())
   **/

}