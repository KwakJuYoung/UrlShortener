package com.leftiejy.controller;

import com.leftiejy.model.Url;
import com.leftiejy.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if (url == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(url);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUrl(@RequestBody Url url) {
        Url savedUrl = urlService.findByUrl(url.getOriginUrl());
        if (savedUrl != null) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .header(HttpHeaders.LOCATION, String.format("/urls/%d", savedUrl.getId()))
                .body(savedUrl);
        }
        Url resultUrl = urlService.addUrl(url);

        return ResponseEntity.ok(resultUrl);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUrl(@RequestBody Url url) {
        if (!urlService.updateUrl(url)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(url);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUrl(@PathVariable Long id) {
        if (!urlService.removeUrl(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }
}
