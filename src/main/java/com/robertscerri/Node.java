package com.robertscerri;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Node extends SceneEntryWithProps {
    private List<Node> children = new ArrayList<Node>();
    private Node parent = null;

    public Node() {
        super("node");

        this.setHeadingAttribute("name", "");
        this.setHeadingAttribute("type", "");
    }

    public Node(String name, String type) {
        super("node");

        this.setHeadingAttribute("name", name);
        this.setHeadingAttribute("type", type);
    }

    public Node(String name, String type, Node parent) {
        this(name, type);

        this.parent = parent;
        this.setHeadingAttribute("parent", getNodePath());
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        child.parent = this;
        child.setHeadingAttribute("parent", child.getNodePath());

        this.children.add(child);
    }

    public void addChildren(List<Node> children) {
        for (Node n : children) {
            this.addChild(n);
        }
    }

    public void removeChild(Node child) {
        this.children.remove(child);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        if (this.parent != null) {
            this.parent.removeChild(this);
        }

        parent.addChild(this);
    }

    public String getName() {
        return (String) this.getHeadingAttribute("name");
    }

    public void setName(String name) {
        this.setHeadingAttribute("name", name);
    }

    public String getType() {
        return (String) this.getHeadingAttribute("type");
    }

    public void setType(String type) {
        this.setHeadingAttribute("type", type);
    }

    public String getNodePath() {
        if (this.parent == null) {
            return "";
        }

        String parentPath = this.parent.getNodePath();

        if (!parentPath.isEmpty()) {
            parentPath += "/";
        }

        return parentPath + this.parent.getName();
    }

    public void printNode(PrintWriter scenePrintWriter) {
        //First print the header
        scenePrintWriter.println(this.getHeading());

        //Print each property
        for (Map.Entry<String, String> entry : this.properties.entrySet()) {
            scenePrintWriter.println(String.format("%s = %s", entry.getKey(), entry.getValue()));
        }

        //Skip a line
        scenePrintWriter.println();

        //Print all child nodes recursively
        for(Node n : this.children) {
            n.printNode(scenePrintWriter);
        }
    }
}
