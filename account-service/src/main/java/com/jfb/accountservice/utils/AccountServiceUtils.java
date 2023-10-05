package com.jfb.accountservice.utils;

import java.util.UUID;

public class AccountServiceUtils {

    public static String createAccountNumber() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
