package org.kata

import org.scalatest._

class ArabicNumberSpec extends FlatSpec with Matchers {

  "An arabic number" should "equal integer with the same value" in {
    ArabicNumber(1) should be (1)
  }

  "An arabic number" should "not equal integer with a different value" in {
    ArabicNumber(1) should not be 2
  }

  "An arabic number" should "equal another arabic number with the same value" in {
    ArabicNumber(1) should be (ArabicNumber(1))
  }

  "An arabic number" should "not equal another arabic number with a different value" in {
    ArabicNumber(1) should not be ArabicNumber(2)
  }

  "An arabic number" should "add own value to another arabic number value" in {
    ArabicNumber(1) + ArabicNumber(2) should be (3)
  }

  "An arabic number" should "subtract another arabic number value from own value" in {
    ArabicNumber(2) - ArabicNumber(1) should be (ArabicNumber(1))
  }

  "An arabic number" should "tell if it's smaller from another arabic number" in {
    val smaller = true
    ArabicNumber(1) < ArabicNumber(2) should be (smaller)
  }

  "An arabic number" should "tell if it's bigger from another arabic number" in {
    val bigger = false
    ArabicNumber(2) < ArabicNumber(1) should be (bigger)
  }
}
