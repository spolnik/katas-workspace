package org.kata.object;

public final class ArabicNumber {

    private final int value;

    private ArabicNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ArabicNumber arabicNumberOf(int value) {
        return new ArabicNumber(value);
    }
}
