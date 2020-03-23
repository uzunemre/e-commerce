package com.emreuzun.controller.product;

import com.emreuzun.model.product.SubProduct;
import com.emreuzun.service.product.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private SubProductService subProductService;

    @GetMapping(value = "/product/{seoLink}")
    public ModelAndView get(@PathVariable String seoLink) {
        String[] path = seoLink.split("-");
        String s = path[path.length - 1];
        long productId = Long.parseLong(s);
        SubProduct product = subProductService.getById(productId);
        ModelAndView model = new ModelAndView("product/detail");
        model.addObject("product", product);
        return model;
    }
    
    

}
