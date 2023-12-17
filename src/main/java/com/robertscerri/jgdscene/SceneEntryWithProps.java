package com.robertscerri.jgdscene;

import java.util.LinkedHashMap;
import java.util.Map;

public class SceneEntryWithProps extends SceneEntry {
    protected Map<String, Object> properties;

    public SceneEntryWithProps() {
        super();
        this.properties = new LinkedHashMap<String, Object>();
    }

    public SceneEntryWithProps(String resourceType) {
        super(resourceType);
        this.properties = new LinkedHashMap<String, Object>();
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        this.properties.put(key, value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        //Append the header
        str.append(this.getHeading());

        str.append("\n");

        //Print each property
        for (Map.Entry<String, Object> entry : this.properties.entrySet()) {
            Object value = entry.getValue();

            str.append(entry.getKey())
                    .append(" = ")
                    .append(value instanceof Referable ? ((Referable) value).getReference() : entry.getValue())
                    .append("\n");
        }

        return str.toString();
    }
}
