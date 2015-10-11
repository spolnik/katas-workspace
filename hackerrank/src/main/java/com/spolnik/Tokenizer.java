package com.spolnik;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {

    public List<String> process(String input) {
        return Arrays
                .asList(input.split("[ !,?.\\_'@]"))
                .stream()
                .filter(Tokenizer::isNotNullNorEmpty)
                .collect(Collectors.toList());
    }

    private static boolean isNotNullNorEmpty(String input) {
        return input != null && !input.trim().equals("");
    }
}
