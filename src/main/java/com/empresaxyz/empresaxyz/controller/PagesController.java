package com.empresaxyz.empresaxyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author apuello
 */
@Controller
public class PagesController {
    
    @GetMapping("/")
    public String login(){
        return "login";
    }
    
    @GetMapping("/dashboard")
    public String index(){
        return "dashboard";
    }
    
    @GetMapping("/vendedores")
    public String vendedores(){
        return "vendedores";
    }
    
    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuarios";
    }
}
