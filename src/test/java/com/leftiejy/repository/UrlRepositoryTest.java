package com.leftiejy.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository urlRepository;

    @Test
    @Transactional
    public void connectionTest() {
        assertNotNull(urlRepository);
        assertEquals(new BigInteger("1"), urlRepository.createSQLQuery("select 1").uniqueResult());
    }
}
