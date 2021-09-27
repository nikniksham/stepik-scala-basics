package lectures.week2oop

object Generics extends App {

  val myClass = new MyClass[Int]

  println(myClass.randomItem(List(1, 2, 3, 4, 5)))
  println(myClass.randomItem(List("a", "bc", "def")))
  println(myClass.randomItem(List(1.5, 2.75, 3.8)))

  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit] // Инвариантность
  // Тип справа должен совпадать с типом слева

  val contravariantList: ContravariantList[BoneApple] = new ContravariantList[BoneApple] // Контравариантность
  // Список должен быть класса текущего и до родительского

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple] // Ковариантность
  println()
  // Только для своего и дочерних классов

  // Ограниченные типы
  val food = new Food(new Apple) // Сработает
  // val moreFood = new Food(new Pizza) // Выдаст ошибку, так как не является классом, наследующимся от класса Fruit

  val superFood = new SuperFood(new Apple)

  val fruit = new Fruit
  val apple = new Apple
  val boneApple = new BoneApple
  val banana = new Banana

  // Ковариантность
  var fruits: List[Fruit] = List(fruit, apple, boneApple, banana)
  fruit.printFruitTypes(fruits)

  // Контрвариантность
  val fruitPrinter = new FruitPrinter
  val applePrinter = new ApplePrinter

  fruitPrinter.print(fruit)
  fruitPrinter.print(apple)
  fruitPrinter.print(boneApple)
  fruitPrinter.print(banana)

  println()

  // applePrinter.print(fruit)
  applePrinter.print(apple)
  applePrinter.print(boneApple)
  // applePrinter.print(banana)

}

class Food[T <: Fruit](fruit: T)

class SuperFood[T >: Fruit](fruit: T)

class Pizza

class Fruit {
  val t = "Фрукт"
  def getType() : Unit = println(t)

  def printFruitTypes(fruits: List[Fruit]): Unit = {
    fruits.foreach { fruit =>
      fruit.getType()
    }
  }
}

class Apple extends Fruit {
  override val t = "Яблоко"
  override def getType() : Unit = println(t)
}

class BoneApple extends Apple {
  override val t = "Яблочная косточка"
  override def getType() : Unit = println(t)
}

class Banana extends Fruit {
  override val t = "Банан"
  override def getType() : Unit = println(t)
}

abstract class Printer[-A] {
  def print(value: A): Unit
}

class FruitPrinter extends Printer[Fruit] {
  override def print(value: Fruit): Unit = println(s"The fruit type is ${value.t}")
}

class ApplePrinter extends Printer[Apple] {
  override def print(value: Apple): Unit = println(s"The apple type is ${value.t}")
}

class InvariantList[A] { // Инвариантность
}

class CovariantList[+A] { // Ковариантность
}

class ContravariantList[-A] { // Контравариантность
}

class MyClass[A] {
  def randomItem[B](items: List[B]): B = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }
}