package com.emreuzun.util;

import java.math.BigDecimal;

public class BudgetUtil {

    public static BigDecimal getTax(BigDecimal price, BigDecimal tax) {
        if (tax == null) {
            tax = BigDecimal.ZERO;
        }
        return BigDecimalUtil.divide(BigDecimalUtil.multiply(price, tax), new BigDecimal(100));
    }

}
