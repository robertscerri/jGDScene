package com.robertscerri.jgdscene.variants.vectors;
//TODO: UPDATE
import com.robertscerri.jgdscene.variants.Variant;

public class Vector4 extends Variant {
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

    //TODO: Add the rest of the Vector4 methods

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2) + Math.pow(this.w, 2));
    }

    public Vector4 add(Vector4 other) {
        return new Vector4(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    public Vector4 subtract(Vector4 other) {
        return new Vector4(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    public Vector4 multiply(Vector4 other) {
        return new Vector4(this.x * other.x, this.y * other.y, this.z * other.z, this.w * other.w);
    }

    public Vector4 divide(Vector4 other) {
        return new Vector4(this.x / other.x, this.y / other.y, this.z / other.z, this.w / other.w);
    }

    public String toString() {
        return super.toString("%f, %f, %f, %f".formatted(this.w, this.x, this.y, this.z));
    }
}