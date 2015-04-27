package org.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.kata.ArabicNumber.arabicNumberOf;

public final class RomanNumber {

    private final String value;

    private RomanNumber(String value) {
        this.value = value;
    }

    public static RomanNumber romeNumberOf(String value) {
        return new RomanNumber(value);
    }

    public String value() {
        return value;
    }

    public ArabicNumber toArabic() {

        return arabicNumberOf(
                new RomeToArabicNumbersConverter().convertRomeToArabic(value())
        );
    }

    static final class RomeToArabicNumbersConverter {

        private static final Map<String, Integer> mappings = new HashMap<>();

        static {
            mappings.put("I", 1);
            mappings.put("V", 5);
            mappings.put("X", 10);
            mappings.put("L", 50);
            mappings.put("C", 100);
            mappings.put("D", 500);
            mappings.put("M", 1000);
        }

        public int convertRomeToArabic(final String value) {

            int arabicNumber = 0;
            int previous = decodeArabic(value, 0);

            for (int i = 1; i < value.length(); i++) {
                Integer current = decodeArabic(value, i);

                if (isPartOfSubtract(previous, current)) {
                    arabicNumber += (current - previous);
                    previous = 0;
                } else if (previous == current) {
                    previous += current;
                } else {
                    arabicNumber += previous;
                    previous = current;
                }
            }

            return arabicNumber + previous;
        }

        private boolean isPartOfSubtract(int previous, Integer current) {
            return previous < current && previous > 0;
        }

        private Integer decodeArabic(String value, int index) {
            return mappings.get(
                    stringOf(value, index)
            );
        }

        private String stringOf(String value, int index) {
            return String.valueOf(
                    value.charAt(index)
            );
        }
    }
}
