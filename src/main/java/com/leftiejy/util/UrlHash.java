package com.leftiejy.util;

public class UrlHash {
    public static final String BASE_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int MAX_HASH_LENGTH = 3;
    public static String encode(String url) {
        byte[] bytes = url.getBytes();
        byte[] result = getString(bytes);

        StringBuffer sb = new StringBuffer();
        sb.append(BASE_CHARSET.charAt(result[2]));
        sb.append(BASE_CHARSET.charAt(result[1]));
        sb.append(BASE_CHARSET.charAt(result[0]));

        return sb.toString();
    }

    private static byte[] getString(byte[] bytes) {
        int i = 0;

        byte[] result = new byte[MAX_HASH_LENGTH];
        while(true) {
            for(int j=0; j < MAX_HASH_LENGTH; j++) {
                if (i >= bytes.length) {
                    return result;
                } else {
                    result[j] = (byte) ((result[j] ^ bytes[i++]) % 62);
                }
            }
        }
    }
}
