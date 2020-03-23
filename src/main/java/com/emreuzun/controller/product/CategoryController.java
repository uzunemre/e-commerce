package com.emreuzun.controller.product;

import com.emreuzun.model.category.Category;
import com.emreuzun.model.product.SubProduct;
import com.emreuzun.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/category/{seoLink}")
    public ModelAndView get(@PathVariable String seoLink) {
        Category category = categoryService.getBySeoPath(seoLink);
        ModelAndView model = new ModelAndView("category/list");

        List<Category> categories = categoryService.getAllByOrder();
        Long selectedCategoryId = category.getId();

        category = categoryService.getWithProducts(category.getId());

        model.addObject("categories", categories);
        model.addObject("selectedCategoryId", selectedCategoryId);
        List<SubProduct> sortedProductList = category.getSubProductSet().stream()
                .sorted(Comparator.comparing(SubProduct::getName))
                .collect(Collectors.toList());
        model.addObject("products", new ArrayList<>(sortedProductList));

        return model;
    }

}
