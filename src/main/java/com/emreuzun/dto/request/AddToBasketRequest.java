package com.emreuzun.dto.request;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AddToBasketRequest {

    @NotNull
    private Long subProductId;

    @NotNull
    @Range(min = 1)
    private BigDecimal quantity;

    public Long getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
