package com.leftiejy.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTest {
    //encode
    @Test
    public void encode_empty_url() {
        String url = "";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("000", encode);
    }

    @Test
    public void encode_one_length_url() {
        String url = "a";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("00z", encode);
    }
    @Test
    public void encode_two_length_url() {
        String url = "aa";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("0zz", encode);
    }
    @Test
    public void encode_three_length_url() {
        String url = "aaa";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("zzz", encode);
    }

    @Test
       public void encode_four_length_url() {
        String url = "aaaa";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("zz4", encode);
    }

    @Test
    public void test5() {
        String url = "https://www.google.co.kr/search?source=hp&ei=9ut1Wt_OMMTO0gT4mryQDA&q=Stringbuffer&oq=Stringbuffer&gs_l=psy-ab.3..35i39k1j0l3j0i20i263k1j0l5.1233.3484.0.3684.13.12.0.0.0.0.287.1603.2j2j5.9.0....0...1c.1.64.psy-ab..4.9.1603.0..0i67k1j0i10k1j0i131k1.0.Tqfhcc6XbpU";
        String encode = UrlHash.encode(url);
        assertEquals(3, encode.length());
        assertEquals("zl4", encode);
    }
}
