package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
  val res = new Function1[Int, Int] { // Есть уже готовые функции в scala
    override def apply(x: Int): Int = x * x
  }

  println(res(4)) // 16

  val product = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(product(3, 4) ) // выводит 12

  // Лямбда функции
  // С одним параметром
  // 1
  val l11 = (x: Int) => x * 2
  println(l11(12)) // 24

  // 2
  val l21: Int => Int = x => 2 * x
  println(l21(13)) // 26

  // 3
  val l31 = { (x: Int) => x * 2 }
  println(l31(14)) // 28

  // 4
  val l41: Int => Int = _ * 2
  println(l41(15)) // 30

  // С двумя параметрами
  // 1
  val l12 = (x: Int, y: Int) => x * y
  println(l12(3, 4)) // 12

  // 2
  val l22: (Int, Int) => Int = (x, y) => x * y
  println(l22(3, 5)) // 15

  // 3
  val l32: (Int, Int) => Int = _ * _
  println(l32(3, 6)) // 18

  val noParams = () => true
  println(noParams) // Получим саму функцию
  println(noParams()) // Получим её результат

  val strlen: (String) => Int = _.length
  println(strlen("Hello, world!"))

  @tailrec
  def nTimes(f: Int => Int, x: Int,  n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }
  val increment = (x: Int) => x * 2
  println(nTimes(increment, 1, 3)) // 8

  def fbi(f: String => Int, w: String): Int = {
    f(w)
  }

  println(fbi(strlen, "Help me")) // 7

  // Каррированные функции
  // 1
  def car1(x: Int, y: Int) = x + y
  println(car1(1, 2)) // 3

  // 2
  def car2(x: Int) = (y: Int) => x + y
  println(car2(1)(2)) // 3

  // 3
  def car3(x: Int)(y: Int) = x + y
  println(car3(1)(2))

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n < 1) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }

  println(curryingNTimes(increment, 3)(1)) // 8


  def someFunc1: Int => ((Int) => Int) = (x: Int) => (y: Int) => x + y

  def someFunc2: Int => (Int => Int) = (x) => (y) => x + y

  def someFunc3 = (x: Int) => (y: Int) => x + y

  def someFunc4: Int => Int => Int = (x: Int) => (y: Int) => x + y
  println(someFunc1(2)(4))
  println(someFunc2(2)(4))
  println(someFunc3(2)(4))
  println(someFunc4(2)(4))

  def test = (x: Int) => (y: Int) => (z: Int) => x + y * z
  println(test(2)(2)(2))

  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val res2 = someFunc(1 )
  println(res2)
  println(someFunc(3)(4))
}
