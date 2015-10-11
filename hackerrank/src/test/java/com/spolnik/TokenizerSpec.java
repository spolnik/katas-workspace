package com.spolnik;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerSpec {

    @Test
    public void tokenize_simple_sentence() throws Exception {
        Tokenizer tokenizer = new Tokenizer();

        List<String> tokens = tokenizer.process("He is a very very good boy, isn't he?");

        assertThat(tokens).hasSize(10);
    }
}
