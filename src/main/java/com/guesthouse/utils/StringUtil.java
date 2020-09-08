package com.guesthouse.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    public String capitalizeWord(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
