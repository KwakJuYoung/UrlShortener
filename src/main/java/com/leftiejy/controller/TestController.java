package com.leftiejy.controller;

import com.leftiejy.model.TestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leftiejy on 2018. 2. 2..
 */
@Controller
public class TestController {
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> test(Model model) {
//        model.addAttribute("test", new TestModel());
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName("hello");
        return ResponseEntity.ok(testModel);
    }

    @RequestMapping(value = "helloworld", method = RequestMethod.GET)
    public ModelAndView helloWorld(Model model) {
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName("hello");
//        model.addAttribute("test", testModel);
        ModelAndView modelAndView = new ModelAndView("helloworld");
        modelAndView.addObject("test", testModel);
        return modelAndView;
    }
}
