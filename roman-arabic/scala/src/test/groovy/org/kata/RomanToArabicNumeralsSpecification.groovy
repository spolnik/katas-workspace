package org.kata

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class RomanToArabicNumeralsSpecification extends Specification {

    def "The arabic conversion of #value is #result"() {
        expect:
        new RomanNumber(value).to(arabic()) == result

        where:
        value   ||   result
        "I"     ||   1
        "V"     ||   5
        "X"     ||   10
        "L"     ||   50
        "C"     ||   100
        "D"     ||   500
        "M"     ||   1000
    }

    def "The arabic conversion of multi letter #value is #result"() {
        expect:
        new RomanNumber(value).to(arabic()) == result

        where:
        value           ||  result
        "IV"            ||  4
        "VI"            ||  6
        "III"           ||  3
        "XCIV"          ||  94
        "MCMLIV"        ||  1954
        "MCMXC"         ||  1990
        "MMXIV"         ||  2014
        "XXXXXX"        ||  60
        "MMMDCCCXLIV"   ||  3844
    }

    def arabic() {
        new ConvertRomanToArabic()
    }
}
