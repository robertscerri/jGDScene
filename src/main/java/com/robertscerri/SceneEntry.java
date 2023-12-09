package com.robertscerri;

import java.util.LinkedHashMap;
import java.util.Map;

public class SceneEntry {
    private String resourceType;
    protected Map<String, Object> headingAttributes;

    public SceneEntry() {
        this.resourceType = "";
        this.headingAttributes = new LinkedHashMap<String, Object>();
    }

    public SceneEntry(String resourceType) {
        this.resourceType = resourceType;
        this.headingAttributes = new LinkedHashMap<String, Object>();
    }

    public Object getHeadingAttribute(String key) {
        return headingAttributes.get(key);
    }

    public void setHeadingAttribute(String key, Object value) {
        this.headingAttributes.put(key, value);
    }

    public Map<String, Object> getHeadingAttributes() {
        return headingAttributes;
    }

    protected String getHeading() {
        StringBuilder heading = new StringBuilder("[");

        heading.append(resourceType);

        for (Map.Entry<String, Object> attribute : headingAttributes.entrySet()) {
            Object value = attribute.getValue();
            if (!value.toString().isEmpty()) {
                heading.append(" ");

                boolean valueIsString = value instanceof String;

                heading.append(attribute.getKey())
                        .append("=")
                        .append(valueIsString ? "\"" : "")
                        .append(value.toString())
                        .append(valueIsString ? "\"" : "");
            }
        }

        heading.append("]");
        return heading.toString();
    }
}
