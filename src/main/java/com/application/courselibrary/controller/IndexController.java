package com.application.courselibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
