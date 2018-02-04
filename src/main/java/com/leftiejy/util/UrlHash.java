package com.leftiejy.util;

/**
 * Created by leftiejy on 2018. 2. 4..
 */
public class UrlHash {
    public static final String BASE_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int MAX_HASH_LENGTH = 3;
    public static String encode(String url) {
        if (url == null || url.length() == 0) {
            return url;
        }

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
                result[j] = (byte) ((result[j] ^ bytes[i++]) % 62);
                if (i >= bytes.length) {
                    return result;
                }
            }
        }
    }
}
