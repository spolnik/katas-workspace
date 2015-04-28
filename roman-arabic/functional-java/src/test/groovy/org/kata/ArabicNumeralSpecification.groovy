package org.kata

import spock.lang.Specification
import spock.lang.Unroll

import static org.kata.ArabicNumber.arabicNumberOf

@Unroll
class ArabicNumeralSpecification extends Specification {

    def "The arabic number is equal to integer with same value"() {
        expect:
        arabicNumberOf(1) == 1
    }

    def "The arabic number does not equal to integer with different value"() {
        expect:
        arabicNumberOf(1) != 2
    }

    def "The arabic number is equal to another arabic with same value"() {
        expect:
        arabicNumberOf(1) == arabicNumberOf(1)
    }

    def "The arabic number does not equal to arabic with different value"() {
        expect:
        arabicNumberOf(1) != arabicNumberOf(2)
    }
}
