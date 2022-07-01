package com.MFtravel.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFromPass(String inputPass){
        String str = String.valueOf(salt.charAt(2)) + String.valueOf(salt.charAt(0)) + inputPass + String.valueOf(salt.charAt(5)) + String.valueOf(salt.charAt(6));
        return md5(str);
    }

    public static String fromPassToDBPass(String fromPass, String salt){
        String str = String.valueOf(salt.charAt(2)) + String.valueOf(salt.charAt(0)) + fromPass + String.valueOf(salt.charAt(5)) + String.valueOf(salt.charAt(6));
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt){
        String fromPass = inputPassToFromPass(inputPass);
        return fromPassToDBPass(fromPass, salt);
    }

    public static void main(String[] args) {
        String s = inputPassToDBPass("1234", "1a2b3c4d");
        System.out.println(s);
    }
}
