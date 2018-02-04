package com.leftiejy.controller;

import com.leftiejy.exception.UrlNotFoundException;
import com.leftiejy.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by leftiejy on 2018. 2. 2..
 */
@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlService.class);

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/{shortenUrl}", method = RequestMethod.GET)
    public ModelAndView redirect(@PathVariable("shortenUrl") String shortenUrl) {
        try {
            RedirectView rv = new RedirectView(urlService.getUrl(shortenUrl));
            return new ModelAndView(rv);
        } catch (UrlNotFoundException e) {
            LOGGER.error(this.getClass().toString(), e.getMessage());
            ModelAndView mv = new ModelAndView("errorPage");
            mv.addObject("shortenUrl", shortenUrl);
            return mv;
        }
    }
}
