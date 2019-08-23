package com.semicolen.spm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SplashController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/hello")
    public ModelAndView goToHelloPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("hello"); //name of the jsp-file in the 'page' folder

        String str = "MVC Spring is here!";
        view.addObject("message", str); //adding of str object as 'message' parameter

        return view;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
