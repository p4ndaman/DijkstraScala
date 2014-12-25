package main.scala.utility.extractors

/**
 * Created by mayur.pandya on 12/24/14.
 */
object Int {
  def unapply(s : String) : Option[Int] = try {
    Some(s.toInt)
  } catch {
    case _ : java.lang.NumberFormatException => None
  }
}
