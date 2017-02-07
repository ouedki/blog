package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping("/add/{numberOne}/and/{numberTwo}")
    @ResponseBody
    public String add(@PathVariable("numberOne") int numberOne, @PathVariable("numberTwo") int numberTow) {
        return numberOne + " + " + numberTow + " = " + (numberOne + numberTow);
    }

    @RequestMapping(path = "/subtract/{numberOne}/from/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable("numberOne") int numberOne, @PathVariable("numberTwo") int numberTow) {
        return  numberOne + " - " + numberTow + " = " + (numberOne - numberTow);
    }

    @RequestMapping(path = "/multiply/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable("numberOne") int numberOne, @PathVariable("numberTwo") int numberTow) {
        return  numberOne + " * " + numberTow + " = " + (numberOne * numberTow);
    }

    @RequestMapping(path = "/divide/{numberOne}/by/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable("numberOne") int numberOne, @PathVariable("numberTwo") int numberTow) {
        return  numberOne + " / " + numberTow + " = " + (numberOne / numberTow);
    }
}
