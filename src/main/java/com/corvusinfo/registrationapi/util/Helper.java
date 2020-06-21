package com.corvusinfo.registrationapi.util;

import com.corvusinfo.registrationapi.model.Account;

import java.util.List;
import java.util.Random;

public class Helper {

    public static String generatePassword() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 8;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
