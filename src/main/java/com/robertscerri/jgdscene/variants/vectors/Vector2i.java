package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.variants.Variant;

public class Vector2i extends Variant implements Comparable<Vector2i> {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final Vector2i ZERO = new Vector2i(0, 0);
    public static final Vector2i ONE = new Vector2i(1, 1);
    public static final Vector2i MIN = new Vector2i(Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final Vector2i MAX = new Vector2i(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public static final Vector2i LEFT = new Vector2i(-1, 0);
    public static final Vector2i RIGHT = new Vector2i(1, 0);
    public static final Vector2i UP = new Vector2i(0, -1);
    public static final Vector2i DOWN = new Vector2i(0, 1);

    public int x;
    public int y;

    public Vector2i() {
        x = 0;
        y = 0;
    }

    public Vector2i(Vector2i from) {
        this.x = from.x;
        this.y = from.y;
    }

    public Vector2i(Vector2 from) {
        this.x = (int) from.x;
        this.y = (int) from.y;
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i abs() {
        return new Vector2i(Math.abs(this.x), Math.abs(this.y));
    }

    public float aspect() {
        return this.x / (float) this.y;
    }

    public Vector2i clamp(Vector2i min, Vector2i max) {
        return new Vector2i(Math.max(min.x, Math.min(this.x, max.x)), Math.max(min.y, Math.min(this.y, max.y)));
    }

    public Vector2i clampi(int min, int max) {
        return new Vector2i(Math.max(min, Math.min(this.x, max)), Math.max(min, Math.min(this.y, max)));
    }

    public int distanceSquaredTo(Vector2i to) {
        return ((to.x - this.x) * (to.x - this.x)) + ((to.y - this.y) * (to.y - this.y));
    }

    public float distanceTo(Vector2i to) {
        return (float) Math.sqrt(this.distanceSquaredTo(to));
    }

    public int lengthSquared() {
        return (this.x * this.x) + (this.y * this.y);
    }

    public float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }

    public Vector2i max(Vector2i with) {
        return new Vector2i(Math.max(this.x, with.x), Math.max(this.y, with.y));
    }

    public Vector2i max(int with) {
        return new Vector2i(Math.max(this.x, with), Math.max(this.y, with));
    }

    public int maxAxisIndex() {
        if (this.x >= this.y) {
            return Vector2i.AXIS_X;
        } else {
            return Vector2i.AXIS_Y;
        }
    }

    public Vector2i min(Vector2i with) {
        return new Vector2i(Math.min(this.x, with.x), Math.min(this.y, with.y));
    }

    public Vector2i min(int with) {
        return new Vector2i(Math.min(this.x, with), Math.min(this.y, with));
    }

    public int minAxisIndex() {
        if (this.y <= this.x) {
            return Vector2i.AXIS_Y;
        } else {
            return Vector2i.AXIS_X;
        }
    }

    public Vector2i sign() {
        return new Vector2i(Integer.signum(this.x), Integer.signum(this.y));
    }

    public Vector2i snapped(Vector2i step) {
        return new Vector2i(Math.round(this.x / (float) step.x) * step.x, Math.round(this.y / (float) step.y) * step.y);
    }

    public Vector2i snapped(int step) {
        return new Vector2i(Math.round(this.x / (float) step) * step, Math.round(this.y / (float) step) * step);
    }

    public Vector2i modulo(Vector2i right) {
        return new Vector2i(this.x % right.x, this.y % right.y);
    }

    public Vector2i modulo(int right) {
        return new Vector2i(this.x % right, this.y % right);
    }

    public Vector2i multiply(Vector2i right) {
        return new Vector2i(this.x * right.x, this.y * right.y);
    }

    public Vector2 multiply(float right) {
        return new Vector2(this.x * right, this.y * right);
    }

    public Vector2i multiply(int right) {
        return new Vector2i(this.x * right, this.y * right);
    }

    public Vector2i add(Vector2i right) {
        return new Vector2i(this.x + right.x, this.y + right.y);
    }

    public Vector2i subtract(Vector2i right) {
        return new Vector2i(this.x - right.x, this.y - right.y);
    }

    public Vector2i divide(Vector2i right) {
        return new Vector2i(this.x / right.x, this.y / right.y);
    }

    public Vector2 divide(float right) {
        return new Vector2(this.x / right, this.y / right);
    }

    public Vector2i divide(int right) {
        return new Vector2i(this.x / right, this.y / right);
    }

    @Override
    public int compareTo(Vector2i o) {
        int comparisonX = Integer.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        } else {
            return Integer.compare(this.y, o.y);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2i vec) {
            return this.x == vec.x && this.y == vec.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%d, %d".formatted(this.x, this.y));
    }
}