package com.spolnik;

import java.util.SortedSet;
import java.util.TreeSet;

public class FindMaxAndMinInWord {
    public Tuple<String, String> apply(String input, int k) {

        SortedSet<String> items = processInput(input, k);
        return new Tuple<>(items.first(), items.last());
    }

    private SortedSet<String> processInput(String input, int k) {
        SortedSet<String> items = new TreeSet<>();

        for (int i = 0; i <= input.length() - k; i++) {
            String currentWord = input.substring(i, i + k);
            items.add(currentWord);
        }

        return items;
    }
}
