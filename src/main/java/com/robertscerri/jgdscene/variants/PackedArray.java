package com.robertscerri.jgdscene.variants;

import java.util.ArrayList;
import java.util.Iterator;

public class PackedArray<T> extends ArrayList<T> {
    //TODO: Add remaining packed array methods

    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getSimpleName()).append("(");

        Iterator<T> it = this.iterator();

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
