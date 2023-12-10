package com.robertscerri;

import java.io.PrintWriter;
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

    public void printEntry(PrintWriter scenePrintWriter) {
        //Print the header
        scenePrintWriter.println(this.getHeading());

        //Print each property
        for (Map.Entry<String, String> entry : this.properties.entrySet()) {
            StringBuilder propertyString = new StringBuilder();

            propertyString.append(entry.getKey()).append(" = ").append(entry.getValue());

            scenePrintWriter.println(propertyString);
        }

        //Skip a line
        scenePrintWriter.println();
    }
}
