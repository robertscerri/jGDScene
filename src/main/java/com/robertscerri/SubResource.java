package com.robertscerri;

import java.util.Random;

public class SubResource extends SceneEntryWithProps {
    public SubResource() {
        super("sub_resource");

        this.setHeadingAttribute("type", "");
        this.setHeadingAttribute("id", "");
    }

    public SubResource(String type) {
        super("sub_resource");

        this.setHeadingAttribute("type", type);
        this.setHeadingAttribute("id", generateID(type));
    }

    public SubResource(String type, String id) {
        super("sub_resource");

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
        final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < 5; i++) {
            char c = CHAR_SET.charAt(new Random().nextInt(CHAR_SET.length()));
            suffix.append(c);
        }

        return type + "_" + suffix;
    }
}
