package com.robertscerri;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Node {
    private List<Node> children = new ArrayList<Node>();
    private Node parent = null;

    protected String name;
    protected String type;
    protected Map<String, String> properties;

    public Node() {
        this.name = "";
        this.type = "";
        this.properties = new HashMap<String, String>();
    }

    public Node(String name, String type) {
        this.name = name;
        this.type = type;
        this.properties = new HashMap<String, String>();
    }

    public Node(String name, String type, Node parent) {
        this(name, type);
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        child.parent = this;
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
        if (this.parent != null) {
            this.parent.children.remove(this);
        }
        this.parent = parent;
        if (this.parent != null) {
            this.parent.children.add(this);
        }
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

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getPath() {
        if (this.parent == null) {
            return "";
        }

        String parentPath = this.parent.getPath();

        if (!parentPath.isEmpty()) {
            parentPath += "/";
        }

        return parentPath + this.parent.getName();
    }

    private String getHeader() {
        String header = String.format("[node name=\"%s\" type=\"%s\"", this.name, this.type);

        if (this.parent != null) {
            header += String.format(" parent=\"%s\"", this.getPath());
        }

        header += "]";

        return header;
    }

    public void printNode(PrintWriter scenePrintWriter) {
        //First print the header
        scenePrintWriter.println(this.getHeader());

        //Print each property
        for (Map.Entry<String, String> entry : this.properties.entrySet()) {
            scenePrintWriter.println(String.format("%s = %s", entry.getKey(), entry.getValue()));
        }

        //Skip a line
        scenePrintWriter.println();

        //Print all child nodes
        for(Node n : this.children) {
            n.printNode(scenePrintWriter);
        }
    }
}
