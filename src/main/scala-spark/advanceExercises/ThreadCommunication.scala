package advanceExercises

object ThreadCommunication extends App {

  class SimpleContainer {
    private var value: Int = 0

    def isEmpty: Boolean = value == 0

    def set(newValue: Int): Unit = value = newValue

    def get: Int = {
      val result = value
      value = 0
      result
    }
  }

  def ProducerConsumer(): Unit = {
    val container = new SimpleContainer
    val consumer = new Thread(() => {
      println("[consumer] waiting...")
      while (container.isEmpty) {
        println("[consumer] actively waiting...")
      }
      println("[consumer] I have consumed " + container.get)
    })

    val producer = new Thread(() => {
      println("[producer] computing...")
      Thread.sleep(500)
      val value = 42
      println(s"[producer] I have produced, after long work, the value: $value")
      container.set(value)
    })

    consumer.start()
    producer.start()
  }

  //ProducerConsumer()

  /**
   * val someObject = "holis"
   * someObject.synchronized {
   * // code
   * }
   *
  **/

  // wait and notify only work in synchronized expressions
  def smartProducerConsumer(): Unit = {
    val container = new SimpleContainer

    val consumer = new Thread(() => {
      println("[consumer #2] waiting...")
      container.synchronized({
        container.wait()
      })

      // container muust have some value
      println("[consumer #2] I have consumed " + container.get)
    })

    val producer = new Thread(() => {
      println("[producer #2] hard at work...")
      Thread.sleep(2000)
      val value = 42

      container.synchronized({
        println("[producer #2] I'm producing " + value)
        container.set(value)
        container.notify()
      })
    })

    producer.start()
    consumer.start()
  }

  smartProducerConsumer()

  // exercises
  def testNotifyAll(): Unit = {
    val bell = new Object

    (1 to 10).foreach(i => new Thread(() => {
      bell.synchronized({
        println(s"[thread $i] waiting...")
        bell.wait()
        println(s"[thread $i] yay!")
      })
    }).start())

    new Thread(() => {
      Thread.sleep(2000)
      println("[announcer] Rock'n roll!")
      bell.synchronized({
        bell.notifyAll()
      })
    }).start()
  }

  testNotifyAll() // diferencia entre notify() y notifyAll()
  // https://www.java67.com/2013/03/difference-between-wait-vs-notify-vs-notifyAll-java-thread.html
}
