package com.robertscerri.jgdscene.nodes;

import com.robertscerri.jgdscene.nodes.enums.PhysicsInterpolationMode;
import com.robertscerri.jgdscene.nodes.enums.ProcessMode;
import com.robertscerri.jgdscene.nodes.enums.ProcessThreadGroup;

import java.util.ArrayList;
import java.util.List;

public class Node {
    protected List<Node> children;
    protected Node parent;

    public String name;
    public PhysicsInterpolationMode physicsInterpolationMode = null;
    public ProcessMode processMode = null;
    public Integer processPhysicsPriority = null;
    public Integer processPriority = null;
    public ProcessThreadGroup processThreadGroup = null;
    public Boolean uniqueNameInOwner = null;

    public Node() {
        this.children = new ArrayList<>();
        this.parent = null;
        this.name = "";
    }

    public Node(String name) {
        this.children = new ArrayList<>();
        this.parent = null;
        this.name = name;
    }

    public Node(Node parent, String name) {
        this.children = new ArrayList<>();
        this.parent = parent;
        this.name = name;
    }

    public Node(Node from) {
        this.children = new ArrayList<>(from.children);
        this.parent = from.parent;
        this.name = from.name;
        this.physicsInterpolationMode = from.physicsInterpolationMode;
        this.processMode = from.processMode;
        this.processPhysicsPriority = from.processPhysicsPriority;
        this.processPriority = from.processPriority;
        this.processThreadGroup = from.processThreadGroup;
        this.uniqueNameInOwner = from.uniqueNameInOwner;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }

    public void addChildren(List<Node> children) {
        this.children.addAll(children);
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

    public String getNodePath() {
        if (this.parent == null) {
            return "";
        }

        String parentPath = this.parent.getNodePath();
        if (!parentPath.isEmpty()) {
            return parentPath + "/" + this.parent.name;
        } else {
            return "."; //If the path of the parent is empty, then we have reached the root node.
        }
    }

    private String getHeader() {
        StringBuilder builder = new StringBuilder("[node");

        builder.append(" name=\"").append(this.name).append("\"");
        builder.append(" type=\"").append(this.getClass().getSimpleName()).append("\"");

        if (this.parent != null) {
            builder.append(" parent=\"").append(this.getNodePath()).append("\"");
        }

        return builder.append("]").toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getHeader());

        if (physicsInterpolationMode != null) {
            builder.append("\n").append("physics_interpolation_mode = ").append(physicsInterpolationMode.ordinal());
        }

        if (processMode != null) {
            builder.append("\n").append("process_mode = ").append(processMode.ordinal());
        }

        if (processPhysicsPriority != null) {
            builder.append("\n").append("process_physics_priority = ").append(processPhysicsPriority);
        }

        if (processPriority != null) {
            builder.append("\n").append("process_priority = ").append(processPriority);
        }

        if (processThreadGroup != null) {
            builder.append("\n").append("process_thread_group = ").append(processThreadGroup.ordinal());
        }

        if (uniqueNameInOwner != null) {
            builder.append("\n").append("unique_name_in_owner = ").append(uniqueNameInOwner);
        }

        return builder.toString();
    }

    public String structureToString() {
        StringBuilder builder = new StringBuilder(this.toString());

        for (Node child : this.children) {
            builder.append("\n\n").append(child.structureToString());
        }

        return builder.toString();
    }
}
