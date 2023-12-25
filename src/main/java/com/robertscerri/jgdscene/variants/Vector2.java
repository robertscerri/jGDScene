package com.robertscerri.jgdscene.variants;

public class Vector2 {
    public double x;
    public double y;

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(Vector2 from) {
        this.x = from.x;
        this.y = from.y;
    }

    public Vector2(double x, double y) {
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

    public String toString() {
        return "Vector2(%f, %f)".formatted(this.x, this.y);
    }
}