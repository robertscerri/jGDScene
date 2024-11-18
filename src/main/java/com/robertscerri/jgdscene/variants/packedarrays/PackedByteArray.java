package com.robertscerri.jgdscene.variants.packedarrays;

import java.util.List;

public class PackedByteArray extends PackedArray<Byte> {
    public PackedByteArray() {}

    public PackedByteArray(List<Byte> elements) {
        super(elements);
    }

    public PackedByteArray(Byte[] elements) {
        super(elements);
    }
}
