package org.kata;

import java.util.HashMap;
import java.util.Map;

class RomanToArabicMapping {

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

    static Integer decodeArabic(String value) {
        return mappings.get(value);
    }
}
