package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.variants.Variant;

public class Vector3 extends Variant {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final Vector3 ZERO = new Vector3(0, 0, 0);
    public static final Vector3 ONE = new Vector3(1, 1, 1);
    public static final Vector3 INF = new Vector3(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final Vector3 LEFT = new Vector3(-1, 0, 0);
    public static final Vector3 RIGHT = new Vector3(1, 0, 0);
    public static final Vector3 UP = new Vector3(0, 1, 0);
    public static final Vector3 DOWN = new Vector3(0, -1, 0);
    public static final Vector3 FORWARD = new Vector3(0, 0, -1);
    public static final Vector3 BACK = new Vector3(0, 0, 1);
    public static final Vector3 MODEL_LEFT = new Vector3(1, 0, 0);
    public static final Vector3 MODEL_RIGHT = new Vector3(-1, 0, 0);
    public static final Vector3 MODEL_TOP = new Vector3(0, 1, 0);
    public static final Vector3 MODEL_BOTTOM = new Vector3(0, -1, 0);
    public static final Vector3 MODEL_FRONT = new Vector3(0, 0, 1);
    public static final Vector3 MODEL_REAR = new Vector3(0, 0, -1);

    public float x;
    public float y;
    public float z;

    public Vector3() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3(Vector3 from) {
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector3(Vector3i from) {
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 abs() {
        return new Vector3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    //TODO: Add the rest of the Vector3 methods

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3 multiply(Vector3 other) {
        return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    public Vector3 divide(Vector3 other) {
        return new Vector3(this.x / other.x, this.y / other.y, this.z / other.z);
    }

    public String toString() {
        return super.toString("%f, %f, %f".formatted(this.x, this.y, this.z));
    }
}