package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.vectors.Vector2;

public class Transform2D extends Variant {
    public static final Transform2D IDENTITY = new Transform2D(new Vector2(1, 0), new Vector2(0, 1), new Vector2(0, 0));
    public static final Transform2D FLIP_X = new Transform2D(new Vector2(-1, 0), new Vector2(0, 1), new Vector2(0, 0));
    public static final Transform2D FLIP_Y = new Transform2D(new Vector2(1, 0), new Vector2(0, -1), new Vector2(0, 0));

    public Vector2 origin;
    public Vector2 x;
    public Vector2 y;

    public Transform2D() {
        this.origin = new Vector2(0 , 0);
        this.x = new Vector2(1, 0);
        this.y = new Vector2(0, 1);
    }

    public Transform2D(Transform2D from) {
        this.origin = new Vector2(from.origin);
        this.x = new Vector2(from.x);
        this.y = new Vector2(from.y);
    }

    public Transform2D(Vector2 x, Vector2 y, Vector2 origin) {
        this.origin = origin;
        this.x = x;
        this.y = y;
    }

    public float determinant() {
        return this.x.x * this.y.y - this.x.y * this.y.x;
    }

    public float getRotation() {
        return (float) Math.atan2(this.x.y, this.x.x);
    }

    public Vector2 getScale() {
        float sign = Math.signum(this.determinant());
        return new Vector2(this.x.length(), sign * this.y.length());
    }

    public float getSkew() {
        float determinant = this.determinant();
        return (float) Math.acos(this.x.normalized().dot(this.y.normalized().multiply(Math.signum(determinant)))) - ((float) Math.PI * 0.5f);
    }

    public Transform2D multiply(Transform2D right) {
        Vector2 resOrigin = new Vector2((this.x.x * right.origin.x) + (this.x.y * right.origin.y), (this.y.x * right.origin.x) + (this.y.y * right.origin.y)).add(this.origin);

        Vector2 resX = new Vector2((this.x.x * right.x.x) + (this.y.x * right.x.y), (this.x.y * right.x.x) + (this.y.y * right.x.y));
        Vector2 resY = new Vector2((this.x.x * right.y.x) + (this.y.x * right.y.y), (this.x.y * right.y.x) + (this.y.y * right.y.y));

        return new Transform2D(resX, resY, resOrigin);
    }

    @Override
    public String toString() {
        return super.toString("%f, %f, %f, %f, %f, %f".formatted(this.x.x, this.x.y, this.y.x, this.y.y, this.origin.x, this.origin.y));
    }
}
