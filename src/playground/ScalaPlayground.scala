package playground

  object ScalaPlayground {
    def main(args: Array[String]) : Unit = {
      println(scala.io.StdIn.readLine().split("\\s+").toList.reverse.mkString(" ")) // "\\s" разбивает строку на слова
    }
  }
