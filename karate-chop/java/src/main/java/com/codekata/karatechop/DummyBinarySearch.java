package com.codekata.karatechop;

public final class DummyBinarySearch implements BinarySearch {

    @Override
    public int chop(int numberToFind, int[] inputNumbers) {

        for (int i = 0; i < inputNumbers.length; i++) {

            if (numberToFind == inputNumbers[i]) {
                return i;
            }
        }

        return NOT_FOUND;
    }
}
