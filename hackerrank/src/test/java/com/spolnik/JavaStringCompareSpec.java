package com.spolnik;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaStringCompareSpec {

    @Test
    public void initial_spec() throws Exception {
        FindMaxAndMinInWord findMaxAndMinInWord = new FindMaxAndMinInWord();

        Tuple<String, String> result = findMaxAndMinInWord.apply("welcometojava", 3);

        assertThat(result.first()).isEqualTo("ava");
        assertThat(result.second()).isEqualTo("wel");
    }
}
