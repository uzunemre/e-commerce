package com.emreuzun.controller.product;

import com.emreuzun.dto.request.AddToBasketRequest;
import com.emreuzun.dto.response.GenericResponse;
import com.emreuzun.model.basket.Basket;
import com.emreuzun.service.basket.BasketService;
import com.emreuzun.util.BudgetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping(value = "/basket")
    public ModelAndView get(Principal principal) {
        List<Basket> basketList = basketService.getAllByIdDesc(principal.getName());
        ModelAndView model = new ModelAndView("basket/detail");
        model.addObject("basketProducts", new ArrayList<>(basketList));
        BigDecimal totalPrice = basketService.getTotalPrice(basketList);
        model.addObject("totalPrice", totalPrice);
        model.addObject("taxPrice", BudgetUtil.getTax(totalPrice, new BigDecimal(18)));
        return model;
    }

    @ResponseBody
    @PostMapping(value = "/basket/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToBasket(Principal principal, @RequestBody @Valid AddToBasketRequest request) {
        basketService.save(principal.getName(), request);
        return ResponseEntity.ok(new GenericResponse("Added to Basket"));
    }


}
