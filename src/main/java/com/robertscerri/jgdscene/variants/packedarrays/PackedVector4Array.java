package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector4;

import java.util.List;

public class PackedVector4Array extends PackedArray<Vector4> {
    public PackedVector4Array() {
    }

    public PackedVector4Array(List<Vector4> elements) {
        super(elements);
    }

    public PackedVector4Array(Vector4[] elements) {
        super(elements);
    }
}
