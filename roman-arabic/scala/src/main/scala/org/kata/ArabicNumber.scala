package org.kata

class ArabicNumber(private val value: Int) {

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[ArabicNumber] || other.isInstanceOf[Integer]

  override def equals(other: Any): Boolean = other match {
    case that: ArabicNumber =>
      (this canEqual that) &&
        value == that.value
    case that: Integer =>
      (this canEqual that) &&
        value == that
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(value)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
