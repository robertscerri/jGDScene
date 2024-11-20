package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.IntegerUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector4i extends Variant implements Comparable<Vector4i> {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final int AXIS_W = 3;
    public static final Vector4i ZERO = new Vector4i(0, 0, 0, 0);
    public static final Vector4i ONE = new Vector4i(1, 1, 1, 1);
    public static final Vector4i MIN = new Vector4i(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final Vector4i MAX = new Vector4i(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    public int w;
    public int x;
    public int y;
    public int z;

    public Vector4i() {
        w = 0;
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector4i(Vector4i from) {
        this.w = from.w;
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector4i(Vector4 from) {
        this.w = (int) from.w;
        this.x = (int) from.x;
        this.y = (int) from.y;
        this.z = (int) from.z;
    }

    public Vector4i(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4i abs() {
        return new Vector4i(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }

    public Vector4i clamp(Vector4i min, Vector4i max) {
        return new Vector4i(IntegerUtils.clamp(this.x, min.x, max.x), IntegerUtils.clamp(this.y, min.y, max.y), IntegerUtils.clamp(this.z, min.z, max.z), IntegerUtils.clamp(this.w, min.w, max.w));
    }

    public Vector4i clamp(int min, int max) {
        return new Vector4i(IntegerUtils.clamp(this.x, min, max), IntegerUtils.clamp(this.y, min, max), IntegerUtils.clamp(this.z, min, max), IntegerUtils.clamp(this.w, min, max));
    }

    public float distanceSquaredTo(Vector4i to) {
        return to.subtract(this).lengthSquared();
    }

    public float distanceTo(Vector4i to) {
        return to.subtract(this).length();
    }

    public float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }

    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z) + (this.w * this.w);
    }

    public Vector4i max(Vector4i with) {
        return new Vector4i(Math.max(this.x, with.x), Math.max(this.y, with.y), Math.max(this.z, with.z), Math.max(this.w, with.w));
    }

    public Vector4i max(int with) {
        return new Vector4i(Math.max(this.x, with), Math.max(this.y, with), Math.max(this.z, with), Math.max(this.w, with));
    }

    public int maxAxisIndex() {
        int maxIndex = Vector4i.AXIS_X;
        float maxValue = x;

        if (this.y > maxValue) {
            maxValue = this.y;
            maxIndex = Vector4i.AXIS_Y;
        }

        if (this.z > maxValue) {
            maxValue = this.z;
            maxIndex = Vector4i.AXIS_Z;
        }

        if (this.w > maxValue) {
            maxValue = this.w;
            maxIndex = Vector4i.AXIS_W;
        }

        return maxIndex;
    }

    public Vector4i min(Vector4i with) {
        return new Vector4i(Math.min(this.x, with.x), Math.min(this.y, with.y), Math.min(this.z, with.z), Math.min(this.w, with.w));
    }

    public Vector4i min(int with) {
        return new Vector4i(Math.min(this.x, with), Math.min(this.y, with), Math.min(this.z, with), Math.min(this.w, with));
    }

    public int minAxisIndex() {
        int maxIndex = Vector4i.AXIS_X;
        float maxValue = x;

        if (this.y <= maxValue) {
            maxValue = this.y;
            maxIndex = Vector4i.AXIS_Y;
        }

        if (this.z <= maxValue) {
            maxValue = this.z;
            maxIndex = Vector4i.AXIS_Z;
        }

        if (this.w <= maxValue) {
            maxValue = this.w;
            maxIndex = Vector4i.AXIS_W;
        }

        return maxIndex;
    }

    public Vector4i sign() {
        return new Vector4i(Integer.signum(this.x), Integer.signum(this.y), Integer.signum(this.z), Integer.signum(this.w));
    }

    public Vector4i snapped(Vector4i step) {
        return new Vector4i(Math.round(this.x / (float) step.x) * step.x, Math.round(this.y / (float) step.y) * step.y, Math.round(this.z / (float) step.z) * step.z, Math.round(this.w / (float) step.w) * step.w);
    }

    public Vector4i snapped(int step) {
        return new Vector4i(Math.round(this.x / (float) step) * step, Math.round(this.y / (float) step) * step, Math.round(this.z / (float) step) * step, Math.round(this.w / (float) step) * step);
    }

    public Vector4i modulo(Vector4i right) {
        return new Vector4i(this.x % right.x, this.y % right.y, this.z % right.z, this.w % right.w);
    }

    public Vector4i modulo(int right) {
        return new Vector4i(this.x % right, this.y % right, this.z % right, this.w % right);
    }

    public Vector4i multiply(Vector4i right) {
        return new Vector4i(this.x * right.x, this.y * right.y, this.z * right.z, this.w * right.w);
    }

    public Vector4 multiply(float right) {
        return new Vector4(this.x * right, this.y * right, this.z * right, this.w * right);
    }

    public Vector4i multiply(int right) {
        return new Vector4i(this.x * right, this.y * right, this.z * right, this.w * right);
    }

    public Vector4i add(Vector4i right) {
        return new Vector4i(this.x + right.x, this.y + right.y, this.z + right.z, this.w + right.w);
    }

    public Vector4i subtract(Vector4i right) {
        return new Vector4i(this.x - right.x, this.y - right.y, this.z - right.z, this.w - right.w);
    }

    public Vector4i divide(Vector4i right) {
        return new Vector4i(this.x / right.x, this.y / right.y, this.z / right.z, this.w / right.w);
    }

    public Vector4 divide(float right) {
        return new Vector4(this.x / right, this.y / right, this.z / right, this.w / right);
    }

    public Vector4i divide(int right) {
        return new Vector4i(this.x / right, this.y / right, this.z / right, this.w / right);
    }

    @Override
    public int compareTo(Vector4i o) {
        int comparisonX = Integer.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        }

        int comparisonY = Integer.compare(this.y, o.y);

        if (comparisonY != 0) {
            return comparisonY;
        }

        int comparisonZ = Integer.compare(this.z, o.z);

        if (comparisonZ != 0) {
            return comparisonZ;
        } else {
            return Integer.compare(this.w, o.w);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector4 vec) {
            return this.x == vec.x && this.y == vec.y && this.z == vec.z && this.w == vec.w;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%d, %d, %d, %d".formatted(this.w, this.x, this.y, this.z));
    }
}