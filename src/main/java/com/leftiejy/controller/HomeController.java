package com.leftiejy.controller;

import com.leftiejy.model.TestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leftiejy on 2018. 2. 2..
 */
@Controller
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName("hello");
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("test", testModel);
        return modelAndView;
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> test(@PathVariable("key") String key) {
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName(key);
        return ResponseEntity.ok(testModel);
    }
}
