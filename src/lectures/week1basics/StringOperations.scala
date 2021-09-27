package lectures.week1basics

object StringOperations extends App {
  val aString: String = "Hello, world!"

  // Операции со строками
  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(12, 13)) // выводит !
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("Hello", "Bye")) // выводит Bye, world!
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println(aString.reverse) // выводит !dlrow ,olleH
  println(aString.take(4)) // выводит Hell

  // Конвертация типов данных

  // Строку в число
  val aNumber = "42".toInt
  println(aNumber) // выводит 42
  println(aNumber.getClass) // выводит int

  // Число в строку
  val tString = 42.toString // Аналогично + ""
  println(tString) // выводит 42
  println(tString.getClass) // выводит class java.lang.String (String)

  // Строку в список
  val aList = "Ya hochy otdihat".split("\\s").toList // .split("\\s") - разбивает строку на слова, независимо от кол-ва пробелов
  println(aList) // List(Ya, hochy, otdihat)

  // Список в строку
  println(aList.mkString(" ")) // mkString склеивает список в строку, указывая между словами символ, который вы написали
  // Выведет Ya hochy otdihat

  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++: "bc" :++ "d") // abcd

  /*
  добавление в начало подразумевает наличие двоеточия после  плюса. Соответственно, добавление в конец - перед плюсом
  +: или :+ подразумевает, что присоединять будем одиночные элементы (работаем с типом char)
  ++ или :++ указывает, что присоединять будем несколько элементов (используем элементы типа String), следовательно здесь уже понадобятся двойные кавычки
  внимание на типы, с которыми работаем: в нашем случае присоединения всегда происходит к элементам типа String (в примере это "42" и "bc")*/

  val aStr = "42".+:('1')
  println(aStr.:+('3'))  // 1423

  println(1 +: List(2, 3)) // List(1, 2, 3)
  println(List(1, 2) ++: List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)

  println(List("foo") + "bar") // List(foo)bar (преобразует в строку)
  println(Set("foo") + "bar") // Set(foo, bar) (добавляет в Set, какой-то неопределённый этот ваш +)

  // Интерполяторы

  // s-интерполятор (здорового человека)
  val name = "John"
  val surname = "Smith"
  println(s"${aString.take(6)} ${name + " " + surname}") // выводит Hello, John

  // raw-интерполятор (курильщика)
  val someString = "This is \n a string"
  println(someString)
  println(raw"This is \n a string") // Не обращает внимание на \n, ёвыведет написанное в кавычках This is \n a string
  println(raw"$someString") // Выведет с переносом
}
