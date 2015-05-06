package org.kata

import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class RomanNumeralSpecification extends Specification {

    def "The arabic conversion of single numeral #value is #arabic"() {
        expect:
        romanNumeralOf(value).toArabic() == arabic

        where:
        value || arabic
        "I"   || 1
        "V"   || 5
        "X"   || 10
        "L"   || 50
        "C"   || 100
        "D"   || 500
        "M"   || 1000
    }

    def "The arabic conversion of additive multiple numerals #value is #arabic"() {
        expect:
        romanNumeralOf(value).toArabic() == arabic

        where:
        value         || arabic
        "VI"          || 6
        "III"         || 3
    }

    def "The arabic conversion of reductive multiple numerals #value is #arabic"() {
        expect:
        romanNumeralOf(value).toArabic() == arabic

        where:
        value         || arabic
        "IV"          || 4
        "XCIV"        || 94
        "MCMLIV"      || 1954
        "MCMXC"       || 1990
        "MMXIV"       || 2014
        "MMMDCCCXLIV" || 3844
    }

    @FailsWith(IllegalArgumentException)
    def "An incorrect roman numeral #value throws exception IllegalArgumentException"() {
        expect:
        romanNumeralOf(value).toArabic()

        where:
        value << [
                "IIII",
                "DD",
                "LL",
                "VV",
                "IIV",
                "IXIX",
                "XXXXXX",
                ""]
    }

    def romanNumeralOf(String value) {
        new RomanNumeral(value)
    }
}
