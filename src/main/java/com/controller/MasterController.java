package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MasterController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String list(){
        return "Login";
    }
}
