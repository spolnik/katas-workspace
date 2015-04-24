package org.kata;

public final class ArabicNumber {

    private final int value;

    public ArabicNumber(int value) {

        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ArabicNumber arabicNumberOf(int value) {
        return new ArabicNumber(value);
    }
}
