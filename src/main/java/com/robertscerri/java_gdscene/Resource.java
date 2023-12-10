package com.robertscerri.java_gdscene;

import java.util.Random;

public abstract class Resource extends SceneEntryWithProps implements Referable {
    public Resource(String resourceType) {
        super(resourceType);

        this.setHeadingAttribute("type", "");
        this.setHeadingAttribute("id", "");
    }

    public Resource(String resourceType, String type) {
        super(resourceType);

        this.setHeadingAttribute("type", type);
        this.setHeadingAttribute("id", generateID(type));
    }

    public Resource(String resourceType, String type, String id) {
        super(resourceType);

        this.setHeadingAttribute("type", type);
        this.setHeadingAttribute("id", id);
    }

    public String getType() {
        return (String) this.getHeadingAttribute("type");
    }

    public void setType(String type) {
        this.setHeadingAttribute("type", type);
    }

    public String getId() {
        return (String) this.getHeadingAttribute("id");
    }

    public void setId(String id) {
        this.setHeadingAttribute("id", id);
    }

    //ID generated is not guaranteed to be unique
    private String generateID(String type) {
        StringBuilder suffix = new StringBuilder();
        final String CHAR_SET = "abcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < 5; i++) {
            char c = CHAR_SET.charAt(new Random().nextInt(CHAR_SET.length()));
            suffix.append(c);
        }

        return type + "_" + suffix;
    }

    public abstract String getReference();
}
