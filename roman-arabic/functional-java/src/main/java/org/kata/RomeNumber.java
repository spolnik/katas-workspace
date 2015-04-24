package org.kata;

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
        return arabicNumberOf(1);
    }
}
