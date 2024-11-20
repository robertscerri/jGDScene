package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.vectors.Vector2;
import com.robertscerri.jgdscene.variants.vectors.Vector4;

import java.util.ArrayList;
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

    @Override
    public PackedVector4Array duplicate() {
        List<Vector4> copiedElements = new ArrayList<>(this.elements.size());

        for (Vector4 vec : this.elements) {
            copiedElements.add(new Vector4(vec));
        }

        return new PackedVector4Array(copiedElements);
    }
}
