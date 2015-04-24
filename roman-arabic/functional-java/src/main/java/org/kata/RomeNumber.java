package org.kata;

import java.util.HashMap;
import java.util.Map;

import static org.kata.ArabicNumber.arabicNumberOf;

public final class RomeNumber {

    private final String value;

    private RomeNumber(String value) {
        this.value = value;
    }

    public static RomeNumber romeNumberOf(String value) {
        return new RomeNumber(value);
    }

    public String value() {
        return value;
    }

    public ArabicNumber toArabic() {

        return arabicNumberOf(
                new RomeToArabicNumbersConverter().convert(value())
        );
    }

    static final class RomeToArabicNumbersConverter {

        private final Map<String, Integer> mappings = new HashMap<>();

        public RomeToArabicNumbersConverter() {
            mappings.put("I", 1);
            mappings.put("V", 5);
            mappings.put("X", 10);
            mappings.put("L", 50);
            mappings.put("C", 100);
            mappings.put("D", 500);
            mappings.put("M", 1000);
        }

        public int convert(final String value) {

            int arabicNumber = 0;
            int previous = decodeArabic(value, 0);

            for (int i = 1; i < value.length(); i++) {
                Integer current = decodeArabic(value, i);

                if (previous < current && previous > 0) {
                    arabicNumber += (current - previous);
                    previous = 0;
                } else {
                    previous += current;
                }
            }

            return arabicNumber + previous;
        }

        private Integer decodeArabic(String value, int index) {
            return mappings.get(
                    String.valueOf(
                            value.charAt(index)
                    )
            );
        }
    }
}
