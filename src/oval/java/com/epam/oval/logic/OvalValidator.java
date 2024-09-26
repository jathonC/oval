package com.epam.oval.logic;

import java.util.regex.Pattern;

public class OvalValidator {
    private final static String OVAL_LINE_REGEX = "([+-]?([0-9]*[.])?[0-9]+) [+-]?([0-9]*[.])?[0-9]+ [+-]?([0-9]*[.])?[0-9]+ [+-]?([0-9]*[.])?[0-9]+";

    public boolean isValidLine(String line){
        return Pattern.matches(OVAL_LINE_REGEX,line);
    }
}
