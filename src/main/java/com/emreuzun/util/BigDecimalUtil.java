package com.emreuzun.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static BigDecimal add(BigDecimal val1, BigDecimal val2) {
        if (val1 == null && val2 == null) {
            return null;
        }

        if (val1 == null) {
            return BigDecimal.ZERO.add(val2);
        }

        if (val2 == null) {
            return BigDecimal.ZERO.add(val1);
        }

        return val1.add(val2);
    }

    public static BigDecimal multiply(BigDecimal val1, BigDecimal val2) {
        if (val1 == null || val2 == null) {
            return null;
        }
        return val1.multiply(val2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divide(BigDecimal val1, BigDecimal val2) {
        if (val1 == null || val2 == null) {
            return null;
        }
        return val1.divide(val2, 2, BigDecimal.ROUND_HALF_UP);
    }
}
