package org.kata;

public final class ArabicNumber {

    private final int value;

    private ArabicNumber(int value) {
        this.value = value;
    }

    public static ArabicNumber arabicNumberOf(int value) {
        return new ArabicNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null) {
            return false;
        }

        if (ArabicNumber.class == o.getClass()) {
            return value == ((ArabicNumber) o).value;
        }

        return Integer.class == o.getClass()
                && value == (Integer) o;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
