package org.kata

class ConvertRomanToArabic extends Function[RomanNumber, ArabicNumber] {

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

  private def reduce(previous: Int, tail: String, acc: Int): Int = tail match {
    case "" =>
      acc + previous
    case _ =>
      reduceNextNumeral(previous, tail, acc)
  }

  private def reduceNextNumeral(previous: Int, tail: String, acc: Int): Int = {
    val current = decodeArabic(tail.head)

    def reduceMultiLetterRomanNumeral = {
      reduce(0, tail.tail, acc + (current - previous))
    }

    def reduceAsPartialElementOfMultiLetterRomanNumeral = {
      reduce(previous + current, tail.tail, acc)
    }

    def reduceRomanNumeral = {
      reduce(current, tail.tail, acc + previous)
    }

    current match {
      case x: Int if isPartOfSubtract(previous, x) =>
        reduceMultiLetterRomanNumeral
      case y: Int if previous == y =>
        reduceAsPartialElementOfMultiLetterRomanNumeral
      case _ =>
        reduceRomanNumeral
    }
  }

  private def isPartOfSubtract(previous: Int, current: Int) = {
    previous < current && previous > 0
  }

  private def decodeArabic(value: Char) = value match {
    case 'I' => 1
    case 'V' => 5
    case 'X' => 10
    case 'L' => 50
    case 'C' => 100
    case 'D' => 500
    case 'M' => 1000
  }
}
