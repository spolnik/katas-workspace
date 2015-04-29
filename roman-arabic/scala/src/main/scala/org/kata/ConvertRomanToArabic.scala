package org.kata

import org.kata.RomanToArabicMapping.decodeArabic

class ConvertRomanToArabic extends Function[RomanNumber,ArabicNumber] {

  override def apply(romanNumber: RomanNumber): ArabicNumber = {

    new ArabicNumber(
      convertRomanToArabic(romanNumber)
    )
  }

  private def convertRomanToArabic(value: RomanNumber): Int = {
    reduce(
      decodeArabic(value.head),
      value.tail,
      0
    )
  }

  private def reduce(previous: Int, tail: String, acc: Integer): Int = {
    if (tail.isEmpty) {
      return acc + previous
    }

    val current: Int = decodeArabic(tail.head)

    if (isPartOfSubtract(previous, current)) {
      return reduce(0, tail.tail, acc + (current - previous))
    }

    if (previous == current) {
      return reduce(previous + current, tail.tail, acc)
    }

    reduce(current, tail.tail, acc + previous)
  }

  private def isPartOfSubtract(previous: Int, current: Int) =
    previous < current && previous > 0

}
