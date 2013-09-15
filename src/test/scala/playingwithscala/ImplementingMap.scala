package playingwithscala


class ImplementingMap {

}

case class MyClass[Option](opt: Option) {

  def map[B](f: Option => B): MyClass[B] = {
    MyClass(f(opt))
  }

  def flatMap[B](f: Option => MyClass[B]): MyClass[B] = {
    f(opt)
  }
}

class Test {
  val x = MyClass(Some(2))
  val y = List(MyClass(Some(1)))

  def test = {
    println("***** " + x.map(v => v))
//    println(y.flatMap(_))
  }
}