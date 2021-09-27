package lectures.week2oop

object CaseClasses extends App {
  // Обычный класс
  val usualClass = new UsualClass("UsualName")
  println(usualClass.name) // Доступ к переменной name только с ключевым словом в конструкторе

  // Класс образец (синтаксический сахар)
  val caseClass = new CaseClass("CaseClass", "GoodClass") // Параметры хоть и публичны, но неизменяемые (val)
  println(caseClass.name + " " + caseClass.occupation)

  // Удобство применения
  println(usualClass) // lectures.week2oop.UsualClass@5f2050f6
  println(caseClass) // CaseClass(CaseClass,GoodClass) Намного удобнее

  // Сравнение
  val caseClassDouble = new CaseClass("CaseClass", "GoodClass")
  val usualClassDouble = new UsualClass("UsualName")
  println(caseClass == caseClassDouble) // true
  println(usualClass == usualClassDouble) // false

  val copyCaseClass = caseClass.copy()
  println(copyCaseClass == caseClass) // true

  val caseClassTwin = caseClass.copy(name = "CaseClassTwin", occupation = "GoodClassTwin")
  println(caseClassTwin) // CaseClass(CaseClassTwin,GoodClass)

  // метод apply в действии
  val alice = CaseClass("Alice", "Engineer") // у case классов есть метод apply по умолчанию
  println(alice)
}

case class CaseClass(name: String, occupation: String) { // case class (класс образец)
}

class UsualClass(val name: String) { // Обычный класс
}