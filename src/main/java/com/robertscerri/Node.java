package com.robertscerri;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children;
    private Node parent = null;

    protected String name;
    protected String type;

    public Node() {
        this.name = "";
        this.type = "";
    }

    public Node(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Node(String name, String type, Node parent) {
        this(name, type);
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(List<Node> children) {
        for (Node n : children) {
            this.addChild(n);
        }
    }

    public boolean removeChild(Node child) {
        return this.children.remove(child);
    }

    private void setParent(Node parent) {
        this.parent.children.remove(this);
        this.parent = parent;
        this.parent.children.add(this);
    }

    public Node getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader(String parent) {
        String header = String.format("[node name=\"%s\" type=\"%s\"", this.name, this.type);

        if (parent != null) {
            header += String.format(" parent=\"%s\"", parent);
        }

        header += "]";

        return header;
    }
}
