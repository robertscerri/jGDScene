package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.NumberUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector3i extends Variant implements Comparable<Vector3i> {
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

    public Vector3i clamp(Vector3i min, Vector3i max) {
        return new Vector3i(NumberUtils.clamp(this.x, min.x, max.x), NumberUtils.clamp(this.y, min.y, max.y), NumberUtils.clamp(this.z, min.z, max.z));
    }

    public Vector3i clamp(int min, int max) {
        return new Vector3i(NumberUtils.clamp(this.x, min, max), NumberUtils.clamp(this.y, min, max), NumberUtils.clamp(this.z, min, max));
    }

    public int distanceSquaredTo(Vector3i to) {
        return to.subtract(this).lengthSquared();
    }

    public double distanceTo(Vector3i to) {
        return to.subtract(this).length();
    }

    public double length() {
        return (double) Math.sqrt(this.lengthSquared());
    }

    public int lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }

    public Vector3i max(Vector3i with) {
        return new Vector3i(Math.max(this.x, with.x), Math.max(this.y, with.y), Math.max(this.z, with.z));
    }

    public Vector3i max(int with) {
        return new Vector3i(Math.max(this.x, with), Math.max(this.y, with), Math.max(this.z, with));
    }

    public int maxAxisIndex() {
        if (this.x < this.y) {
            if (this.y < this.z) {
                return Vector3i.AXIS_Z;
            } else {
                return Vector3i.AXIS_Y;
            }
        } else {
            if (this.x < this.z) {
                return Vector3i.AXIS_Z;
            } else {
                return Vector3i.AXIS_X;
            }
        }
    }

    public Vector3i min(Vector3i with) {
        return new Vector3i(Math.min(this.x, with.x), Math.min(this.y, with.y), Math.min(this.z, with.z));
    }

    public Vector3i min(int with) {
        return new Vector3i(Math.min(this.x, with), Math.min(this.y, with), Math.min(this.z, with));
    }

    public int minAxisIndex() {
        if (this.x < this.y) {
            if (this.x < this.z) {
                return Vector3i.AXIS_X;
            } else {
                return Vector3i.AXIS_Z;
            }
        } else {
            if (this.y < this.z) {
                return Vector3i.AXIS_Y;
            } else {
                return Vector3i.AXIS_Z;
            }
        }
    }

    public Vector3i sign() {
        return new Vector3i(Integer.signum(this.x), Integer.signum(this.y), Integer.signum(this.z));
    }

    public Vector3i snapped(Vector3i step) {
        return new Vector3i((int) Math.round(this.x / (double) step.x) * step.x, (int) Math.round(this.y / (double) step.y) * step.y, (int) Math.round(this.z / (double) step.z) * step.z);
    }

    public Vector3i snapped(int step) {
        return new Vector3i((int) Math.round(this.x / (double) step) * step, (int) Math.round(this.y / (double) step) * step, (int) Math.round(this.z / (double) step) * step);
    }

    public Vector3i modulo(Vector3i right) {
        return new Vector3i(this.x % right.x, this.y % right.y, this.z % right.z);
    }

    public Vector3i modulo(int right) {
        return new Vector3i(this.x % right, this.y % right, this.z % right);
    }

    public Vector3i multiply(Vector3i right) {
        return new Vector3i(this.x * right.x, this.y * right.y, this.z * right.z);
    }

    public Vector3 multiply(double right) {
        return new Vector3(this.x * right, this.y * right, this.z * right);
    }

    public Vector3i multiply(int right) {
        return new Vector3i(this.x * right, this.y * right, this.z * right);
    }

    public Vector3i add(Vector3i right) {
        return new Vector3i(this.x + right.x, this.y + right.y, this.z + right.z);
    }

    public Vector3i subtract(Vector3i right) {
        return new Vector3i(this.x - right.x, this.y - right.y, this.z - right.z);
    }

    public Vector3i divide(Vector3i right) {
        return new Vector3i(this.x / right.x, this.y / right.y, this.z / right.z);
    }

    public Vector3 divide(double right) {
        return new Vector3(this.x / right, this.y / right, this.z / right);
    }

    public Vector3i divide(int right) {
        return new Vector3i(this.x / right, this.y / right, this.z / right);
    }

    @Override
    public int compareTo(Vector3i o) {
        int comparisonX = Integer.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        }

        int comparisonY = Integer.compare(this.y, o.y);

        if (comparisonY != 0) {
            return comparisonY;
        } else {
            return Integer.compare(this.z, o.z);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector3i vec) {
            return this.x == vec.x && this.y == vec.y && this.z == vec.z;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%d, %d, %d".formatted(this.x, this.y, this.z));
    }
}