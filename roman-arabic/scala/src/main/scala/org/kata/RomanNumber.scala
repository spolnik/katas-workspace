package org.kata

import org.kata.RomanNumber.arabicNumberOf

class RomanNumber(private val romanNumeral: String) {

  def toArabic: ArabicNumber = {

    val arabicNumber = reduce(
      arabicNumberOf(romanNumeral.head),
      romanNumeral.tail,
      0
    )
    new ArabicNumber(
      arabicNumber
    )
  }

  private def reduce(previous: Int, tail: String, acc: Int): Int = tail match {
    case "" =>
      acc + previous
    case _ =>
      reduceNextNumeral(previous, tail, acc)
  }

  private def reduceNextNumeral(previous: Int, tail: String, acc: Int): Int = {
    val current = arabicNumberOf(tail.head)

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
}

object RomanNumber {
  def romanNumberOf(value: String) = new RomanNumber(value)

  def arabicNumberOf(value: Char) = value match {
    case 'I' => 1
    case 'V' => 5
    case 'X' => 10
    case 'L' => 50
    case 'C' => 100
    case 'D' => 500
    case 'M' => 1000
  }
}

