package com.codeup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResumeController {

    @RequestMapping("/resume")
    public String showResume(){
        return ("resume");
    }
}
