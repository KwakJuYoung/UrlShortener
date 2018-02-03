package com.leftiejy.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
public class Base62Test {
    //encode
    @Test
    public void encoding_0_return_a_and_decoding() {
        long id = 0;
        String encodedValue = Base62.encode(id);
        assertEquals("0", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_1_return_1_and_decoding() {
        long id = 1;
        String encodedValue = Base62.encode(id);
        assertEquals("1", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_61_return_Z_and_decoding() {
        long id = 61;
        String encodedValue = Base62.encode(id);
        assertEquals("Z", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_62_return_01_and_decoding() {
        long id = 62;
        String encodedValue = Base62.encode(id);
        assertEquals("10", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_Long_MAX() {
        long id = Long.MAX_VALUE;
        String encodedValue = Base62.encode(id);
        assertEquals("aZl8N0y58M7", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_int_MAX() {
        long id = Integer.MAX_VALUE;
        String encodedValue = Base62.encode(id);
        assertEquals("2lkCB1", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }

    @Test
    public void encoding_MAX_ID_SIZE_return_ZZZZZZZZ_and_decoding() {
        long id = Base62.MAX_ID_SIZE;
        String encodedValue = Base62.encode(id);
        assertEquals("ZZZZZZZZ", encodedValue);
        assertEquals(id, Base62.decode(encodedValue));
    }
}