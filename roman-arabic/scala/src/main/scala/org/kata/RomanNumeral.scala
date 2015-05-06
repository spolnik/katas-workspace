package org.kata

case class RomanNumeral(private val romanNumeral: String) {


  def toArabic: ArabicNumeral = {

    checkIfValid(romanNumeral)

    reduce(
      romanNumeral.toList
        .map(toArabicNumeral),
      result = ArabicNumeral(0)
    )
  }

  private val correctRomanNumeralPattern = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$".r

  private def checkIfValid(romanNumeral: String) =  romanNumeral match {
    case null | "" => throw new IllegalArgumentException("Roman numeral cannot be null nor empty")
    case correctRomanNumeralPattern(a,b,c) => true
    case _ => throw new IllegalArgumentException("Invalid roman numeral: " + romanNumeral)
  }

  private def reduce(romanNumerals: List[ArabicNumeral], result: ArabicNumeral): ArabicNumeral = romanNumerals match {
    case first :: second :: rest if first < second =>
      reduce(second :: rest, result - first)
    case single :: Nil =>
      result + single
    case first :: rest =>
      reduce(rest, result + first)
  }

  private def toArabicNumeral(value: Char) = value match {
    case 'I' => ArabicNumeral(1)
    case 'V' => ArabicNumeral(5)
    case 'X' => ArabicNumeral(10)
    case 'L' => ArabicNumeral(50)
    case 'C' => ArabicNumeral(100)
    case 'D' => ArabicNumeral(500)
    case 'M' => ArabicNumeral(1000)
  }
}