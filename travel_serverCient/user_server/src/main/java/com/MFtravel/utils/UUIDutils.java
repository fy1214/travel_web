package com.MFtravel.utils;

import java.util.UUID;

public class UUIDutils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
