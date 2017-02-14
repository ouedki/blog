package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage (Model model) {
        model.addAttribute("date", "Feb 7th");
        List<String> names = new ArrayList<>();
        names.add("Ruben");
        names.add("David");
        names.add("Yassine");
        names.add("James");
        model.addAttribute("names", names);
        return "home"; //home.html
    }

    @GetMapping("/contact")
    public String contactPage () {
        return "contact/form"; //form.html
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "<h1>Hello " + name + " from spring!!!</h1>";
    }

    @RequestMapping(path = "/bye/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String Bye(@PathVariable String name) {
        return "<h1>Goodbye " + name + " from spring!!!</h1>";
    }
}
