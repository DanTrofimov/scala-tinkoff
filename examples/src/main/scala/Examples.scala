object Main {

  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)
  }

  def ifThenElse[T](cond: Boolean, t: => T, e: => T): T = {
    if (cond) t else e
  }

  def main(args: Array[String]): Unit = {
    // HOF
    val searchOdd = (arr: List[Int]) => searchInArray(_ % 2 == 1, arr)
    print(searchOdd(List(1, 2, 3)))

    // Generics
    ifThenElse[String](Math.random() * 10 > 2, "more", "less")

    def middle[T](data: Iterable[T]): T = {
      val midIndex = math.ceil(data.size / 2).toInt
      val splits = data.splitAt(midIndex)
      val lastSplit = splits._2

      lastSplit.head
    }

    println(middle(Seq(1, 7, 5, 9)))

    // Main structs.
    for (index <- 1 to 10) {
      println(index)
    }

    // Pattern matching
    val value = 1

    def numberName(): String = value match {
      case 1 => "one"
      case 2 => "two"
      case _ => "unknown"
    }

    case class Pet(name: String, says: String);

    val robotRegex = "([0-9]*)".r

    val kind = (pet: Pet) => pet match {
      case Pet("Rex", _) => "dog"
      case Pet(_, "meow" | "nya") => "cat"
      case Pet(_, robotRegex(says)) => "robot"
      case Pet(_, _) => "unknown"
    }

    // Partial Funcs.
    val log: PartialFunction[Double, Double] = {
      case num: Double if num > 0 => Math.log(num)
    }

    println(log.isDefinedAt(1.1))

    // Tuples
    type IntTuple = (Int, Int, Int)
    val tuple: IntTuple = (1, 2, 3)

    val (first, mid, last) = tuple
    println(tuple._2)

    // Optional[TypeSample] ~ ?, Either[TypeSample1, TypeSample2] ~ TypeSample1 || TypeSample2

    // Classes
    class Dog(val name: String) {
      println(s"$name initialized")

      def woof() = println(s"$name says woof")
    }

    val dog = new Dog("Gray")
    dog.woof()

    // Trait - abstract types
    trait Animal{
      def name: String
      val greeting: String = s"Hey, my name is $name"
    }

    // trait init
    val animal = new Animal{
      def name = "Bigl" // () => { return "Bigl" }
    }

    abstract class Car(model: String) {
      val printModel: String = s"This is $model"
    }

    // abstract class init
    val car = new Car("BMW"){}

    // Objects - unique type exemplar
    object Azat {
      val age = 21
      def saySmth: String = s"I'm $age"
    }

    // object-companion, bunch of static fields and methods
    class Cat(val name: String, val age: Int)

    object Cat{
      def apply(name: String, age: Int): Cat = {
        new Cat(name, age)
      }
    }

    // Case classes - bunch of fields
    case class Developer(age: Int, name: String)

    val developer = Developer(21, "Dan")

    // Common types
    final case class NamedInt(name: String, value: Int) // Named[Int]
    final case class NamedDouble(name: String, value: Double) // Named[Double]

    final case class Named[A](name: String, value: A)

    // and the others hard to understand features (Type System in Scala is Turing Complete)

    // Implicits
    trait Monoid[A] {
      def empty: A
      def combine(x: A, y: A): A
    }

    // without implicits
    def combineAll[A](list: List[A])(monoid: Monoid[A]): A = {
      list.foldLeft(monoid.empty)(monoid.combine)
    }

    implicit object IntMonoid extends Monoid[Int] {
      override def empty = 0
      override def combine(x: Int, y: Int): Int = x + y
    }

    implicit object BoolMonoid extends Monoid[Boolean] {
      override def empty = true
      override def combine(x: Boolean, y: Boolean): Boolean = x && y
    }

    def combineAllWithImplicits[A](list: List[A])(implicit monoid: Monoid[A]): A = {
      list.foldLeft(monoid.empty)(monoid.combine)
    }

    val boolList = List(true, false, true)
    val intList = List(1, 2, 3)

    println(combineAllWithImplicits(boolList))
    println(combineAllWithImplicits(intList))
  }
}
