package com.codewithtopgyal.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name", "Topgyal");
        return "index"; // using template engine: thymeleaf
      // return "index.html";
    }
}
