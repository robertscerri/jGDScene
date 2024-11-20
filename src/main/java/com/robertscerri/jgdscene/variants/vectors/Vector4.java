package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.FloatUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector4 extends Variant implements Comparable<Vector4> {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final int AXIS_W = 3;
    public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);
    public static final Vector4 ONE = new Vector4(1, 1, 1, 1);
    public static final Vector4 INF = new Vector4(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    public float w;
    public float x;
    public float y;
    public float z;

    public Vector4() {
        w = 0;
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector4(Vector4 from) {
        this.w = from.w;
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector4(Vector4i from) {
        this.w = from.w;
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4 abs() {
        return new Vector4(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }

    public Vector4 ceil() {
        return new Vector4((float) Math.ceil(this.x), (float) Math.ceil(this.y), (float) Math.ceil(this.z), (float) Math.ceil(this.w));
    }

    public Vector4 clamp(Vector4 min, Vector4 max) {
        return new Vector4(FloatUtils.clamp(this.x, min.x, max.x), FloatUtils.clamp(this.y, min.y, max.y), FloatUtils.clamp(this.z, min.z, max.z), FloatUtils.clamp(this.w, min.w, max.w));
    }

    public Vector4 clamp(float min, float max) {
        return new Vector4(FloatUtils.clamp(this.x, min, max), FloatUtils.clamp(this.y, min, max), FloatUtils.clamp(this.z, min, max), FloatUtils.clamp(this.w, min, max));
    }

    //TODO: cubic_interpolate, cubic_interpolate_in_time

    public Vector4 directionTo(Vector4 to) {
        return to.subtract(this).normalized();
    }

    public float distanceSquaredTo(Vector4 to) {
        return to.subtract(this).lengthSquared();
    }

    public float distanceTo(Vector4 to) {
        return to.subtract(this).length();
    }

    public float dot(Vector4 with) {
        return (this.x * with.x) + (this.y * with.y) + (this.z * with.z) + (this.w * with.w);
    }

    public Vector4 floor() {
        return new Vector4((float) Math.floor(this.x), (float) Math.floor(this.y), (float) Math.floor(this.z), (float) Math.floor(this.w));
    }

    public Vector4 inverse() {
        return new Vector4(1 / this.x, 1 / this.y, 1 / this.z, 1 / this.w);
    }

    public boolean isEqualApprox(Vector4 to) {
        return FloatUtils.isEqualApprox(this.x, to.x) && FloatUtils.isEqualApprox(this.y, to.y) && FloatUtils.isEqualApprox(this.z, to.z) && FloatUtils.isEqualApprox(this.w, to.w);
    }

    public boolean isFinite() {
        return Float.isFinite(this.x) && Float.isFinite(this.y) && Float.isFinite(this.z) && Float.isFinite(this.w);
    }

    public boolean isNormalized() {
        return FloatUtils.isEqualApprox(this.length(), 1);
    }

    public boolean isZeroApprox() {
        return FloatUtils.isEqualApprox(this.x, 0) && FloatUtils.isEqualApprox(this.y, 0) && FloatUtils.isEqualApprox(this.z, 0) && FloatUtils.isEqualApprox(this.w, 0);
    }

    public float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }

    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z) + (this.w * this.w);
    }

    public Vector4 lerp(Vector4 to, float weight) {
        return new Vector4(FloatUtils.lerp(this.x, to.x, weight), FloatUtils.lerp(this.y, to.y, weight), FloatUtils.lerp(this.z, to.z, weight), FloatUtils.lerp(this.w, to.w, weight));
    }

    public Vector4 max(Vector4 with) {
        return new Vector4(Math.max(this.x, with.x), Math.max(this.y, with.y), Math.max(this.z, with.z), Math.max(this.w, with.w));
    }

    public Vector4 max(float with) {
        return new Vector4(Math.max(this.x, with), Math.max(this.y, with), Math.max(this.z, with), Math.max(this.w, with));
    }

    public int maxAxisIndex() {
        int maxIndex = Vector4.AXIS_X;
        float maxValue = x;

        if (this.y > maxValue) {
            maxValue = this.y;
            maxIndex = Vector4.AXIS_Y;
        }

        if (this.z > maxValue) {
            maxValue = this.z;
            maxIndex = Vector4.AXIS_Z;
        }

        if (this.w > maxValue) {
            maxValue = this.w;
            maxIndex = Vector4.AXIS_W;
        }

        return maxIndex;
    }

    public Vector4 min(Vector4 with) {
        return new Vector4(Math.min(this.x, with.x), Math.min(this.y, with.y), Math.min(this.z, with.z), Math.min(this.w, with.w));
    }

    public Vector4 min(float with) {
        return new Vector4(Math.min(this.x, with), Math.min(this.y, with), Math.min(this.z, with), Math.min(this.w, with));
    }

    public int minAxisIndex() {
        int maxIndex = Vector4.AXIS_X;
        float maxValue = x;

        if (this.y <= maxValue) {
            maxValue = this.y;
            maxIndex = Vector4.AXIS_Y;
        }

        if (this.z <= maxValue) {
            maxValue = this.z;
            maxIndex = Vector4.AXIS_Z;
        }

        if (this.w <= maxValue) {
            maxValue = this.w;
            maxIndex = Vector4.AXIS_W;
        }

        return maxIndex;
    }

    public Vector4 normalized() {
        return this.divide(this.length());
    }

    public Vector4 posmod(float mod) {
        return new Vector4(FloatUtils.posmod(this.x, mod), FloatUtils.posmod(this.y, mod), FloatUtils.posmod(this.z, mod), FloatUtils.posmod(this.w, mod));
    }

    public Vector4 posmod(Vector4 mod) {
        return new Vector4(FloatUtils.posmod(this.x, mod.x), FloatUtils.posmod(this.y, mod.y), FloatUtils.posmod(this.z, mod.z), FloatUtils.posmod(this.w, mod.w));
    }

    public Vector4 round() {
        return new Vector4(Math.round(this.x), Math.round(this.y), Math.round(this.z), Math.round(this.w));
    }

    public Vector4 sign() {
        return new Vector4(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z), Math.signum(this.w));
    }

    public Vector4 snapped(Vector4 step) {
        return new Vector4(Math.round(this.x / step.x) * step.x, Math.round(this.y / step.y) * step.y, Math.round(this.z / step.z) * step.z, Math.round(this.w / step.w) * step.w);
    }

    public Vector4 snapped(float step) {
        return new Vector4(Math.round(this.x / step) * step, Math.round(this.y / step) * step, Math.round(this.z / step) * step, Math.round(this.w / step) * step);
    }

    //TODO: Add operator for Projection

    public Vector4 multiply(Vector4 right) {
        return new Vector4(this.x * right.x, this.y * right.y, this.z * right.z, this.w * right.w);
    }

    public Vector4 multiply(float right) {
        return new Vector4(this.x * right, this.y * right, this.z * right, this.w * right);
    }

    public Vector4 multiply(int right) {
        return new Vector4(this.x * right, this.y * right, this.z * right, this.w * right);
    }

    public Vector4 add(Vector4 right) {
        return new Vector4(this.x + right.x, this.y + right.y, this.z + right.z, this.w + right.w);
    }

    public Vector4 subtract(Vector4 right) {
        return new Vector4(this.x - right.x, this.y - right.y, this.z - right.z, this.w - right.w);
    }

    public Vector4 divide(Vector4 right) {
        return new Vector4(this.x / right.x, this.y / right.y, this.z / right.z, this.w / right.w);
    }

    public Vector4 divide(float right) {
        return new Vector4(this.x / right, this.y / right, this.z / right, this.w / right);
    }

    public Vector4 divide(int right) {
        return new Vector4(this.x / right, this.y / right, this.z / right, this.w / right);
    }

    @Override
    public int compareTo(Vector4 o) {
        int comparisonX = Float.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        }

        int comparisonY = Float.compare(this.y, o.y);

        if (comparisonY != 0) {
            return comparisonY;
        }

        int comparisonZ = Float.compare(this.z, o.z);

        if (comparisonZ != 0) {
            return comparisonZ;
        } else {
            return Float.compare(this.w, o.w);
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
        return super.toString("%f, %f, %f, %f".formatted(this.w, this.x, this.y, this.z));
    }
}