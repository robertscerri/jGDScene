package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.FloatUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector2 extends Variant {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 ONE = new Vector2(1, 1);
    public static final Vector2 INF = new Vector2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final Vector2 LEFT = new Vector2(-1, 0);
    public static final Vector2 RIGHT = new Vector2(1, 0);
    public static final Vector2 UP = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(0, 1);

    public float x;
    public float y;

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(Vector2 from) {
        this.x = from.x;
        this.y = from.y;
    }

    public Vector2(Vector2i from) {
        this.x = from.x;
        this.y = from.y;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 abs() {
        return new Vector2(Math.abs(this.x), Math.abs(this.y));
    }

    public float angle() {
        return (float) Math.atan(this.y / this.x);
    }

    public float angleTo(Vector2 to) {
        return (float) Math.acos(this.dot(to) / (this.length() * to.length()));
    }

    public Vector2 ceil() {
        return new Vector2((float) Math.ceil(this.x), (float) Math.ceil(this.y));
    }

    public Vector2 clamp(Vector2 min, Vector2 max) {
        return new Vector2(Math.max(min.x, Math.min(this.x, max.x)), Math.max(min.y, Math.min(this.y, max.y)));
    }

    public Vector2 clampf(float min, float max) {
        return new Vector2(Math.max(min, Math.min(this.x, max)), Math.max(min, Math.min(this.y, max)));
    }

    //TODO: cross, cubic_interpolate, cubic_interpolate_in_time

    public Vector2 directionTo(Vector2 to) {
        return to.subtract(this).normalized();
    }

    public float distanceSquaredTo(Vector2 to) {
        return (float) (Math.pow(to.x - this.x, 2) + Math.pow(to.y - this.y, 2));
    }

    public float distanceTo(Vector2 to) {
        return (float) Math.sqrt(Math.pow(to.x - this.x, 2) + Math.pow(to.y - this.y, 2));
    }

    public float dot(Vector2 with) {
        return (this.x * with.x) + (this.y * with.y);
    }

    public Vector2 floor() {
        return new Vector2((float) Math.floor(this.x), (float) Math.floor(this.y));
    }

    public Vector2 fromAngle(float angle) {
        return new Vector2((float) Math.cos(angle), (float) Math.sin(angle));
    }

    //TODO: is_equal_approx

    public boolean isFinite() {
        return Float.isFinite(this.x) && Float.isFinite(this.y);
    }

    public boolean isNormalized() {
        return FloatUtils.isEqualApprox(this.length(), 1);
    }

    public boolean isZeroApprox() {
        return FloatUtils.isEqualApprox(this.x, 0) && FloatUtils.isEqualApprox(this.y, 0);
    }

    public float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }

    public float lengthSquared() {
        return (this.x * this.x) + (this.y * this.y);
    }

    //TODO: lerp

    public Vector2 limitLength(float length) {
        if (this.length() < length) {
            return this;
        } else {
            return this.normalized().multiply(length);
        }
    }

    public Vector2 max(Vector2 with) {
        return new Vector2(Math.max(this.x, with.x), Math.max(this.y, with.y));
    }

    public int maxAxisIndex() {
        if (this.x >= this.y) {
            return Vector2.AXIS_X;
        } else {
            return Vector2.AXIS_Y;
        }
    }

    public Vector2 maxf(float with) {
        return new Vector2(Math.max(this.x, with), Math.max(this.y, with));
    }

    public Vector2 min(Vector2 with) {
        return new Vector2(Math.min(this.x, with.x), Math.min(this.y, with.y));
    }

    public int minAxisIndex() {
        if (this.y <= this.x) {
            return Vector2.AXIS_Y;
        } else {
            return Vector2.AXIS_X;
        }
    }

    public Vector2 minf(float with) {
        return new Vector2(Math.min(this.x, with), Math.min(this.y, with));
    }

    //TODO: move_toward

    public Vector2 normalized() {
        Vector2 copy = new Vector2(this);
        return copy.divide(copy.length());
    }

    //TODO: orthogonal, posmod, posmodv, project, reflect, rotated

    public Vector2 round() {
        return new Vector2((float) Math.round(this.x), (float) Math.round(this.y));
    }

    public Vector2 sign() {
        return new Vector2(Math.signum(this.x), Math.signum(this.y));
    }

    //TODO: slerp, slide, snapped, snappedf

    //TODO: multiply for Transform2D

    public Vector2 multiply(Vector2 right) {
        return new Vector2(this.x * right.x, this.y * right.y);
    }

    public Vector2 multiply(float right) {
        return new Vector2(this.x * right, this.y * right);
    }

    public Vector2 multiply(int right) {
        return new Vector2(this.x * right, this.y * right);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 divide(Vector2 right) {
        return new Vector2(this.x / right.x, this.y / right.y);
    }

    public Vector2 divide(float right) {
        return new Vector2(this.x / right, this.y / right);
    }

    public Vector2 divide(int right) {
        return new Vector2(this.x / right, this.y / right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2 vec) {
            return this.x == vec.x && this.y == vec.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%f, %f".formatted(this.x, this.y));
    }
}