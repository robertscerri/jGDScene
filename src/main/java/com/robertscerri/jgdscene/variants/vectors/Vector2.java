package com.robertscerri.jgdscene.variants.vectors;

public class Vector2 {
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

    //TODO: Add the rest of the Vector2 methods

    public double angle() {
        return Math.atan(this.y / this.x);
    }

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 multiply(Vector2 other) {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    public Vector2 divide(Vector2 other) {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    public String toString() {
        return "%s(%f, %f)".formatted(this.getClass().getSimpleName(), this.x, this.y);
    }
}