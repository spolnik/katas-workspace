package org.kata

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class RomanNumeralSpec extends FlatSpec with Matchers {

  val scenarios =
    Table(
      ("roman",       "arabic"),
      ("I",           1),
      ("V",           5),
      ("X",           10),
      ("L",           50),
      ("C",           100),
      ("D",           500),
      ("M",           1000),
      ("IV",          4),
      ("VI",          6),
      ("III",         3),
      ("XCIV",        94),
      ("MCMLIV",      1954),
      ("MCMXC",       1990),
      ("MMXIV",       2014),
      ("XXXXXX",      60),
      ("MMMDCCCXLIV", 3844)
    )

  "A roman numeral" should "be easily converted to right arabic numeral" in {

    forAll (scenarios) { (romanValue, arabic) =>
      RomanNumeral(romanValue).toArabic should be (arabic)
    }
  }
}
