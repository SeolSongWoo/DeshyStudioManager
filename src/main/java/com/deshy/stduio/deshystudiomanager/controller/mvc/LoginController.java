package com.deshy.stduio.deshystudiomanager.controller.mvc;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error, Model model) {
        model.addAttribute("error",error);
        return new ModelAndView("pages-login");
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "pages-register";
    }

    @GetMapping("/blank")
    public String blankPage() {
        return "pages-blank";
    }
}
