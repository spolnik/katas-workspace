package org.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kata.RomeNumber.romeNumberOf;

@RunWith(JUnitParamsRunner.class)
public class ConvertRomeToArabicNumbersSpec {

    @Test
    @Parameters({
            "I, 1",
            "V, 5",
            "X, 10",
            "L, 50",
            "C, 100",
            "D, 500",
            "M, 1000"})
    public void converts_simple_case(String roman, int arabic) throws Exception {

        ArabicNumber arabicNumber = romeNumberOf(roman).toArabic();

        assertThat(arabicNumber.value()).isEqualTo(arabic);
    }
}
