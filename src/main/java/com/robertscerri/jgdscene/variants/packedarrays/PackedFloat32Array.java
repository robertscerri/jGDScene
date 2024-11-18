package com.robertscerri.jgdscene.variants.packedarrays;

import java.util.List;

public class PackedFloat32Array extends PackedArray<Float> {
    public PackedFloat32Array() {
    }

    public PackedFloat32Array(List<Float> elements) {
        super(elements);
    }

    public PackedFloat32Array(Float[] elements) {
        super(elements);
    }
}
