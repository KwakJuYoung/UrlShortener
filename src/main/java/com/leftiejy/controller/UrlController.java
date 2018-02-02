package com.leftiejy.controller;

import com.leftiejy.model.Url;
import com.leftiejy.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
@RestController
@RequestMapping("/urls")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUrlList() {
        List<Url> urlList = urlService.getUrlList();
        return ResponseEntity.ok(urlList);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUrl(@PathVariable long id) {
        Url url = urlService.getUrl(id);
        return ResponseEntity.ok(url);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUrl(@RequestBody Url url) {
        urlService.addUrl(url);
        return ResponseEntity.ok(url);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUrl(@RequestBody Url url) {
        if (!urlService.updateUrl(url)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(url);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUrl(@PathVariable long id) {
        if (!urlService.removeUrl(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
