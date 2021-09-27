package lectures.week1basics

object Cycles extends App {
  var newList = List(1, 2, 3, 4, 5, 6)

  newList.foreach(elem => println(elem * elem))

  // for конструкция

  for (i <- 0 until newList.length) println(newList(i) + " * " + newList(newList.length - 1 - i) + " = " + newList(i) * newList(newList.length - 1 - i))

  // for конструкции посложнее
  def foo(n: Int, v: Int): IndexedSeq[(Int, Int)] = {
    for (i <- 0 until n; j <- i until n if i + j == v)
      yield (i, j)
  }

  def customFoo(n: Int, v: Int): IndexedSeq[(Int, Int, Int)] = {
    for (i <- 0 until n + 1 if i * i > v) yield (i, i * i, v)
  }

  foo(10, 10) foreach {
    case (i, j) => println(s"($i, $j) ")  // выводит (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
  }

  customFoo(15, 100) foreach {
    case (i, j, n) => println(s"Квадрат ${i} равен ${j} и больше ${n}")
  }

  // while

  var counter: Integer = 1;

  while (counter <= 5 ) {
    println(counter)
    counter += 1;
  }

  println()
  // do while

  do {
    if (counter >= 5) {counter = 0}
    counter += 1
    println(counter)
  }
  while( counter < 5 );


}
