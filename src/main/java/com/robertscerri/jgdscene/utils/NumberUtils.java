package com.robertscerri.jgdscene.utils;

import java.math.BigDecimal;

public class NumberUtils {
    private static final double TOLERANCE = 0.00000000000001f;

    public static boolean isEqualApprox(double a, double b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public static double lerp(double from, double to, double weight) {
        return from + ((to - from) * weight);
    }

    public static double posmod(double left, double right) {
        return ((left % right) + right) % right;
    }

    public static double clamp(double value, double min, double max) {
        return Math.min(Math.max(value, min), max);
    }

    public static String toStringDecimal(float value) {
        return new BigDecimal(value).toPlainString();
    }

    public static String toStringDecimal(double value) {
        return new BigDecimal(value).toPlainString();
    }
}
