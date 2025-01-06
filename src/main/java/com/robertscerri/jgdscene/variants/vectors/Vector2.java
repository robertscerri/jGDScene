package com.robertscerri.jgdscene.variants.vectors;

import com.robertscerri.jgdscene.utils.NumberUtils;
import com.robertscerri.jgdscene.variants.Variant;

public class Vector2 extends Variant implements Comparable<Vector2> {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 ONE = new Vector2(1, 1);
    public static final Vector2 INF = new Vector2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Vector2 LEFT = new Vector2(-1, 0);
    public static final Vector2 RIGHT = new Vector2(1, 0);
    public static final Vector2 UP = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(0, 1);

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

    public Vector2(Vector2i from) {
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

    public double angle() {
        return (double) Math.atan(this.y / this.x);
    }

    public double angleTo(Vector2 to) {
        return (double) Math.acos(this.dot(to) / (this.length() * to.length()));
    }

    public double angleToPoint(Vector2 to) {
        return to.subtract(this).angle();
    }

    public double aspect() {
        return this.x / this.y;
    }

    //TODO: bezier_derivative, bezier_interpolate

    public Vector2 bounce(Vector2 normal) {
        return this.reflect(normal).multiply(-1);
    }

    public Vector2 ceil() {
        return new Vector2((double) Math.ceil(this.x), (double) Math.ceil(this.y));
    }

    public Vector2 clamp(Vector2 min, Vector2 max) {
        return new Vector2(NumberUtils.clamp(this.x, min.x, max.x), NumberUtils.clamp(this.y, min.y, max.y));
    }

    public Vector2 clamp(double min, double max) {
        return new Vector2(NumberUtils.clamp(this.x, min, max), NumberUtils.clamp(this.y, min, max));
    }

    public double cross(Vector2 other) {
        return (this.x * other.y) - (this.y * other.x);
    }

    //TODO: cubic_interpolate, cubic_interpolate_in_time

    public Vector2 directionTo(Vector2 to) {
        return to.subtract(this).normalized();
    }

    public double distanceSquaredTo(Vector2 to) {
        return to.subtract(this).lengthSquared();
    }

    public double distanceTo(Vector2 to) {
        return (double) Math.sqrt(Math.pow(to.x - this.x, 2) + Math.pow(to.y - this.y, 2));
    }

    public double dot(Vector2 with) {
        return (this.x * with.x) + (this.y * with.y);
    }

    public Vector2 floor() {
        return new Vector2((double) Math.floor(this.x), (double) Math.floor(this.y));
    }

    public Vector2 fromAngle(double angle) {
        return new Vector2((double) Math.cos(angle), (double) Math.sin(angle));
    }

    public boolean isEqualApprox(Vector2 to) {
        return NumberUtils.isEqualApprox(this.x, to.x) && NumberUtils.isEqualApprox(this.y, to.y);
    }

    public boolean isFinite() {
        return Double.isFinite(this.x) && Double.isFinite(this.y);
    }

    public boolean isNormalized() {
        return NumberUtils.isEqualApprox(this.length(), 1);
    }

    public boolean isZeroApprox() {
        return NumberUtils.isEqualApprox(this.x, 0) && NumberUtils.isEqualApprox(this.y, 0);
    }

    public double length() {
        return (double) Math.sqrt(this.lengthSquared());
    }

    public double lengthSquared() {
        return (this.x * this.x) + (this.y * this.y);
    }

    public Vector2 lerp(Vector2 to, double weight) {
        return new Vector2(NumberUtils.lerp(this.x, to.x, weight), NumberUtils.lerp(this.y, to.y, weight));
    }

    public Vector2 limitLength(double length) {
        if (this.length() < length) {
            return this;
        } else {
            return this.normalized().multiply(length);
        }
    }

    public Vector2 max(Vector2 with) {
        return new Vector2(Math.max(this.x, with.x), Math.max(this.y, with.y));
    }

    public Vector2 max(double with) {
        return new Vector2(Math.max(this.x, with), Math.max(this.y, with));
    }

    public int maxAxisIndex() {
        if (this.x >= this.y) {
            return Vector2.AXIS_X;
        } else {
            return Vector2.AXIS_Y;
        }
    }

    public Vector2 min(Vector2 with) {
        return new Vector2(Math.min(this.x, with.x), Math.min(this.y, with.y));
    }

    public Vector2 min(double with) {
        return new Vector2(Math.min(this.x, with), Math.min(this.y, with));
    }

    public int minAxisIndex() {
        if (this.y <= this.x) {
            return Vector2.AXIS_Y;
        } else {
            return Vector2.AXIS_X;
        }
    }

    public Vector2 moveToward(Vector2 to, double delta) {
        Vector2 difference = to.subtract(this);
        double distance = difference.length();

        if (distance <= delta || distance == 0) {
            return new Vector2(to);
        }

        return this.add(difference.normalized().multiply(delta));
    }

    public Vector2 normalized() {
        double length = this.length();
        return length == 0 ? Vector2.ZERO : this.divide(this.length());
    }

    public Vector2 orthogonal() {
        return this.rotated(Math.PI / 2);
    }

    public Vector2 posmod(double mod) {
        return new Vector2(NumberUtils.posmod(this.x, mod), NumberUtils.posmod(this.y, mod));
    }

    public Vector2 posmod(Vector2 mod) {
        return new Vector2(NumberUtils.posmod(this.x, mod.x), NumberUtils.posmod(this.y, mod.y));
    }

    public Vector2 project(Vector2 b) {
        Vector2 bNorm = b.normalized();

        return bNorm.multiply(this.dot(bNorm));
    }

    public Vector2 reflect(Vector2 normal) {
        Vector2 normalSanitised = normal.normalized();

        return normal.multiply(2 * this.dot(normalSanitised)).subtract(this);
    }

    public Vector2 rotated(double angle) {
        double sinTheta = Math.sin(angle);
        double cosTheta = Math.cos(angle);

        return new Vector2(
                (double) ((this.x * cosTheta) - (this.y * sinTheta)),
                (double) ((this.x * sinTheta) + (this.y * cosTheta))
        );
    }

    public Vector2 round() {
        return new Vector2((double) Math.round(this.x), (double) Math.round(this.y));
    }

    public Vector2 sign() {
        return new Vector2(Math.signum(this.x), Math.signum(this.y));
    }

    public Vector2 slerp(Vector2 to, double weight) {
        double startLengthSquared = this.lengthSquared();
        double endLengthSquared = to.lengthSquared();

        if (startLengthSquared == 0 || endLengthSquared == 0) {
            return this.lerp(to, weight);
        }

        double startLength = (double) Math.sqrt(startLengthSquared);
        double resultLength = NumberUtils.lerp(startLength, (double) Math.sqrt(endLengthSquared), weight);
        double angle = this.angleTo(to);

        return this.rotated(angle * weight).multiply(resultLength / startLength);
    }

    public Vector2 slide(Vector2 normal) {
        Vector2 normalSanitised = normal.normalized();

        return this.subtract(normalSanitised).multiply(this.dot(normalSanitised));
    }

    public Vector2 snapped(Vector2 step) {
        return new Vector2(Math.round(this.x / step.x) * step.x, Math.round(this.y / step.y) * step.y);
    }

    public Vector2 snapped(double step) {
        return new Vector2(Math.round(this.x / step) * step, Math.round(this.y / step) * step);
    }

    //TODO: multiply for Transform2D

    public Vector2 multiply(Vector2 right) {
        return new Vector2(this.x * right.x, this.y * right.y);
    }

    public Vector2 multiply(double right) {
        return new Vector2(this.x * right, this.y * right);
    }

    public Vector2 multiply(int right) {
        return new Vector2(this.x * right, this.y * right);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 divide(Vector2 right) {
        return new Vector2(this.x / right.x, this.y / right.y);
    }

    public Vector2 divide(double right) {
        return new Vector2(this.x / right, this.y / right);
    }

    public Vector2 divide(int right) {
        return new Vector2(this.x / right, this.y / right);
    }

    @Override
    public int compareTo(Vector2 o) {
        int comparisonX = Double.compare(this.x, o.x);

        if (comparisonX != 0) {
            return comparisonX;
        } else {
            return Double.compare(this.y, o.y);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2 vec) {
            return this.x == vec.x && this.y == vec.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%f, %f".formatted(this.x, this.y));
    }
}