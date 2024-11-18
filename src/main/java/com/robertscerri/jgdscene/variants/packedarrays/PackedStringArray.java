package com.robertscerri.jgdscene.variants.packedarrays;

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
}
