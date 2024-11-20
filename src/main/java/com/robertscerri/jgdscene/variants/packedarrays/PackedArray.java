package com.robertscerri.jgdscene.variants.packedarrays;

import com.robertscerri.jgdscene.variants.Variant;

import java.util.*;

public abstract class PackedArray<T extends Comparable<? super T>> extends Variant {
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

    //TODO: duplicate()
    //public abstract PackedArray<T> duplicate();

    public int find(T value) {
        return this.elements.indexOf(value);
    }

    public int rFind(T value) {
        return this.elements.lastIndexOf(value);
    }

    public int bsearch(T value) {
        return Collections.binarySearch(this.elements, value);
    }

    public boolean has(T value) {
        return this.elements.contains(value);
    }

    public void insert(int index, T value) {
        this.elements.add(index, value);
    }

    public void removeAt(int index) {
        this.elements.remove(index);
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public int size() {
        return this.elements.size();
    }

    public void reverse() {
        Collections.reverse(this.elements);
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    public void set(int index, T value) {
        this.elements.set(index, value);
    }

    //TODO: slice
    //public abstract PackedArray<T> slice();

    public void sort() {
        Collections.sort(this.elements);
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
