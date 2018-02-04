package com.leftiejy.util;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
public class Base62 {
    public static final String BASE_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = BASE_CHARSET.length();
    public static final int MAX_KEY_LENGTH = 5;
    public static final long MAX_ID_SIZE = (long) Math.pow(BASE, MAX_KEY_LENGTH) - 1;

    public static String encode(long id) {
        long currentValue = id;
        byte[] bytes = new byte[MAX_KEY_LENGTH];
        int byteIndex = 0;
        while(true) {
            bytes[byteIndex] = (byte) (currentValue % BASE);
            currentValue = currentValue / BASE;
            byteIndex++;
            if (currentValue == 0) {
                break;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = byteIndex - 1; i >= 0; i--) {
            stringBuffer.append(BASE_CHARSET.charAt(bytes[i]));
        }
        return stringBuffer.toString();
    }


    public static long decode(String key) {
        long decodedValue = 0;
        int digitIdx = key.length() - 1;
        for (int exponent = 0; exponent < key.length(); exponent++) {
            char ch = key.charAt(digitIdx);
            decodedValue += ((BASE_CHARSET.indexOf(ch)) * Math.pow(BASE, exponent));
            digitIdx--;
        }
        return decodedValue;
    }
}
