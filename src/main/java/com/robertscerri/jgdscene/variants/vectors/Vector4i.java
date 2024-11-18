package com.robertscerri.jgdscene.variants.vectors;
//TODO: UPDATE
import com.robertscerri.jgdscene.variants.Variant;

public class Vector4i extends Variant {
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

    //TODO: Add the rest of the Vector4i methods

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2) + Math.pow(this.w, 2));
    }

    public Vector4i add(Vector4i other) {
        return new Vector4i(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    public Vector4i subtract(Vector4i other) {
        return new Vector4i(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    public Vector4i multiply(Vector4i other) {
        return new Vector4i(this.x * other.x, this.y * other.y, this.z * other.z, this.w * other.w);
    }

    public Vector4i divide(Vector4i other) {
        return new Vector4i(this.x / other.x, this.y / other.y, this.z / other.z, this.w / other.w);
    }

    public String toString() {
        return super.toString("%d, %d, %d, %d".formatted(this.w, this.x, this.y, this.z));
    }
}