package com.robertscerri.jgdscene.variants.vectors;
//TODO: UPDATE
import com.robertscerri.jgdscene.variants.Variant;

public class Vector2i extends Variant {
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

    //TODO: Add the rest of the Vector2i methods

    public double angle() {
        return Math.atan(this.y / (double) this.x);
    }

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2i add(Vector2i other) {
        return new Vector2i(this.x + other.x, this.y + other.y);
    }

    public Vector2i subtract(Vector2i other) {
        return new Vector2i(this.x - other.x, this.y - other.y);
    }

    public Vector2i multiply(Vector2i other) {
        return new Vector2i(this.x * other.x, this.y * other.y);
    }

    public Vector2i divide(Vector2i other) {
        return new Vector2i(this.x / other.x, this.y / other.y);
    }

    public String toString() {
        return super.toString("%d, %d".formatted(this.x, this.y));
    }
}