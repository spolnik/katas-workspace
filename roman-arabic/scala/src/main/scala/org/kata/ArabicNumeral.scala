package org.kata

case class ArabicNumeral(private val value: Int) {

  def +(arabic: ArabicNumeral) =
    ArabicNumeral(value + arabic.value)

  def -(arabic: ArabicNumeral) =
    ArabicNumeral(value - arabic.value)

  def <(arabic: ArabicNumeral) =
    value < arabic.value

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[ArabicNumeral] || other.isInstanceOf[Integer]

  override def equals(other: Any): Boolean = other match {
    case that: ArabicNumeral =>
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
