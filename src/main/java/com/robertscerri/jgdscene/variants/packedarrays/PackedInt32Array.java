package com.robertscerri.jgdscene.variants.packedarrays;

import java.util.List;

public class PackedInt32Array extends PackedArray<Integer> {
    public PackedInt32Array() {
    }

    public PackedInt32Array(List<Integer> elements) {
        super(elements);
    }

    public PackedInt32Array(Integer[] elements) {
        super(elements);
    }
}
