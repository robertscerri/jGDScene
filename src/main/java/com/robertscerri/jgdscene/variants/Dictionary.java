package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.Referable;

import java.util.*;

public class Dictionary<K, V> extends Variant {
    private Map<K, V> map;

    public Dictionary() {
        this.map = new HashMap<>();
    }

    public Dictionary(Dictionary<K, V> dictionary) {
        this.map = new HashMap<>(dictionary.map);
    }

    public void clear() {
        this.map.clear();
    }

    public void add(K key, V value) {
        this.map.put(key, value);
    }

    public void erase(K key) {
        this.map.remove(key);
    }

    public V get(K key) {
        return this.map.get(key);
    }

    public boolean has(K key) {
        return this.map.containsKey(key);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<K> getKeySet() {
        return this.map.keySet();
    }

    public Collection<V> getValues() {
        return this.map.values();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        Iterator<Map.Entry<K, V>> it = this.map.entrySet().iterator();

        if (it.hasNext()) {
            sb.append("\n");
        }

        while (it.hasNext()) {
            sb.append("\t");

            Map.Entry<K, V> entry = it.next();

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
