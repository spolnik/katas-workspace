package com.spolnik;

public final class Tuple<TFirst, TSecond> {

    private final TFirst first;
    private final TSecond second;

    public Tuple(TFirst first, TSecond second) {
        this.first = first;
        this.second = second;
    }

    public TFirst first() {
        return first;
    }

    public TSecond second() {
        return second;
    }
}
