package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector3;

import java.util.List;

public class PackedVector3Array extends PackedArray<Vector3> {
    public PackedVector3Array() {
    }

    public PackedVector3Array(List<Vector3> elements) {
        super(elements);
    }

    public PackedVector3Array(Vector3[] elements) {
        super(elements);
    }
}
