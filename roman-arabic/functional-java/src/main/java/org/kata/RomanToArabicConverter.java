package org.kata;

import java.util.function.Function;

import static org.kata.ArabicNumber.arabicNumberOf;

public class RomanToArabicConverter implements Function<RomanNumber, ArabicNumber> {

    @Override
    public ArabicNumber apply(RomanNumber romanNumber) {

        String value = romanNumber.value();

        return arabicNumberOf(
                convertRomeToArabic(value)
        );
    }

    public int convertRomeToArabic(final String value) {

        return reduce(
                RomanToArabicMapping.decodeArabic(head(value)),
                tail(value),
                0
        );
    }

    private String tail(String value) {
        if (value.isEmpty() || value.length() == 1)
            return "";

        return value.substring(1, value.length());
    }

    private String head(String value) {
        return value.substring(0, 1);
    }

    private int reduce(Integer previous, String tail, Integer acc) {

        if (tail.isEmpty()) {
            return acc + previous;
        }

        Integer current = RomanToArabicMapping.decodeArabic(head(tail));

        if (isPartOfSubtract(previous, current)) {
            return reduce(0, tail(tail), acc + (current - previous));
        }

        if (previous.equals(current)) {
            return reduce(previous + current, tail(tail), acc);
        }

        return reduce(current, tail(tail), acc + previous);
    }

    private boolean isPartOfSubtract(int previous, Integer current) {
        return previous < current && previous > 0;
    }

}
