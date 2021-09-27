package lectures.week1basics

object Expressions extends App {
  val aVal = 1 + 2 * 3
  println(1 + 2 * 3) // Выражение что-то возвращает (по-моему это очевидно)
  // Интересные операторы
  // % 3 - выдает остаток от деления, в данном случае от 3-ёх
  println(100 % 3)
  // Битовые операции
  // >> 2 - Сдвиг вправо
  println(100 >> 2)
  // >> 3 - Сдвиг влево
  println(100 << 2)
  // >>> 3 - Сдвиг вправо без знака
  println(100 >>> 4)
  // ^ 3 - Побитовый исключающий ИЛИ оператор
  println(100 ^ 3)
  // & 3 - Побитовый И оператор
  println(100 & 3)
  // | 3 - Побитовый ИЛИ оператор
  println(100 | 3)
  // ~ 3 - Битовые операторы (сам хз)
  println(~2)

  // операторы if else
  val aCondition = true

  // Тернарный оператор
  val ifExpressionValue = if (aCondition) "True Condition" else "False Condition"
  println(ifExpressionValue) // выведет True Condition

  val someVal: Unit = print("I just want to print") // Unit тип данных, хранящий пустое значение
  println(someVal) // Соответственно выведет пустые скобки

  val aNumber = if (("string".length == 6 & 1 < 2) & ('1' +: "23" :+ '4').toInt == 1234) 24 else 123
  println(aNumber)

}
