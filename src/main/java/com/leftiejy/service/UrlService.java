package com.leftiejy.service;

import com.leftiejy.model.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
@Service
public class UrlService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlService.class);

    public List<Url> getUrlList() {
        LOGGER.debug("getUrlList");
        List<Url> urlList = new ArrayList<>();
        urlList.add(new Url(1, "key1", "originUrl1"));
        urlList.add(new Url(2, "key2", "originUrl2"));
        urlList.add(new Url(3, "key3", "originUrl3"));
        return urlList;
    }

    public Url getUrl(long id) {
        Url url = new Url(id, "key1", "originUrl1");
        LOGGER.debug("getUrl : " + url.toString());
        return url;
    }

    public void addUrl(Url url) {
        LOGGER.debug("addUrl : " + url.toString());
    }

    public boolean removeUrl(long id) {
        LOGGER.debug("removeUrl : " + id);
        return true;
    }

    public boolean updateUrl(Url url) {
        LOGGER.debug("updateUrl : " + url.toString());
        return true;
    }
}
