package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector2;

import java.util.ArrayList;
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

    @Override
    public PackedVector2Array duplicate() {
        List<Vector2> copiedElements = new ArrayList<>(this.elements.size());

        for (Vector2 vec : this.elements) {
            copiedElements.add(new Vector2(vec));
        }

        return new PackedVector2Array(copiedElements);
    }
}
