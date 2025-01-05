package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        Iterator<Double> it = this.elements.iterator();

        while(it.hasNext()) {
            str.append(NumberUtils.toStringDecimal(it.next()));
            if (it.hasNext()) {
                str.append(", ");
            }
        }

        return super.toString(str.toString());
    }
}
