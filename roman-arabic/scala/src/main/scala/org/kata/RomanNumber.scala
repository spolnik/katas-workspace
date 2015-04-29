package org.kata

class RomanNumber(input: String) {
  val numeral = input

  def tail = this.numeral.tail

  def head = this.numeral.head

  def to[T](convert: Function[RomanNumber, T]): T = {
    convert.apply(this)
  }
}
