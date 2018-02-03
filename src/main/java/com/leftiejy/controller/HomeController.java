package com.leftiejy.controller;

import com.leftiejy.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leftiejy on 2018. 2. 2..
 */
@Controller
public class HomeController {

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping(value = "/{shortenPath}", method = RequestMethod.GET)
        public String redirect(@PathVariable("shortenPath") String shortenPath) {
        return "redirect:" + urlService.getUrl(shortenPath);
    }
}
