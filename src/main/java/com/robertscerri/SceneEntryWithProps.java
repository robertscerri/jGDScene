package com.robertscerri;

import java.util.LinkedHashMap;
import java.util.Map;

public class SceneEntryWithProps extends SceneEntry {
    protected Map<String, String> properties;

    public SceneEntryWithProps() {
        super();
        this.properties = new LinkedHashMap<String, String>();
    }

    public SceneEntryWithProps(String resourceType) {
        super(resourceType);
        this.properties = new LinkedHashMap<String, String>();
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
