package lectures.week2oop

object InheritanceScala extends App {
  val pupil = new Pupil("Nikolausus", 16, 1, "male")
  final val fun = "yes" // Финальная переменная
  println(pupil.greet)
  println(pupil.gender)

  val aPerson: Person = new Pupil("Alice", 15, 2, "female") // Полиморфизм
  println() // Мы создали переменную одного типа, а записали в неё класс другого (который наследуется от дочернего типа)

  val pbs = new PublicDataSource("SomeSource") // Создание абстрактного класса
  println(pbs.connect + " " + pbs.delete + " " + pbs.save) // Проверка работоспрособности
  println(pbs.iDoNotSeeYou)

  val someSource = new BaseDataSource("someDS") { // Анонимный класс
    override val user: String = "someSourceUser"

    override def connect: String = "someSource connection"
  }
  println(someSource.connect)

  var car = new Car(150, 0)
  var yacht = Yacht(500, 0, "White")
  car.setSeats(5)
  car = car.setPower(160)
  car.setSpeed(100)
  println(car.getPower)
  println(car.getSpeed)
  println(car.getSeats)
  yacht.setSpeed(90)
  yacht = yacht.setPower(750)
  yacht.setColor("Black")
  println(yacht.getPower)
  println(yacht.getColor)
  println(yacht.getSpeed)
  println(car || yacht)
  yacht = yacht.setPower(100)
  println(car || yacht)

  val abstractCar = new AbstractCar("car", 100)
  abstractCar.printSomething("Something")

}

class Person(name: String, age: Int) { // Класс родитель с параметрами
  val gender = "n/a"
  def this() = this("UnknownPeople", 0)
  protected def greet: String = "Hello"
}

class Pupil(name: String, age: Int, id: Int, puplGender: String) extends Person(name, age) { // Класс ребёнок, наследуется от класса родителя,
  // которому необходимо передать требуемые параметры
  // override val fun(): String = "No" // Не можем так сделать с финальной переменной
  override val gender: String = puplGender
  override def greet: String = s"${super.greet}, $name" // Переопределение protect функции
}

final class SomeFinalClass() // Финальный класс

// class ChildOfSomeFinalClass() extends SomeFinalClass // Не можем наследоваться от финального класса

sealed class SomeSealedClass() // Можно наследоваться от этого класса, но только в этом файле

sealed abstract class DayOfTheWeek(val name: String, val isWeekend: Boolean)

case object Monday extends DayOfTheWeek("Monday", false)
case object Tuesday extends DayOfTheWeek("Tuesday",  false)
case object Wednesday extends DayOfTheWeek("Wednesday", false)
case object Thursday extends DayOfTheWeek("Thursday", false)
case object Friday extends DayOfTheWeek("Friday", false)
case object Saturday extends DayOfTheWeek("Saturday", true)
case object Sunday extends DayOfTheWeek("Sunday", true)


abstract class BaseDataSource(dataSourceName: String) {
  def save: String = {
    s"Save method implemented"
  }

  def delete: String = {
    s"Delete method implemented"
  }

  val user: String
  def connect: String
}

class PublicDataSource(ds: String) extends BaseDataSource(ds) with PublicConn with PrivateConn {
  val user: String = "publicUser"

  override def connect: String = {
    s"Public Data Source, no password needed"
  }

  override def saveInfoAboutYou: String = "I save all info"

  override def iDoNotSeeYou: Boolean = true
}

trait PublicConn {
  def saveInfoAboutYou: String
}

trait PrivateConn {
  def iDoNotSeeYou: Boolean
}

trait Transport[A] { // Образ и подобие
  var movementSpeed: Int
  val power: Int
  def setSpeed(newSpeed: Int): Unit
  def setPower(newPower: Int): A
  def getSpeed: Int
  def getPower: Int
}

class Car(val power: Int, var movementSpeed: Int, private var countSeats: Int=4) extends Transport[Car] { // Наследованный от трейта по образу и подобию

  def ||(yacht: Yacht): String =  s"${if (yacht.getPower > this.getPower) "Яхта" else "Машина"} сильнее"

  override def setSpeed(newSpeed: Int): Unit = movementSpeed = newSpeed

  override def setPower(newPower: Int): Car = new Car(newPower, movementSpeed, countSeats)

  def setSeats(newCount: Int): Unit = countSeats = newCount

  override def getSpeed: Int = movementSpeed

  override def getPower: Int = power

  def getSeats: Int = countSeats
}

class Yacht(val power: Int, var movementSpeed: Int, private val color: String) extends Transport[Yacht] { // Наследованный от трейта по образу и подобию

  override def setSpeed(newSpeed: Int): Unit = movementSpeed = newSpeed

  override def setPower(newPower: Int): Yacht = new Yacht(newPower, movementSpeed, color)

  def setColor(newColor: String): Yacht = new Yacht(power, movementSpeed, newColor)

  override def getSpeed: Int = movementSpeed

  override def getPower: Int = power

  def getColor: String = color
}

object Yacht {
  def apply(pow: Int, speed: Int, color: String): Yacht = new Yacht(pow, speed, color)
}

abstract class AbstractTransport[A](name: String, power: Int) {
  def getPower: Int = power
  def getName: String = name
  def getSelf: A
  def getNum: Int
  def printSomething(something: String): Unit = println(something)
  def calcSum(x: Int, y: Int): Int = x + y

}

class AbstractCar(val name: String, val power: Int) extends AbstractTransport[AbstractCar](name, power) {
  override def getSelf: AbstractCar = this

  override def getNum: Int = 10
}