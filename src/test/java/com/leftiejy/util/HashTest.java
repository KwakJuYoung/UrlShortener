package com.leftiejy.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
public class HashTest {
    //encode
    @Test
    public void test1() {
        String url = "a";
        assertEquals("00z", UrlHash.encode(url));
    }
    @Test
    public void test2() {
        String url = "aa";
        assertEquals("0zz", UrlHash.encode(url));
    }
    @Test
    public void test3() {
        String url = "aaa";
        assertEquals("zzz", UrlHash.encode(url));
    }

    @Test
       public void test4() {
        String url = "aaaa";
        assertEquals("zz4", UrlHash.encode(url));
    }

    @Test
    public void test5() {
        String url = "https://www.google.co.kr/search?source=hp&ei=9ut1Wt_OMMTO0gT4mryQDA&q=Stringbuffer&oq=Stringbuffer&gs_l=psy-ab.3..35i39k1j0l3j0i20i263k1j0l5.1233.3484.0.3684.13.12.0.0.0.0.287.1603.2j2j5.9.0....0...1c.1.64.psy-ab..4.9.1603.0..0i67k1j0i10k1j0i131k1.0.Tqfhcc6XbpU";
        assertEquals(3, UrlHash.encode(url).length());
        assertEquals("zl4", UrlHash.encode(url));
    }
}
