package lectures.week1basics

object TypesValuesVariables extends App {

  val testString: String = "Hello" // пояснение: val (неизменяемая переменная) или var (изменяемая переменная), название переменной, двоеточие формат, значение
  val testString2 = "World!" // Для удобства можно делать так, компилятор сам разберётся
  println(testString + " " + testString2)

  // Форматы
  // Текстовые
  val aString = "Some string"
  val aChar = 'C'

  // Числовые
  val aInt = 11
  val aLong = 11L
  val aFloat = 2.0f
  val aDouble = 2.0

  // Логические
  val aBoolean = true

  // Помощь в определении форматов
  val bLong = 11
  val bFloat = 2.0
  println(bLong.getClass + " " + bFloat.getClass) // выводит int double

  val cLong = 11L
  val cFloat = 2.0f
  println(cLong.getClass + " " + cFloat.getClass) // выводит long float

  val valString = "Hello"
  // valString = "Hello World!" Выдаст ошибку, так как val неизменяемый

  var varString = "Hello"
  varString = "Hello World!"
  println(varString)

  // Символ ; используется для разграничения выражений в одной строчке
  val tChar = 'c'; val tInt = 1
  // Однако лучше так не писать, так как такой метод снижает читабельность кода
}
