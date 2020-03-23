package com.emreuzun.controller.home;

import java.security.Principal;

import com.emreuzun.model.category.Category;
import com.emreuzun.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class HomeController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    ModelAndView index(Principal principal) {
        if (principal == null) {
            return new ModelAndView("user/login");
        } else {
            Category category = categoryService.getBySeoPath("");
            return new ModelAndView(new RedirectView("category/" + category.getSeoPath()));
        }
    }
}
