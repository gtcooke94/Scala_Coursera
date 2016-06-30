package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(contains(union(singletonSet(1), singletonSet(3)), 3))
}
