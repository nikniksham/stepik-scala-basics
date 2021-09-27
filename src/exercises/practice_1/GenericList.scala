package exercises.practice_1

import java.util.NoSuchElementException
import scala.annotation.tailrec
import scala.runtime.Nothing$

object GenericList extends App {


  var list = new Log("a", new Log("b", new Log("c", Empty)))
  println(list.all)

  list = new Log("b", new Log("c", Empty))
  var newList = list.add("a")
  println(newList.all)

  list = new Log("a", new Log("b", Empty))
  newList = list.add("c")
  println(newList.last)

  list = new Log("c", new Log("b", new Log("a", Empty)))
  println(list.last)

  list = new Log("s", Empty)
  println(list.previous.all)

  val intLogs: LogList[Int] = Empty
  val strLogs: LogList[String] = Empty

  // list = new Log[Int](1,new Log[String]("2", new Log[Float](1.2f, Empty)))
}

abstract class LogList[+A] {
  val prev: LogList[A] = Empty
  def isEmpty: Boolean
  def all: String = ""
  def previous: LogList[A]
  def last: A
  def add[B >: A](msg: B): LogList[B]
  def getLog: A
}

class Log[+A](val log: A, prev: LogList[A]) extends LogList[A] {
  override def all: String = {
    def loop(pr: LogList[A], txt: String): String = {
      val text = if (txt == "") pr.getLog.toString else txt + s" ${pr.getLog}"
      if (!pr.previous.isEmpty) loop(pr.previous, text) else text
    }

    loop(this, "")
  }

  override def previous: LogList[A] = prev

  override def last: A = this.log

  override def isEmpty: Boolean = false

  override def add[B >: A](msg: B): LogList[B] = {
    new Log(msg, this)
  }

  override def getLog: A = log
}

object Empty extends LogList[Nothing] {

  override def isEmpty: Boolean = true

  override def previous: LogList[Nothing] = throw new NoSuchElementException

  override def last: Nothing = throw new NoSuchElementException

  override def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, this)

  override def getLog: Nothing = throw new NoSuchElementException
}