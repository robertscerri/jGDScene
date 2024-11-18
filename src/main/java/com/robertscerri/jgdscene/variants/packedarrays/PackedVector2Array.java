package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector2;

import java.util.List;

public class PackedVector2Array extends PackedArray<Vector2> {
    public PackedVector2Array() {
    }

    public PackedVector2Array(List<Vector2> elements) {
        super(elements);
    }

    public PackedVector2Array(Vector2[] elements) {
        super(elements);
    }
}
