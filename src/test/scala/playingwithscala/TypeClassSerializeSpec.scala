package playingwithscala

import org.specs2.mutable.SpecificationWithJUnit


case class MyObj(objName: String)

trait Serializable[T] {
  def serialize(obj: T): String
}

object Serializable {
  implicit object MyObjToSerialize extends Serializable[MyObj] { def serialize(myObj: MyObj) = "MyObj " + myObj.objName }
//  implicit def ser[T](t: T)(implicit obj: Serializable[List[MyObj]]) = new Serializable[MyObj] {
//    def serialize(s: List[T]) = s.map(obj.serialize(_))
//  }
}

trait UseType {
  def serialize[T](t: T)(implicit useType: Serializable[T]) = useType.serialize(t)
}

class TypeClassSerializeSpec extends SpecificationWithJUnit with UseType {

  "My test" should {
    "use the implicit method" in {
      println(" test ******************* " + serialize(MyObj("im using a type")))
//      println(" test def ser " + serialize(List(MyObj("im a type 2"))))

      true
    }
  }
}
