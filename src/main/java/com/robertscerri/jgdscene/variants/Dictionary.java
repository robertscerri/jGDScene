package com.robertscerri.jgdscene.variants;

import java.util.*;

public class Dictionary {
    private Map<Object, Object> map;

    public Dictionary() {
        this.map = new HashMap<Object, Object>();
    }

    public Dictionary(Dictionary dictionary) {
        this.map = new HashMap<>(dictionary.map);
    }

    public void clear() {
        this.map.clear();
    }

    public void erase(Object key) {
        this.map.remove(key);
    }

    public Object get(Object key) {
        return this.map.get(key);
    }

    public boolean has(Object key) {
        return this.map.containsKey(key);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<Object> getKeySet() {
        return this.map.keySet();
    }

    public Collection<Object> getValues() {
        return this.map.values();
    }
}
