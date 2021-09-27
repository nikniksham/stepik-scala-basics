package playground

object haaaaaaaaaaard extends App {
  val anInstance = new SomeClass[Int]
  anInstance.someFunc(1)

  val anotherInstance = new SomeClass[String]
  anotherInstance.someFunc("some string")

  val doubleInstance = new SomeClass[Double]
  doubleInstance.someFunc(2.0)


}


class SomeClass[T] {
  def someFunc(aVal: T): Unit = println(s"generic type is used")
}