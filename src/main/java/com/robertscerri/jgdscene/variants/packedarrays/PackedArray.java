package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.Variant;

import java.util.*;

public abstract class PackedArray<T> extends Variant {
    List<T> elements;

    public PackedArray() {
        this.elements = new ArrayList<>();
    }

    public PackedArray(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public PackedArray(T[] elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    //TODO: Add remaining packed array methods

    public boolean append(T value) {
        return this.elements.add(value);
    }

    public boolean appendList(List<T> elements) {
        return this.elements.addAll(elements);
    }

    public void clear() {
        this.elements.clear();
    }

    public long count(T value) {
        long count = 0;

        for (T element : this.elements) {
            if (element.equals(value)) {
                count++;
            }
        }

        return count;
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public void removeAt(int index) {
        this.elements.remove(index);
    }

    public void set(int index, T value) {
        this.elements.set(index, value);
    }

    public int size() {
        return this.elements.size();
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PackedArray<?> other) {
            return this.elements.equals(other.elements);
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        Iterator<T> it = this.elements.iterator();

        while(it.hasNext()) {
            str.append(it.next());
            if (it.hasNext()) {
                str.append(", ");
            }
        }

        return super.toString(str.toString());
    }
}
