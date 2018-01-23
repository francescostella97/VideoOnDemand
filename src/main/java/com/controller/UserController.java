package com.controller;

import com.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String register(Map<String,Object> model){
        return "form";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(@Valid UserEntity user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "form";
        }
        return "home";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getUserForm( Model model){

        model.addAttribute("user",new UserEntity());
        return "form";

    }



}
