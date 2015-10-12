package com.spolnik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {

    private static final Pattern ipPattern = Pattern.compile("(((25[0-5])|(2[0-4]\\d)|([0-1]?\\d\\d)|(\\d\\d)|(\\d))(\\.)){3}((25[0-5])|(2[0-4]\\d)|([0-1]?\\d\\d)|(\\d\\d)|(\\d))");

    public boolean isValid(String ipAddress) {

        Matcher matcher = ipPattern.matcher(ipAddress);
        return matcher.matches();
    }
}
