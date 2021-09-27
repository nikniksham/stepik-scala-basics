package lectures.week2oop

object InfixNotation extends App {
  val bob = new NewPerson("Bob", "Developer", 4)
  val john = new NewPerson("John", "Developer", 2)

  println(bob.worksAs("Developer")) // true

  // Инфиксная нотация
  println(bob worksAs "Developer") // true Инфиксная нотация, может быть применена, так как 1 аргумент
  // println(bob worksAsWithExp "Developer" 4) // true Инфиксная нотация не сработает, так как у функции более 1 параметра

  // Постфиксная нотация
  println(bob.speaksEnglish) // точечная нотация
  println(bob speaksEnglish) // постфиксная нотация

  // Операторы
  println(1 + 2) // обычное обращение
  println(1.+(2)) // обращение через точку

  // Оператор в качестве функции у класса
  println(bob.&(john)) // Точечная нотация
  println(bob & john) // Инфиксная нотация, Удобная вещь, надо запомнить

  // Префиксная нотация
  val x = -1 // Способ записи адекватного человека
  val x2 = 1.unary_- // Способ записи человека, который не спал 3 дня
  println(x + " " + x2) // -1 -1
  println(bob.unary_!) // Беда с башкой, как же он не реальный, если вот он, в качестве объекта класса

  // Ещё раз про нотации
  println(!bob) // префиксная нотация
  println(bob.unary_!) // точечная нотация
  println(bob unary_!) // постфиксная нотация

  // Вызов apply() у класса NewPerson
  println(bob.apply(true))
  println(bob(false)) // используется наболее часто
  println(bob (true))
  println(bob apply (false))
  // Да-да, это всё работает!

  println(bob.isDeveloper)

  val a = new IHateThisMethods
  println(a.isDeveloper)
  println(a.isDeveloper2)
  println(a.isDeveloper3)
  println(a.isDeveloper4)
  // Все эти поганые методы тоже сработают, синтаксис вышел в окно

  val person = new Person("Bob")
  println((+person).name)

  class Person(var name: String) {
    def unary_+ : Person = new Person(s"${this.name} NoSurname")
  }

}

class NewPerson(val name: String, occupation: String, experience: Int) {
  def worksAs(jobName: String): Boolean = jobName == occupation

  def worksAsWithExp(jobName: String, exp: Int): Boolean = jobName == occupation && experience == exp

  def speaksEnglish: Boolean = true

  def &(person: NewPerson): String = s"${this.name} and ${person.name} are colleagues" // Оператор в качестве функции у класса

  def unary_! : String = s"$name is not real" // Стоит пробел и двоеточие, что бы указать компилятору на то, что у этой функции нет параметров

  def apply(pleasure: Boolean): String = s"$name works as a $occupation ${if (pleasure) "with" else "without"} pleasure "

  def worksAs2(jobName: String): String = s"$name is a $jobName"

  def isDeveloper = this worksAs2 "Scala Developer" // Так делать НЕХОРОШО!

}

class IHateThisMethods {
  def worksAs(jobName: String): String = s"$jobName"
  def isDeveloper = worksAs("Scala Developer")
  def isDeveloper2 = this.worksAs("Scala Developer")
  def isDeveloper3 = this worksAs("Scala Developer")
  def isDeveloper4 = this worksAs "Scala Developer"

}