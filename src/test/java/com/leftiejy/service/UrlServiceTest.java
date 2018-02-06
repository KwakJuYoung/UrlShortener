package com.leftiejy.service;

import com.leftiejy.exception.InvalidShortenUrException;
import com.leftiejy.exception.UrlNotFoundException;
import com.leftiejy.model.Url;
import com.leftiejy.repository.UrlRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by leftiejy on 2018. 2. 6..
 */
public class UrlServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private UrlService urlService = new UrlService();
    private UrlRepository urlRepository;

    @Before
    public void setup() {
        urlRepository = mock(UrlRepository.class);
        urlService.setUrlRepository(urlRepository);
    }

    @Test
    public void addUrl() throws Exception {

        Url url = new Url();
        url.setOriginUrl("test");
        assertNull(url.getHashKey());
        assertNull(url.getEncodedIndex());

        when(urlRepository.getNextId()).thenReturn(10L);

        Url savedUrl = urlService.addUrl(url);
        assertNotNull(savedUrl.getHashKey());
        assertNotNull(savedUrl.getEncodedIndex());
    }


    @Test
    public void updateUrl_success() {
        Url url = new Url();
        url.setOriginUrl("test");

        when(urlRepository.update(any(Url.class))).thenReturn(url);
        assertTrue(urlService.updateUrl(url));
    }

    @Test
    public void updateUrl_catch_exception() {
        when(urlRepository.update(any(Url.class))).thenThrow(new RuntimeException());

        Url url = new Url();
        url.setOriginUrl("test");
        assertFalse(urlService.updateUrl(url));
    }

    @Test
    public void removeUrl_success() throws Exception {
        Url url = new Url();
        url.setOriginUrl("test");

        when(urlRepository.findById(anyLong())).thenReturn(null);
        assertFalse(urlService.removeUrl(1L));
    }

    @Test
    public void removeUrl_catch_exception() throws Exception {
        when(urlRepository.deleteById(anyLong())).thenThrow(new RuntimeException());
        assertFalse(urlService.removeUrl(1L));
    }

    @Test
    public void removeUrl_when_no_target() throws Exception {
        when(urlRepository.findById(anyLong())).thenReturn(null);
        assertFalse(urlService.removeUrl(1L));
    }

    @Test
    public void getUrl_emptyUrl() throws Exception {
        expectedException.expect(InvalidShortenUrException.class);
        urlService.getUrl("");
    }

    @Test
    public void getUrl_shortenUrl_shorter_than_3() throws Exception {
        expectedException.expect(InvalidShortenUrException.class);
        Url url = new Url();
        url.setOriginUrl("test");
        when(urlRepository.findByKey(anyString(), anyString())).thenReturn(url);
        urlService.getUrl("aa");
    }

    @Test
    public void getUrl_shortenUrl_length_3() throws Exception {
        Url url = new Url();
        url.setOriginUrl("test");
        when(urlRepository.findByKey(anyString(), anyString())).thenReturn(url);
        assertEquals("test", urlService.getUrl("aaa"));
    }

    @Test
    public void getUrl_shortenUrl_longer_than_4() throws Exception {
        Url url = new Url();
        url.setOriginUrl("test");
        when(urlRepository.findByKey(anyString(), anyString())).thenReturn(url);
        assertEquals("test", urlService.getUrl("aaaa"));
    }

    @Test
    public void getUrl_not_fount_url() throws Exception {
        expectedException.expect(UrlNotFoundException.class);
        Url url = new Url();
        url.setOriginUrl("test");
        when(urlRepository.findByKey(anyString(), anyString())).thenReturn(null);
        urlService.getUrl("aaaa");
    }
}