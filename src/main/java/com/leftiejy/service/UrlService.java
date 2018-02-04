package com.leftiejy.service;

import com.leftiejy.exception.UrlNotFoundException;
import com.leftiejy.model.Url;
import com.leftiejy.repository.UrlRepository;
import com.leftiejy.util.Base62;
import com.leftiejy.util.UrlHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UrlService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlService.class);

    @Autowired
    private UrlRepository urlRepository;

    public List<Url> getUrlList() {
        LOGGER.debug("getUrlList");
        return urlRepository.list();
    }

    public Url getUrl(Long id) {
        LOGGER.debug("getUrl : " + id);
        return urlRepository.findById(id);
    }

    public Url addUrl(Url url) {
        String hashKey = UrlHash.encode(url.getOriginUrl());
        String encodedIndex = Base62.encode(urlRepository.getNextId());
        Url savedUrl = urlRepository.findByOriginUrl(hashKey, url.getOriginUrl());
        if (savedUrl != null) {
            return savedUrl;
        }
        url.setHashKey(hashKey);
        url.setEncodedIndex(encodedIndex);
        LOGGER.debug("addUrl : " + url.toString());
        urlRepository.save(url);
        return url;
    }

    public boolean removeUrl(Long id) {
        LOGGER.debug("removeUrl : " + id);
        try {
            return urlRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.error(this.getClass().toString(), e);
            return false;
        }
    }

    public String getUrl(String shortenUrl) throws UrlNotFoundException {
        String hashKey = shortenUrl.substring(0, 3);
        String encodedIndex = shortenUrl.substring(3, shortenUrl.length());
        Url url = urlRepository.findByKey(hashKey, encodedIndex);
        if (url == null) {
            throw new UrlNotFoundException(shortenUrl);
        }
        url.increaseCallCount();
        url.setLastUpdateDate(new Date(System.currentTimeMillis()));
        urlRepository.update(url);

        return url.getOriginUrl();
    }
}
