package playingwithscala




trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}



class TypeClass {

  implicit val x = new Functor[Option] {
  def map[A, B](fa: Option[A])(f: A => B): Option[B] =
  fa match {
        case Some(a) => Some(f(a))
        case None => None
      }
  }
}






