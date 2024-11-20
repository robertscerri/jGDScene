package com.robertscerri.jgdscene.variants.packedarrays;

import java.util.ArrayList;
import java.util.List;

public class PackedFloat64Array extends PackedArray<Double> {
    public PackedFloat64Array() {
    }

    public PackedFloat64Array(List<Double> elements) {
        super(elements);
    }

    public PackedFloat64Array(Double[] elements) {
        super(elements);
    }

    @Override
    public PackedFloat64Array duplicate() {
        return new PackedFloat64Array(new ArrayList<>(this.elements));
    }
}
