package radu.jakab.springboottraining.utils;

import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static List<String> checkMonetaryFormat(BigDecimal number, String errorMsg) {
        int scale = number.stripTrailingZeros().scale();
        int decimals = Math.max(scale, 0);

        List<String> result = new ArrayList<>();
        if (decimals > 2 || BigDecimal.ZERO.compareTo(number) > 0)
            result.add(errorMsg);
        return result;
    }

    public static void throwErrors(List<String> errors) {
        if (!errors.isEmpty()) {
            String msg = String.join(". ", errors);
            throw Problem.valueOf(Status.EXPECTATION_FAILED, msg);
        }
    }
}
