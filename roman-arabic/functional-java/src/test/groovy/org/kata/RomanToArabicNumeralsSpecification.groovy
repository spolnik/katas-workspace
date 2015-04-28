package org.kata

import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Function

import static org.kata.RomanNumber.romanNumberOf

@Unroll
class RomanToArabicNumeralsSpecification extends Specification {

    def "The arabic conversion of #value is #arabic"() {
        expect:
        romanNumberOf(value).to(arabic()) == arabic

        where:
        value   ||   arabic
        "I"     ||   1
        "V"     ||   5
        "X"     ||   10
        "L"     ||   50
        "C"     ||   100
        "D"     ||   500
        "M"     ||   1000
    }

    def "The arabic conversion of multi letter #value is #arabic"() {
        expect:
        romanNumberOf(value).to(arabic()) == arabic

        where:
        value           ||  arabic
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

    static Function<RomanNumber, ArabicNumber> arabic() {
        new RomanToArabicConverter()
    }
}
