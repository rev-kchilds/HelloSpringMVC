package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @ResponseBody
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hey World";
    }
}
