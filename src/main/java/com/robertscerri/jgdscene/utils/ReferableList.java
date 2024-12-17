package com.robertscerri.jgdscene.utils;

import com.robertscerri.jgdscene.Referable;

import java.util.ArrayList;
import java.util.Iterator;

public class ReferableList<T extends Referable> extends ArrayList<T> {
    @Override
    public String toString() {
        Iterator<T> iter = this.iterator();

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iter.hasNext()) {
            Referable ref = iter.next();

            sb.append(ref.getReference());

            if (iter.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
