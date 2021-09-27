package playground

import scala.annotation.tailrec

object Test {
  def main(fArgs: Array[String]): Unit = {
    def hardFunc(x: Int, y: Int, n: Int): Unit = {
      @tailrec
      def loop(n: Int, y: Int, v: Int): Int = {
        if (n > 0) loop(n - 1, y, v + y) else v
      }

      @tailrec
      def loop2(n: Int, t: Int): Unit = {
        print(s"$t ")
        if (n > 0) loop2(n - 1, t)
      }
      val a = loop(n, y, x)
      loop2(a.toString.length - 1, a)
      print("is the result")
    }

    hardFunc(fArgs(0).toInt, fArgs(1).toInt, fArgs(2).toInt)
  }
}
