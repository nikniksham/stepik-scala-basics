package lectures.week2oop

object ScalaObjects extends App {
  println(Number.Pi + " " + Number.g + " " + Number.R) // Обращаемся к параметрам

  object A {
    val a: String = "value a"
    println("object A")
  }

  val ooo = A // При инициализации вызывает всё, что есть в объекте, в том числе println(), НО ТОЛЬКО 1 РАЗ!
  val ooo2 = A // Уже не вызывает всё повторно, а по факту является копией ooo
  println(ooo.a)
  println(ooo2.a)

  val a = Number
  val b = Number
  println(a == b) // true, так как ссылаются на 1 и тот же объект

  val ca = new Number()
  val cb = new Number()
  println(ca == cb) // false, так как ссылаютя на разные объекты

  println(Number.changeNum(10032).getNum()) // Проверяем смену приватного параметра через компаньона

  val an = new N(1)
  val bn = new N(2)
  val cn = N(an, bn) // Создали экземпляр класса,применив новый интерфейс
  val dn = N(bn, cn)
  println(an.num) // 1
  println(bn.num) // 2
  println(cn.num) // 3
  println(dn.num) // 5
}

class Number(private var num: Int = 0) {
  def getNum(): Int = num
}

object Number { // Объект, по совместительству компаньон одноимённого класса
  def changeNum(newNum: Int): Number = {
    val newNumber = new Number()
    newNumber.num = newNum // Без проблем меняем приватную переменную класса
    newNumber
  }
  val Pi = 3.14 // Создаём параметры
  val g = 10
  val R = 8.31
}

class N(val num: Int)

object N { // apply вызывается автоматически, при указании скобок
  def apply(x: N, y: N): N = new N(x.num + y.num) // Фабричный метод
}