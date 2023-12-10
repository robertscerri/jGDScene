package com.robertscerri.java_gdscene;

public class ExtResource extends Resource {
    public ExtResource() {
        super("ext_resource");
    }

    public ExtResource(String type, String path) {
        super("ext_resource", type);

        this.setHeadingAttribute("path", path);
    }

    public ExtResource(String type, String path, String id) {
        super("ext_resource", type, id);

        this.setHeadingAttribute("path", path);
    }

    public String getReference() {
        return "ExtResource(\"" + this.getId() + "\")";
    }
}
