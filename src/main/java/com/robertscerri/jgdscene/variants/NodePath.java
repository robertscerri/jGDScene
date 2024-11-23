package com.robertscerri.jgdscene.variants;

public class NodePath extends Variant {
    private String path;

    public NodePath() {
        this.path = "";
    }

    public NodePath(NodePath from) {
        this.path = from.path;
    }

    public NodePath(String from) {
        this.path = from;
    }

    public void append(NodePath nodePath) {
        this.path += nodePath.path;
    }

    public void append(String path) {
        this.path += path;
    }

    public void push(String name) {
        this.path += "/" + name;
    }

    public void pushProperty(String property) {
        this.path += ":" + property;
    }

    public void pop() {
        String[] names = this.path.split("/");
        String[] newNames = new String[names.length - 1];

        System.arraycopy(names, 0, newNames, 0, names.length - 1);

        this.path = String.join("/", newNames);
    }

    public boolean isAbsolute() {
        if (this.path.isEmpty()) {
            return false;
        }

        return this.path.charAt(0) == '/';
    }

    public boolean isEmpty() {
        return this.path.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodePath nodePath) {
            return this.path.equals(nodePath.path);
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString("\"" + this.path + "\"");
    }
}
