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
        return "[node name=\"" + this.name + "\"" +
                " type=\"" + this.getClass().getSimpleName() + "\"" +
                " parent=\"" + this.getNodePath() + "\"" +
                "]\n";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getHeader());

        if (physicsInterpolationMode != null) {
            builder.append("physics_interpolation_mode = ").append(physicsInterpolationMode.ordinal()).append("\n");
        }

        if (processMode != null) {
            builder.append("process_mode = ").append(processMode.ordinal()).append("\n");
        }

        if (processPhysicsPriority != null) {
            builder.append("process_physics_priority = ").append(processPhysicsPriority).append("\n");
        }

        if (processPriority != null) {
            builder.append("process_priority = ").append(processPriority).append("\n");
        }

        if (processThreadGroup != null) {
            builder.append("process_thread_group = ").append(processThreadGroup.ordinal()).append("\n");
        }

        if (uniqueNameInOwner != null) {
            builder.append("unique_name_in_owner = ").append(uniqueNameInOwner).append("\n");
        }

        return builder.toString();
    }
}
