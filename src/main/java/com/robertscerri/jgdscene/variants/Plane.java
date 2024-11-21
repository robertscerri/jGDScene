package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.utils.FloatUtils;
import com.robertscerri.jgdscene.variants.vectors.Vector3;

public class Plane extends Variant {
    public static final Plane PLANE_YZ = new Plane(1, 0, 0, 0);
    public static final Plane PLANE_XZ = new Plane(0, 1, 0, 0);
    public static final Plane PLANE_XY = new Plane(0, 0, 1, 0);

    public float d;
    public Vector3 normal;

    public Plane() {
        this.d = 0;
        this.normal = new Vector3(0, 0, 0);
    }

    public Plane(Plane from) {
        this.d = from.d;
        this.normal = new Vector3(from.normal);
    }

    public Plane(float a, float b, float c, float d) {
        this.d = d;
        this.normal = new Vector3(a, b, c);
    }

    public Plane(Vector3 normal) {
        this.d = 0;
        this.normal = normal.normalized();
    }

    public Plane(Vector3 normal, float d) {
        this.d = d;
        this.normal = normal.normalized();
    }

    //TODO: Add other plane constructors

    public float distanceTo(Vector3 point) {
        return this.normal.dot(point) - this.d;
    }

    public Vector3 getCenter() {
        return this.normal.multiply(this.d);
    }

    public boolean hasPoint(Vector3 point, float tolerance) {
        float dist = this.distanceTo(point);
        dist = Math.abs(dist);

        return dist < tolerance;
    }

    public boolean isEqualApprox(Plane toPlane) {
        return this.normal.isEqualApprox(toPlane.normal) && FloatUtils.isEqualApprox(this.d, toPlane.d);
    }

    public boolean isFinite() {
        return this.normal.isFinite() && Float.isFinite(this.d);
    }

    public Plane normalized() {
        if (this.normal.isZeroApprox()) {
            return new Plane(0, 0, 0, 0);
        }

        return new Plane(this.normal.normalized(), this.d);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plane plane) {
            return this.normal.equals(plane.normal) && FloatUtils.isEqualApprox(this.d, plane.d);
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("%f, %f, %f, %f".formatted(this.normal.x, this.normal.y, this.normal.z, this.d));
    }
}
