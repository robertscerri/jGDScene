package com.robertscerri;

public class SubResource extends Resource {
    public SubResource() {
        super("sub_resource");
    }

    public SubResource(String type) {
        super("sub_resource", type);
    }

    public SubResource(String type, String id) {
        super("sub_resource", type, id);
    }

    public String getReference() {
        return "SubResource(\"" + this.getId() + "\")";
    }
}
