package com.wlong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWord(){
        return "helloWorld";
    }
}
