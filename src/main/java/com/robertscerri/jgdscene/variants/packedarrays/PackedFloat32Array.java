package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public PackedFloat32Array duplicate() {
        return new PackedFloat32Array(new ArrayList<>(this.elements));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        Iterator<Float> it = this.elements.iterator();

        while(it.hasNext()) {
            str.append(NumberUtils.toStringDecimal(it.next()));
            if (it.hasNext()) {
                str.append(", ");
            }
        }

        return super.toString(str.toString());
    }
}
