package com.robertscerri;

import java.io.PrintWriter;
import java.util.ArrayList;
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
        return this.parent;
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
            return parentPath + "/" + this.parent.getName();
        } else {
            return "."; //If the path of the parent is empty, then we have reached the root node.
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(super.toString());

        //Print all child nodes recursively
        for(Node n : this.children) {
            str.append("\n");
            str.append(n.toString());
        }

        return str.toString();
    }
}
