package org.kata

import org.scalatest._

class ArabicNumeralSpec extends FlatSpec with Matchers {

  "An arabic numeral" should "equal integer with the same value" in {
    ArabicNumeral(1) should be (1)
  }

  "An arabic numeral" should "not equal integer with a different value" in {
    ArabicNumeral(1) should not be 2
  }

  "An arabic numeral" should "equal another arabic numeral with the same value" in {
    ArabicNumeral(1) should be (ArabicNumeral(1))
  }

  "An arabic numeral" should "not equal another arabic numeral with a different value" in {
    ArabicNumeral(1) should not be ArabicNumeral(2)
  }

  "An arabic numeral" should "add own value to another arabic numeral value" in {
    ArabicNumeral(1) + ArabicNumeral(2) should be (3)
  }

  "An arabic numeral" should "subtract another arabic numeral value from own value" in {
    ArabicNumeral(2) - ArabicNumeral(1) should be (ArabicNumeral(1))
  }

  "An arabic numeral" should "tell if it's smaller from another arabic numeral" in {
    val smaller = true
    ArabicNumeral(1) < ArabicNumeral(2) should be (smaller)
  }

  "An arabic numeral" should "tell if it's bigger from another arabic numeral" in {
    val bigger = false
    ArabicNumeral(2) < ArabicNumeral(1) should be (bigger)
  }
}
