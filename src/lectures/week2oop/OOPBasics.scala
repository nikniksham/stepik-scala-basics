package lectures.week2oop

object OOPBasics extends App {
  // Иницилизация класса
  val student = new Student(1, "Niki")
  val noName = new Student()
  val zeroId = new Student(name = "Steve") // Указание переменной (ключа) и значения

  // Пример работа с публичной переменной
  println(student.name)
  student.name = "Niko" // Если перед переменной написать var, то её можно менять
  println(student.name)

  // Пример работы с приватным параметром класса
  println(student.getStudentClass())
  student.setStudentClass(11)
  println(student.getStudentClass())

  // Пример работы с перегруженными функциями
  println(student.calc(1))
  println(student.calc(1, 2))

  // Важность this
  println(student.withoutThis(2))
  println(student.withThis(2))

  // Проверка конструкторов
  println(noName.name)
  println(zeroId.id)
}

class Instructor(val id: Int, name: String, surname: String) {
  def fullName(): String = s"${name.capitalize} ${surname.capitalize}"
}

class Course(courseID: Int, title: String, val releaseYear: String, instructor: Instructor) {
  def getID(): String = {
    courseID + "" + instructor.id
  }

  def isTaughtBy(instructor: Instructor): Boolean = (this.instructor == instructor)

  def copyCourse(newReleaseYear: String): Course = new Course(courseID, title, newReleaseYear, instructor)
}

class Student(val id: Int, var name: String) { // Мы сделали переменную name членом класса, так как перед ней написали val/var

  def this(name: String) = this(0, name) // Перегруженные конструкторы (лучше использовать параметры по умолчанию)
  def this() = this(0, "noName")

  private var studentClass = 10 // Эту перменную нельзя просто так получить, для неё надо написать геттеры и сеттеры

  def getStudentClass(): Int = { // Геттер
    studentClass
  }

  def setStudentClass(newClass: Int): Unit = { // Сеттер
    studentClass = newClass
  }

  def calc(a: Int): Int = {
    a + id
  }

  def calc(a: Int, b: Int): Int = {
    a + b + id
  }

    def withoutThis(id: Int): String = {
    s"new id is $id, old id is $id"
  }

  def withThis(id: Int): String = {
    s"new id is $id, old id is ${this.id}"
  }

  println("Anything") // Выведеться в консоль первым, так как при создании экземпляра класса автоматически исполняются
  // все конструкции, описанные внутри класса
}