package com.robertscerri.jgdscene.variants;

import java.util.ArrayList;
import java.util.Iterator;

public class PackedFloat32Array extends ArrayList<Float> {
    public String toString() {
        StringBuilder str = new StringBuilder("PackedFloat32Array(");

        Iterator<Float> it = this.iterator();

        while(it.hasNext()) {
            str.append(it.next());
            if (it.hasNext()) {
                str.append(", ");
            }
        }

        str.append(")");

        return str.toString();
    }
}