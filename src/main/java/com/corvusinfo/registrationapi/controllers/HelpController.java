package com.corvusinfo.registrationapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpController {
    @GetMapping(path="/help")
    public String showHelp(){
        return "help";
    }
}
