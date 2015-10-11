package com.spolnik;

import java.util.Arrays;

public class AnagramChecker {
    public boolean isAnagram(String A, String B) {
        A = A.toLowerCase();
        B = B.toLowerCase();

        String sortedA = sort(A);
        String sortedB = sort(B);

        return sortedA.equals(sortedB);
    }

    private String sort(String input) {
        char[] array = input.toCharArray();
        Arrays.sort(array);

        return Arrays.toString(array);
    }
}
