package com.robertscerri.jgdscene.variants.vectors;

public class Vector3i {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final Vector3i ZERO = new Vector3i(0, 0, 0);
    public static final Vector3i ONE = new Vector3i(1, 1, 1);
    public static final Vector3i MIN = new Vector3i(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final Vector3i MAX = new Vector3i(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    public static final Vector3i LEFT = new Vector3i(-1, 0, 0);
    public static final Vector3i RIGHT = new Vector3i(1, 0, 0);
    public static final Vector3i UP = new Vector3i(0, 1, 0);
    public static final Vector3i DOWN = new Vector3i(0, -1, 0);
    public static final Vector3i FORWARD = new Vector3i(0, 0, -1);
    public static final Vector3i BACK = new Vector3i(0, 0, 1);

    public int x;
    public int y;
    public int z;

    public Vector3i() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3i(Vector3i from) {
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vector3i(Vector3 from) {
        this.x = (int) from.x;
        this.y = (int) from.y;
        this.z = (int) from.z;
    }

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3i abs() {
        return new Vector3i(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    //TODO: Add the rest of the Vector3i methods

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public Vector3i add(Vector3i other) {
        return new Vector3i(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3i subtract(Vector3i other) {
        return new Vector3i(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3i multiply(Vector3i other) {
        return new Vector3i(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    public Vector3i divide(Vector3i other) {
        return new Vector3i(this.x / other.x, this.y / other.y, this.z / other.z);
    }

    public String toString() {
        return "%s(%d, %d, %d)".formatted(this.getClass().getSimpleName(), this.x, this.y, this.z);
    }
}