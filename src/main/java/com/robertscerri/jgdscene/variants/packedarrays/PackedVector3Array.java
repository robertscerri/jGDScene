package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector2;
import com.robertscerri.jgdscene.variants.vectors.Vector3;

import java.util.ArrayList;
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

    @Override
    public PackedVector3Array duplicate() {
        List<Vector3> copiedElements = new ArrayList<>(this.elements.size());

        for (Vector3 vec : this.elements) {
            copiedElements.add(new Vector3(vec));
        }

        return new PackedVector3Array(copiedElements);
    }
}
