package com.emreuzun.service.basket;

import com.emreuzun.dto.request.AddToBasketRequest;
import com.emreuzun.model.basket.Basket;

import java.math.BigDecimal;
import java.util.List;


public interface BasketService {

    Basket save(String username, AddToBasketRequest request);

    List<Basket> getAllByIdDesc(String userName);

    BigDecimal getTotalPrice(List<Basket> basketList);
}
