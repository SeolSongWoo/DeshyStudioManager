package com.deshy.stduio.deshystudiomanager.controller.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLMappingController {

    @GetMapping("/main")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "pages-login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "pages-register";
    }
}
