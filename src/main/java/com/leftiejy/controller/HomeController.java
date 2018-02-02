package com.leftiejy.controller;

import com.leftiejy.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leftiejy on 2018. 2. 2..
 */
@Controller
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName("hello");
//        model.addAttribute("test", testModel);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("test", testModel);
        return modelAndView;
    }
}
