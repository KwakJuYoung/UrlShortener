package com.leftiejy.service;

import com.leftiejy.model.Url;
import com.leftiejy.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
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

    public void addUrl(Url url) {
        LOGGER.debug("addUrl : " + url.toString());
        urlRepository.save(url);
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

    public boolean updateUrl(Url url) {
        LOGGER.debug("updateUrl : " + url.toString());
        try {
            urlRepository.update(url);
        } catch (Exception e) {
            LOGGER.error(this.getClass().toString(), e);
            return false;
        }
        return true;
    }
}
