package lectures.week1basics

object CodeBlock extends App {

  val y = 2
  val aCodeBlock = { // Внутри блока с кодом у нас локальная область видимости переменных, можно использовать те,
    // что уровнем выше, но все переменные, объявленные в блоке кода остаются в блоке кода
    // Все что случилось в Вегасе, остаётся в Вегасе.(с)
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false // Должен иметь в конце конструкцию, которая возвращает какое-либо значение
    // Или 1 + 2 * 3, функцию, текст и так далее
  }

  println(aCodeBlock) // выводит true

  val someValue = {
    1 < 0
    2 == 5
    4 < 9 // Вернёт true, так как это последнее выражение
  }

  val someCodeBlock = {
    if (someValue) 1 else 0
  }

  println(someCodeBlock)

}
