package com.robertscerri.jgdscene.utils;

public class FloatUtils {
    private static final float TOLERANCE = 0.00000000000001f;

    public static boolean isEqualApprox(float a, float b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public static float lerp(float from, float to, float weight) {
        return from + ((to - from) * weight);
    }
}
