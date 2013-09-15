package playingwithscala

import org.joda.time.LocalDate


case class Dates(d1: LocalDate, d2: LocalDate)

trait DaysCount[T, R] {
  def counting(t: T): R
}

object DaysCount {
  implicit object DatesDaysCount extends DaysCount[Dates, Int] {
    var days = 0
    def counting(t: Dates): Int =
      if(!t.d1.equals(t.d2)) {
        days = days + 1
        counting(Dates(t.d1.plusDays(1), t.d2))
      } else
        days
  }
}


trait Count {
  def counting[T, R](t: T)(implicit daysCount: DaysCount[T, R]): R = daysCount.counting(t)
}


object ExampleWithDefaults extends App with Count {
  println(counting(Dates(new LocalDate(2013, 9, 1), new LocalDate(2013, 9, 15))))
}
