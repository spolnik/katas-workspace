package org.kata.object;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kata.object.RomanNumber.romeNumberOf;

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
            "M, 1000",
            "IV, 4",
            "VI, 6",
            "III, 3",
            "XCIV, 94",
            "MCMLIV, 1954",
            "MCMXC, 1990",
            "MMXIV, 2014",
            "XXXXXX, 60",
            "MMMDCCCXLIV, 3844"
    })
    public void converts_rome_to_arabic_number(String roman, int arabic) throws Exception {

        ArabicNumber arabicNumber = romeNumberOf(roman).toArabic();

        assertThat(arabicNumber.value()).isEqualTo(arabic);
    }
}
