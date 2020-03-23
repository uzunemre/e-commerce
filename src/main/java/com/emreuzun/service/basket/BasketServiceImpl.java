package com.emreuzun.service.basket;

import com.emreuzun.dto.request.AddToBasketRequest;
import com.emreuzun.model.basket.Basket;
import com.emreuzun.model.product.SubProduct;
import com.emreuzun.model.user.User;
import com.emreuzun.repository.basket.BasketRepository;
import com.emreuzun.repository.user.UserRepository;
import com.emreuzun.service.product.SubProductService;
import com.emreuzun.util.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubProductService productService;

    public Basket save(String username, AddToBasketRequest request) {
        User user = userRepository.findOneByUsername(username);
        SubProduct product = productService.getById(request.getSubProductId());
        Optional<Basket> optionalBasket = basketRepository.findByProduct(product);
        Basket basket;
        if (optionalBasket.isPresent()) {
            basket = optionalBasket.get();
            basket.setQuantity(BigDecimalUtil.add(basket.getQuantity(), request.getQuantity()));
        } else {
            basket = new Basket(user, product, request.getQuantity());
        }
        return basketRepository.save(basket);
    }

    public List<Basket> getAllByIdDesc(String userName) {
        return basketRepository.findByUserName(userName);
    }

    public BigDecimal getTotalPrice(List<Basket> basketList) {
        return basketList.stream()
                .map(Basket::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
