package lectures.week1basics

object Functions extends App {
  // Функция
  // Синтаксис функции: определяющее слово, название фунции, в скобках параметры, двоеточие и тип возвращаемых данных, равно и блок кода
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }

  // Перегруженная функция (тоже самое название, но аргументов больше/имеют другой тип данных
  def aPerson(name: String, surname: String, age: Int): Unit = println(s"$name $surname age: $age") // Выводит информацию и возвращает пустой тип данных (заглушку)
  aPerson("Niko", "lausus", 21)

  // Функция с параметром по умолчанию
  def bPerson(name: String, surname: String, age: Int = 13): Unit = println(s"$name $surname age: $age") // Параметр по умолчанию имеет значение, что делает его необязательным
  bPerson("Niko", "lausus", 17)
  bPerson("Niko", "lausus")

  // Функция без параметров
  def aParameterlessFunction(): Unit = println("Function with no parameters")

  aParameterlessFunction()
  aParameterlessFunction

  // Вызов по имени(call-by-name) vs Вызов по значению(call-by-value)
  def callByValue(x: Long): Unit = { // Вызов по значению подразумевает вычисление значения переданного выражения перед вызовом функции
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = { // Вызов по имени подразумевает вычисление значения выражения в момент его вызова в функции
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def someInfinityFunc(x: Int = 1): Int = {someInfinityFunc(x + 1)} // Функция с бесконечной рекурсией

  def someOtherFunc(x: Int, func: Int): Int = {x * 2} // Если вызвать эту функцию, то запустится функция с бесконечной рекурсией

  def someOtherFunc2(x: Int, func: => Int): Int = {x * 2} // Если вызвать эту функцию, то функция с бесконечной рекурсией не запустится, так ка кне вычисляется

  println(someOtherFunc2(2, someInfinityFunc()))

  def aBossFunction(): String = { // Папа функция (Boss of this Gym)
    def aHelperFunction(): String = "I'm here to help" // Функция помощник, которая возвращает строку, необходимую для папы

    aHelperFunction()
  }

  println(aBossFunction())

}
