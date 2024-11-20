package com.robertscerri.jgdscene.utils;

public class IntegerUtils {
    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
}
