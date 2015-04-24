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


        public int convert(String value) {
            return mappings.get(value);
        }
    }
}
