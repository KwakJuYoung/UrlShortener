package com.leftiejy.util;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
public class Base62 {
    public static final String BASE_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = BASE_CHARSET.length();
    public static final int MAX_KEY_SIZE = 8;
    public static final long MAX_ID_SIZE = (long) Math.pow(BASE, MAX_KEY_SIZE) - 1;
    public static String encode(long id) {
        long currentValue = id;
        StringBuffer stringBuffer = new StringBuffer();
        while(true) {
            int baseIndex = (int) (currentValue % BASE);
            stringBuffer.append(BASE_CHARSET.charAt(baseIndex));
            currentValue = currentValue / BASE;
            if (currentValue == 0) {
                break;
            }
        }
        return stringBuffer.reverse().toString();
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
