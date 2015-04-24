package org.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kata.RomeNumber.romeNumberOf;

public class ConvertRomeToArabicNumbersSpec {

    @Test
    public void converts_simple_case() throws Exception {
        ArabicNumber result = romeNumberOf("I").toArabic();

        assertThat(result).isEqualTo(1);
    }
}
