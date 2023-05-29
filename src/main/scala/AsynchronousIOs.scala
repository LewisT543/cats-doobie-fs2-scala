import cats.implicits._
import cats.effect.{Fiber, IO, IOApp, ExitCode}

object AsynchronousIOs extends IOApp {

  val meaningOfLife: IO[Int] = IO(42)
  val favLang: IO[String] = IO("Scala")

  def createFiber: Fiber[IO, Throwable, String] = ???

  extension [A] (io: IO[A]) {
    def debug: IO[A] = io.map { value =>
      println(s"[${Thread.currentThread().getName}] $value")
      value
    }
  }


  def sameThread() = for {
    _ <- meaningOfLife.debug
    _ <- favLang.debug
  } yield ()

  def run(args: List[String]): IO[ExitCode] =
    sameThread().as(ExitCode.Success)

}