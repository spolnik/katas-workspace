package org.kata

case class RomanNumber(private val romanNumeral: String) {

  def toArabic: ArabicNumber = {
    reduce(romanNumeral.toList, ArabicNumber(0))
  }

  private def reduce(romanNumerals: List[Char], arabicNumber: ArabicNumber): ArabicNumber = romanNumerals match {
    case first :: second :: rest if arabicNumberOf(first) < arabicNumberOf(second) =>
      reduce(second :: rest, arabicNumber - arabicNumberOf(first))
    case single :: Nil =>
      arabicNumber + arabicNumberOf(single)
    case first :: rest =>
      reduce(rest, arabicNumber + arabicNumberOf(first))
  }

  private def arabicNumberOf(value: Char) = value match {
    case 'I' => ArabicNumber(1)
    case 'V' => ArabicNumber(5)
    case 'X' => ArabicNumber(10)
    case 'L' => ArabicNumber(50)
    case 'C' => ArabicNumber(100)
    case 'D' => ArabicNumber(500)
    case 'M' => ArabicNumber(1000)
  }
}