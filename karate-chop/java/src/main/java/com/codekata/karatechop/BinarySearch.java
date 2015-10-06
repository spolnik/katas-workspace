package com.codekata.karatechop;

public class BinarySearch {

    public static final int NOT_FOUND = -1;

    public int chop(int numberToFind, int[] inputNumbers) {

        for (int i = 0; i < inputNumbers.length; i++) {

            if (numberToFind == inputNumbers[i]) {
                return i;
            }
        }

        return NOT_FOUND;
    }
}
