package com.robertscerri.jgdscene.resources;

import com.robertscerri.jgdscene.Referable;

import java.util.Random;

public abstract class Resource implements Referable {
    protected String id;

    protected String resourceName = null;
    protected String resourcePath = null;

    public Resource() {
        this.id = generateID();
    }

    public Resource(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    //ID generated is not guaranteed to be unique
    private String generateID() {
        StringBuilder suffix = new StringBuilder();
        final String CHAR_SET = "abcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < 5; i++) {
            char c = CHAR_SET.charAt(new Random().nextInt(CHAR_SET.length()));
            suffix.append(c);
        }

        return this.getClass().getSimpleName() + "_" + suffix;
    }

    private String getHeader() {
        StringBuilder builder = new StringBuilder("[");

        if (this instanceof SubResource) {
            builder.append("sub_resource");
        } else if (this instanceof ExtResource) {
            builder.append("ext_resource");
        }

        builder.append(" type=\"").append(this.getClass().getSimpleName()).append("\"");
        builder.append(" id=\"").append(this.id).append("\"");

        if (resourcePath != null) {
            builder.append(" path=\"").append(resourcePath).append("\"");
        }

        builder.append("]");

        return builder.toString();
    }

    @Override
    public String getReference() {
        StringBuilder builder = new StringBuilder();

        if (this instanceof SubResource) {
            builder.append("SubResource");
        } else if (this instanceof ExtResource) {
            builder.append("ExtResource");
        }

        builder.append("(\"").append(id).append("\")");

        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getHeader());

        if (resourceName != null) {
            builder.append("\n").append("resource_name = \"").append(this.resourceName).append("\"");
        }

        return builder.toString();
    }
}
