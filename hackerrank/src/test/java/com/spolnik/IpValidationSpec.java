package com.spolnik;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class IpValidationSpec {

    @Test
    @Parameters({
            "000.12.12.034",
            "121.234.12.12",
            "23.45.12.56",
            "0.0.0.0",
            "255.255.255.255",
            "000.00.0.001"
    })
    public void returns_true_for_valid_ip_address(String ipAddress) throws Exception {
        IpValidator ipValidator = new IpValidator();

        assertThat(ipValidator.isValid(ipAddress)).isTrue();
    }

    @Test
    @Parameters({
            "000.12.234.23.23",
            "666.666.23.23",
            ".213.123.23.32",
            "23.45.22.32.",
            "I.Am.not.an.ip"
    })
    public void returns_false_for_valid_ip_address(String ipAddress) throws Exception {
        IpValidator ipValidator = new IpValidator();

        assertThat(ipValidator.isValid(ipAddress)).isFalse();
    }
}
