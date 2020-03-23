package com.emreuzun.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("login")
    public ModelAndView signin(Principal principal) {
        if (principal == null) {
            return new ModelAndView("user/login");
        } else {
            return new ModelAndView(new RedirectView("category"));
        }
    }

}
