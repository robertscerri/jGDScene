package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.vectors.Vector3;

public class Plane {
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

    //TODO: Add other plane constructors
}
