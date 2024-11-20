package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.Color;

import java.util.ArrayList;
import java.util.List;

public class PackedColorArray extends PackedArray<Color> {
    public PackedColorArray() {
    }

    public PackedColorArray(List<Color> elements) {
        super(elements);
    }

    public PackedColorArray(Color[] elements) {
        super(elements);
    }

    @Override
    public PackedColorArray duplicate() {
        List<Color> copiedElements = new ArrayList<>(this.elements.size());

        for (Color color : this.elements) {
            copiedElements.add(new Color(color));
        }

        return new PackedColorArray(copiedElements);
    }
}
