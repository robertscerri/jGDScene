package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.Color;

import java.util.ArrayList;
import java.util.List;

public class PackedStringArray extends PackedArray<String> {
    public PackedStringArray() {
    }

    public PackedStringArray(List<String> elements) {
        super(elements);
    }

    public PackedStringArray(String[] elements) {
        super(elements);
    }

    @Override
    public PackedStringArray duplicate() {
        return new PackedStringArray(new ArrayList<>(this.elements));
    }
}
