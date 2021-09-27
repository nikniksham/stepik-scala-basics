package exercises.practice_1

import java.util.NoSuchElementException

object LinkedList extends App {


  var list = new Log("a", new Log("b", new Log("c", Empty)))
  println(list.all)

  list = new Log("b", new Log("c", Empty))
  var newList = list.add("a")
  println(newList.all)

  list = new Log("a", new Log("b", Empty))
  newList = list.add("c")
  println(newList.all)

  list = new Log("c", new Log("b", new Log("a", Empty)))
  println(list.all)

  list = new Log("s", Empty)
  println(list.previous.all)




  abstract class LogList {
    val prev: LogList = Empty
    val log: String = ""
    def isEmpty: Boolean
    def all: String = ""
    def previous: LogList
    def last: String
    def add(msg: String): LogList
  }

  class Log(override val log: String, override val prev: LogList) extends LogList {
    override def all: String = {
      def loop(prev: LogList, txt: String): String = {
        val text = if (txt == "")  prev.log else txt + s" ${prev.log}"
        if (!prev.isEmpty) loop(prev.prev, text) else txt
      }
      loop(this, "")
    }

    override def previous: LogList = prev

    override def last: String = this.log

    override def isEmpty: Boolean = false

    override def add(msg: String): LogList = new Log(msg, this)
  }

  object Empty extends LogList {
    override def isEmpty: Boolean = true

    override def previous: LogList = throw new NoSuchElementException

    override def last: String = throw new NoSuchElementException

    override def add(msg: String): LogList = new Log(msg, this)
  }
}