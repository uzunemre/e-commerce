package com.emreuzun.model.basket;

import com.emreuzun.model.product.SubProduct;
import com.emreuzun.model.user.User;
import com.emreuzun.util.BigDecimalUtil;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BASKET")
public class Basket {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUB_PRODUCT_ID", nullable = false)
    private SubProduct product;

    @Column(name = "QUANTITY", precision = 6, nullable = false)
    private BigDecimal quantity;

    public Basket() {

    }

    public Basket(User user, SubProduct product, BigDecimal quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubProduct getProduct() {
        return product;
    }

    public void setProduct(SubProduct product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Transient
    public BigDecimal getTotalPrice() {
        return BigDecimalUtil.multiply(quantity, product.getPrice());
    }
}
