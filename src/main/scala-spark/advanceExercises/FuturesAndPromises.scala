package advanceExercises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success} // handle thread allocation

object FuturesAndPromises extends App {

  def calculateMeaningOfLife(): Int = {
    Thread.sleep(2000)
    42
  }

  val aFuture = Future {
    calculateMeaningOfLife() // calculate el meaning de la vida en another thread :0!!!!
  } // (global) which is passed by the compiler

  // A future is a computation that will hold a value which is computed by somebody in some thread at some point in time
  println("Waiting the future...")
  aFuture.onComplete {
    case Success(x) => println(s"the value is $x")
    case Failure(exception) => println(s"I have failed with the exception $exception")
  } // create by some thread

  Thread.sleep(3000)

  // TODO: no me sale el ejercicio del capitulo 28, revisar cosas de fallbacks

  case class User(name: String)
  case class Transaction(sender: String, receiver: String, amount: Double, status: String)

  object BankingApp {
    val name = "Rock the JVM banking"

    def fetchUsers(name: String): Future[User] = Future {
      Thread.sleep(500) // simulate a fetching in the dB
      User(name)
    }

    def createTransaction(user: User, merchatName: String, amount: Double): Future[Transaction] = Future {
      Thread.sleep(1000) // simulate some process
      Transaction(user.name, merchatName, amount, "SUCCESS")
    }

    def purchase(username: String, item: String, merchantName: String, cost: Double): String = {
      // fetch the user from the DB
      // create a transaction
      // wait for the transaction to finish
      val transactionStatusFuture = for {
        user <- fetchUsers(username)
        transaction <- createTransaction(user, merchantName, cost)
      } yield transaction.status // revisar el for: https://docs.scala-lang.org/tutorials/FAQ/yield.html

      Await.result(transactionStatusFuture, 2.seconds )
    }
  }

  println(BankingApp.purchase("Daniel", "iPhone", "iStore", 3000))

  // promises
  val promise = Promise[Int]() // controller over a future

  //TODO: definitivamente es un buen inicio pero hay que estudiarlos mas :D!
}
