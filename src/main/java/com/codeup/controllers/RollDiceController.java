package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice (){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guess(@PathVariable String n, Model model) {
        int random = (int) Math.floor(Math.random() * 6) + 1;
        model.addAttribute("n", n);
        model.addAttribute("guess", random);
        return "roll-dice";
    }
}