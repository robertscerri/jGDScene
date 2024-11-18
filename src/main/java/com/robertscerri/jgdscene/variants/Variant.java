package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.packedarrays.PackedArray;

public abstract class Variant {
    public Variant() {
    }

    @Override
    public String toString() {
        return String.format("%s()", this.getClass().getSimpleName());
    }

    protected String toString(String contents) {
        return "%s(%s)".formatted(this.getClass().getSimpleName(), contents);
    }
}
