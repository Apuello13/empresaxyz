package com.empresaxyz.empresaxyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author apuello
 */
@Controller
public class PagesController {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/dashboard")
    public String index(){
        return "index";
    }
}
