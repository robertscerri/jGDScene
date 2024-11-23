package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.Referable;

import java.util.*;

public class Dictionary extends Variant {
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

    public void add(Object key, Object value) {
        this.map.put(key, value);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        Iterator<Map.Entry<Object, Object>> it = this.map.entrySet().iterator();

        if (it.hasNext()) {
            sb.append("\n");
        }

        while (it.hasNext()) {
            sb.append("\t");

            Map.Entry<Object, Object> entry = it.next();

            Object key = entry.getKey();
            Object value = entry.getValue();

            if (key instanceof String) {
                sb.append("\"").append(key).append("\"");
            } else {
                sb.append(key.toString());
            }

            sb.append(": ").append(value instanceof Referable ref ? ref.getReference() : value);

            if (it.hasNext()) {
                sb.append(",");
            }

            sb.append("\n");
        }

        sb.append("}");

        return sb.toString();
    }
}
