package org.kata

case class RomanNumeral(private val romanNumeral: String) {

  def toArabic: ArabicNumeral = {
    reduce(romanNumeral.toList, ArabicNumeral(0))
  }

  private def reduce(romanNumerals: List[Char], result: ArabicNumeral): ArabicNumeral = romanNumerals match {
    case first :: second :: rest if arabicOf(first) < arabicOf(second) =>
      reduce(second :: rest, result - arabicOf(first))
    case single :: Nil =>
      result + arabicOf(single)
    case first :: rest =>
      reduce(rest, result + arabicOf(first))
  }

  private def arabicOf(value: Char) = value match {
    case 'I' => ArabicNumeral(1)
    case 'V' => ArabicNumeral(5)
    case 'X' => ArabicNumeral(10)
    case 'L' => ArabicNumeral(50)
    case 'C' => ArabicNumeral(100)
    case 'D' => ArabicNumeral(500)
    case 'M' => ArabicNumeral(1000)
  }
}