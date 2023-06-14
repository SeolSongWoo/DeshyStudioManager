package com.deshy.stduio.deshystudiomanager.controller.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URLMappingController {

    @GetMapping("/home")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error, Model model) {
        model.addAttribute("error",error);
        return new ModelAndView("pages-login");
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "pages-register";
    }
}
