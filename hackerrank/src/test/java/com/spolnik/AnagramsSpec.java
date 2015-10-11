package com.spolnik;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsSpec {

    @Test
    public void is_anagram() throws Exception {
        AnagramChecker anagramChecker = new AnagramChecker();

        boolean result = anagramChecker.isAnagram("anagram", "margana");

        assertThat(result).isTrue();
    }

    @Test
    public void is_not_anagram() throws Exception {
        AnagramChecker anagramChecker = new AnagramChecker();

        boolean result = anagramChecker.isAnagram("anagram", "marganaz");

        assertThat(result).isFalse();
    }
}
