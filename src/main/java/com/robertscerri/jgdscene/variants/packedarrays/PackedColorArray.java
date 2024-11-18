package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.Color;

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
}
