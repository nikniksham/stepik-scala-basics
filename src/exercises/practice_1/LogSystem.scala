package exercises.practice_1

object LogSystem extends App {
  val logger = new Logger
  logger.info.print
  logger.info.info.info.print
  logger.info.info.info.print
  println()
  println()
  println()
  val logger2 = new Logger
  logger2.info.print
  logger2.info(3).print
  logger2.info.info.info.print
}

class Logger {
  private var messageCount = 0

  def info(): Logger = {
    messageCount += 1
    println("INFO New Message")
    this
  }

  def info(n: Int): Logger = {
    def loop(n: Int, msg: String): Unit = {
      info()
      if (n > 1) loop(n - 1, msg)
    }
    loop(n, "INFO New Message")
    this
  }

  def print = {println(messageCount); messageCount=0}
}