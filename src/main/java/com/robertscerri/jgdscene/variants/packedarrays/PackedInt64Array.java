package com.robertscerri.jgdscene.variants.packedarrays;

import java.util.ArrayList;
import java.util.List;

public class PackedInt64Array extends PackedArray<Long> {
    public PackedInt64Array() {
    }

    public PackedInt64Array(List<Long> elements) {
        super(elements);
    }

    public PackedInt64Array(Long[] elements) {
        super(elements);
    }

    @Override
    public PackedInt64Array duplicate() {
        return new PackedInt64Array(new ArrayList<>(this.elements));
    }
}
