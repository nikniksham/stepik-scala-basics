package lectures.week2oop

object Exceptions extends App {
  def intOrNothing(hasException: Boolean): Int = {
    if (hasException) throw new RuntimeException else 200
  }

  // StackOverflowError - переполнение стек памяти (у тебя с рекурсией беда)
  // OutOfMemoryError - превышение достуной памяти (у тебя с индексом беда)
  // NullPointerException - пытаемся получить доступ к чему-то, чего нет
  // RuntimeException - бросается, когда необходимо указать на какие-то логические ошибки программы
  // throw new NullPointerException // Вызывает ошибку исскуственно
  // try catch
  try {
    throw new NullPointerException
  } catch {
    case e: NullPointerException => println("Нас попытались сломать")
  } finally {
    println("Но мы не сломались")
  }
  val exception = new MyException
  // throw exception

  // val exceptionVal = throw new NullPointerException // type Nothing

  val potentialException = try { // Универсальный тип данных, благодаря нашим фокусам с функцией
    intOrNothing(true)
  } catch {
    case e: RuntimeException => println("RTE is here")
  } finally {
    println("I will be there no matter what")
  }

}

class MyException extends Exception // Наша личная ошибка
