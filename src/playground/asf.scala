package playground

object asf extends App {
  val b: A = new B()
  val c: A = new C()
  println(b.f + " " + c.f)

}

abstract class A {
  def f: Boolean

}

class B extends A {
  override def f: Boolean = true
}

class C extends A {
  override def f: Boolean = false
}