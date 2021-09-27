package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
  // Циклы
  var i = 10

  // Цикл while
  while (i > 1) {
    i -= 1
    println(i)
  }

  // Цикл do while
  do { // Тело цикла
    i += 1
    println(i)
  }
  while (i < 10) // Логическое выражение

  // Цикл for
  for (a <- 1 to i) {
    println("Value of a: " + a);
  }

  // Рекурсивные функции
  // Нахождение факториала
  def Fact(x: Int): Int = {
    if (x <= 0) 1 else x * Fact(x - 1)
  }

  println(Fact(30))

  // Хвостовая рекурсия
  // Структура
  def mainFunc(n: Int): Int = { // Главная функция, её вызываем, в ней храниться наша рекурсивная функция (которую вызываем там же, да да)
    @tailrec
    def helpFunc(x: Int, y: Int = 1): Int = { // Вспомогательная функция, должна делать что-то и накапливать значение в специальной переменной!
      if (x == 0) y else helpFunc(x - 1, y * x)
    }

    helpFunc(n) // Вызов рекурсии
  }

  println(mainFunc(30))

  // Цикл while через хвостовую рекурсию
  def mainWhile(n: Int, text: String): Unit = {
    @tailrec
    def cycle(i: Int = 0): Unit = {
      println(text)
      if (i < n) cycle(i + 1)
    }
    cycle()
  }
  mainWhile(100000, "hello")

  // Вычисление степени двойки через хвостовую рекурсию
  def powerOfTwo(s: Int): BigInt = {
    @tailrec
    def loop(n: Int, v: BigInt=1): BigInt = {
      if (n > 0) loop(n - 1, v * 2) else v
    }
    loop(s)
  }
  println(powerOfTwo(32))

}
