package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.NumberUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector3 extends Variant implements Comparable<Vector3> {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final Vector3 ZERO = new Vector3(0, 0, 0);
    public static final Vector3 ONE = new Vector3(1, 1, 1);
    public static final Vector3 INF = new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
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

    public double x;
    public double y;
    public double z;

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

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 abs() {
        return new Vector3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    public double angleTo(Vector3 to) {
        return Math.atan2(this.cross(to).length(), this.dot(to));
    }

    public double signedAngleTo(Vector3 to, Vector3 axis) {
        Vector3 crossTo = this.cross(to);

        double unsignedAngle = Math.atan2(crossTo.length(), this.dot(to));
        double sign = crossTo.dot(axis);

        return (sign < 0) ? -unsignedAngle : unsignedAngle;
    }

    //TODO: bezier_derivate, bezier_interpolate

    public Vector3 bounce(Vector3 normal) {
        return this.reflect(normal).multiply(-1);
    }

    public Vector3 ceil() {
        return new Vector3(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    public Vector3 clamp(Vector3 min, Vector3 max) {
        return new Vector3(NumberUtils.clamp(this.x, min.x, max.x), NumberUtils.clamp(this.y, min.y, max.y), NumberUtils.clamp(this.z, min.z, max.z));
    }

    public Vector3 clamp(double min, double max) {
        return new Vector3(NumberUtils.clamp(this.x, min, max), NumberUtils.clamp(this.y, min, max), NumberUtils.clamp(this.z, min, max));
    }

    public Vector3 cross(Vector3 with) {
        return new Vector3(
                (this.y * with.z) - (this.z * with.y),
                (this.z * with.x) - (this.x * with.z),
                (this.x *  with.y) - (this.y * with.x)
        );
    }

    //TODO: cubic_interpolate, cubic_interpolate_in_time

    public Vector3 directionTo(Vector3 to) {
        return to.subtract(this).normalized();
    }

    public double distanceSquaredTo(Vector3 to) {
        return to.subtract(this).lengthSquared();
    }

    public double distanceTo(Vector3 to) {
        return to.subtract(this).length();
    }

    public double dot(Vector3 with) {
        return (this.x * with.x) + (this.y * with.y) + (this.z * with.z);
    }

    public Vector3 floor() {
        return new Vector3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    public Vector3 inverse() {
        return new Vector3(1 / this.x, 1 / this.y, 1 / this.z);
    }

    public boolean isEqualApprox(Vector3 to) {
        return NumberUtils.isEqualApprox(this.x, to.x) && NumberUtils.isEqualApprox(this.y, to.y) && NumberUtils.isEqualApprox(this.z, to.z);
    }

    public boolean isFinite() {
        return Double.isFinite(this.x) && Double.isFinite(this.y) && Double.isFinite(this.z);
    }

    public boolean isNormalized() {
        return NumberUtils.isEqualApprox(this.length(), 1);
    }

    public boolean isZeroApprox() {
        return NumberUtils.isEqualApprox(this.x, 0) && NumberUtils.isEqualApprox(this.y, 0) && NumberUtils.isEqualApprox(this.z, 0);
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double lengthSquared() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }

    public Vector3 lerp(Vector3 to, double weight) {
        return new Vector3(NumberUtils.lerp(this.x, to.x, weight), NumberUtils.lerp(this.y, to.y, weight), NumberUtils.lerp(this.z, to.z, weight));
    }

    public Vector3 limitLength(double length) {
        if (this.length() < length) {
            return this;
        } else {
            return this.normalized().multiply(length);
        }
    }

    public Vector3 max(Vector3 with) {
        return new Vector3(Math.max(this.x, with.x), Math.max(this.y, with.y), Math.max(this.z, with.z));
    }

    public Vector3 max(double with) {
        return new Vector3(Math.max(this.x, with), Math.max(this.y, with), Math.max(this.z, with));
    }

    public int maxAxisIndex() {
        if (this.x < this.y) {
            if (this.y < this.z) {
                return Vector3.AXIS_Z;
            } else {
                return Vector3.AXIS_Y;
            }
        } else {
            if (this.x < this.z) {
                return Vector3.AXIS_Z;
            } else {
                return Vector3.AXIS_X;
            }
        }
    }

    public Vector3 min(Vector3 with) {
        return new Vector3(Math.min(this.x, with.x), Math.min(this.y, with.y), Math.min(this.z, with.z));
    }

    public Vector3 min(double with) {
        return new Vector3(Math.min(this.x, with), Math.min(this.y, with), Math.min(this.z, with));
    }

    public int minAxisIndex() {
        if (this.x < this.y) {
            if (this.x < this.z) {
                return Vector3.AXIS_X;
            } else {
                return Vector3.AXIS_Z;
            }
        } else {
            if (this.y < this.z) {
                return Vector3.AXIS_Y;
            } else {
                return Vector3.AXIS_Z;
            }
        }
    }

    public Vector3 moveToward(Vector3 to, double delta) {
        Vector3 difference = to.subtract(this);
        double distance = difference.length();

        if (distance <= delta || distance == 0) {
            return new Vector3(to);
        }

        return this.add(difference.normalized().multiply(delta));
    }

    public Vector3 normalized() {
        double length = this.length();
        return length == 0 ? Vector3.ZERO : this.divide(this.length());
    }

    //TODO: octahedron_decode, octahedron_encode, outer

    public Vector3 posmod(double mod) {
        return new Vector3(NumberUtils.posmod(this.x, mod), NumberUtils.posmod(this.y, mod), NumberUtils.posmod(this.z, mod));
    }

    public Vector3 posmod(Vector3 mod) {
        return new Vector3(NumberUtils.posmod(this.x, mod.x), NumberUtils.posmod(this.y, mod.y), NumberUtils.posmod(this.z, mod.z));
    }

    public Vector3 project(Vector3 to) {
        return to.multiply(this.dot(to) / to.lengthSquared());
    }

    public Vector3 reflect(Vector3 normal) {
        Vector3 normalSanitised = normal.normalized();

        return normal.multiply(2 * this.dot(normalSanitised)).subtract(this);
    }

    //TODO: rotated

    public Vector3 round() {
        return new Vector3(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }

    public Vector3 sign() {
        return new Vector3(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z));
    }

    public Vector3 slerp(Vector3 to, double weight) {
        double startLengthSquared = this.lengthSquared();
        double endLengthSquared = to.lengthSquared();

        if (startLengthSquared == 0 || endLengthSquared == 0) {
            return this.lerp(to, weight);
        }

        Vector3 axis = this.cross(to);
        double axisLengthSquared = axis.lengthSquared();

        if (axisLengthSquared == 0) {
            return this.lerp(to, weight);
        }

        axis = axis.divide(Math.sqrt(axisLengthSquared));
        double startLength = Math.sqrt(startLengthSquared);
        double resultLength = NumberUtils.lerp(startLength, Math.sqrt(endLengthSquared), weight);
        double angle = this.angleTo(to);

        return new Vector3();
        //TODO: return this.rotated(axis, angle * weight) * (resultLength / startLength);
    }

    public Vector3 slide(Vector3 normal) {
        Vector3 normalSanitised = normal.normalized();

        return this.subtract(normalSanitised).multiply(this.dot(normalSanitised));
    }

    public Vector3 snapped(Vector3 step) {
        return new Vector3(Math.round(this.x / step.x) * step.x, Math.round(this.y / step.y) * step.y, Math.round(this.z / step.z) * step.z);
    }

    public Vector3 snapped(double step) {
        return new Vector3(Math.round(this.x / step) * step, Math.round(this.y / step) * step, Math.round(this.z / step) * step);
    }

    //TODO: multiply(Basis), multiply(Quaternion), multiply(Transform3D)

    public Vector3 multiply(Vector3 right) {
        return new Vector3(this.x * right.x, this.y * right.y, this.z * right.z);
    }

    public Vector3 multiply(double right) {
        return new Vector3(this.x * right, this.y * right, this.z * right);
    }

    public Vector3 multiply(int right) {
        return new Vector3(this.x * right, this.y * right, this.z * right);
    }

    public Vector3 add(Vector3 right) {
        return new Vector3(this.x + right.x, this.y + right.y, this.z + right.z);
    }

    public Vector3 subtract(Vector3 right) {
        return new Vector3(this.x - right.x, this.y - right.y, this.z - right.z);
    }

    public Vector3 divide(Vector3 right) {
        return new Vector3(this.x / right.x, this.y / right.y, this.z / right.z);
    }

    public Vector3 divide(double right) {
        return new Vector3(this.x / right, this.y / right, this.z / right);
    }

    public Vector3 divide(int right) {
        return new Vector3(this.x / right, this.y / right, this.z / right);
    }

    @Override
    public int compareTo(Vector3 o) {
        int comparisonX = Double.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        }

        int comparisonY = Double.compare(this.y, o.y);

        if (comparisonY != 0) {
            return comparisonY;
        } else {
            return Double.compare(this.z, o.z);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector3 vec) {
            return this.x == vec.x && this.y == vec.y && this.z == vec.z;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%f, %f, %f".formatted(this.x, this.y, this.z));
    }
}