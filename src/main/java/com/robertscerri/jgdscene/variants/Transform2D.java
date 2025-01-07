package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.vectors.Vector2;
import com.robertscerri.jgdscene.variants.vectors.Vector3;

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

    public Transform2D(Matrix3 from) {
        this.origin = new Vector2(from.cells[0][2], from.cells[1][2]);
        this.x = new Vector2(from.cells[0][0], from.cells[1][0]);
        this.y = new Vector2(from.cells[0][1], from.cells[1][1]);
    }

    public Transform2D(Vector2 x, Vector2 y, Vector2 origin) {
        this.origin = new Vector2(origin);
        this.x = new Vector2(x);
        this.y = new Vector2(y);
    }

    public Transform2D affineInverse() {
        return new Transform2D(this.toMatrix3().affineInverse());
    }

    private Matrix3 toMatrix3() {
        return new Matrix3(new Vector3(this.x.x, this.x.y, 0), new Vector3(this.y.x, this.y.y, 0), new Vector3(this.origin.x, this.origin.y, 1));
    }

    public double getRotation() {
        return Math.atan2(this.x.y, this.x.x);
    }

    public Vector2 getScale() {
        double sign = Math.signum(this.toMatrix3().determinant());
        return new Vector2(this.x.length(), sign * this.y.length());
    }

    public double getSkew() {
        double determinant = this.toMatrix3().determinant();
        return Math.acos(this.x.normalized().dot(this.y.normalized().multiply(Math.signum(determinant)))) - (Math.PI * 0.5);
    }

    public Transform2D multiply(Transform2D right) {
        Matrix3 leftMatrix = this.toMatrix3();
        Matrix3 rightMatrix = right.toMatrix3();

        return new Transform2D(leftMatrix.multiply(rightMatrix));
    }

    @Override
    public String toString() {
        return super.toString("%f, %f, %f, %f, %f, %f".formatted(this.x.x, this.x.y, this.y.x, this.y.y, this.origin.x, this.origin.y));
    }
}
