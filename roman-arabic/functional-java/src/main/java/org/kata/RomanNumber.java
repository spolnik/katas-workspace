package org.kata;

import java.util.function.Function;

public final class RomanNumber {

    private final String value;

    private RomanNumber(String value) {
        this.value = value;
    }

    public static RomanNumber romanNumberOf(String value) {
        return new RomanNumber(value);
    }

    public String value() {
        return value;
    }

    public <T> T to(Function<RomanNumber, T> converter) {
        return converter.apply(this);
    }
}
