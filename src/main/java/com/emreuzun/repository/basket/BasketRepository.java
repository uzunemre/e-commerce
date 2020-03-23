package com.emreuzun.repository.basket;


import com.emreuzun.model.basket.Basket;
import com.emreuzun.model.product.SubProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query("select b from Basket b where b.user.username = ?1")
    List<Basket> findByUserName(String userName);

    Optional<Basket> findByProduct(SubProduct product);

}
