package com.robertscerri.java_gdscene;

public class Connection extends SceneEntry {
    private Node from;
    private Node to;

    public Connection() {
        super("connection");

        this.from = null;
        this.to = null;

        this.setHeadingAttribute("signal", "");
        this.setHeadingAttribute("method", "");
    }

    public Connection(String signal, Node from, Node to, String method) {
        super("connection");

        this.from = from;
        this.to = to;

        this.setHeadingAttribute("signal", signal);
        this.setHeadingAttribute("from", from.getNodePath() + "/" + from.getName());
        this.setHeadingAttribute("to", to.getNodePath() + "/" + to.getName());
        this.setHeadingAttribute("method", method);
    }

    public String getSignal() {
        return (String) this.getHeadingAttribute("signal");
    }

    public void setSignal(String signal) {
        this.setHeadingAttribute("signal", signal);
    }

    public Node getFrom() {
        return (Node) this.getHeadingAttribute("from");
    }

    public void setFrom(Node from) {
        this.setHeadingAttribute("from", from.getNodePath() + "/" + from.getName());
    }

    public Node getTo() {
        return (Node) this.getHeadingAttribute("to");
    }

    public void setTo(Node to) {
        this.setHeadingAttribute("to", to.getNodePath() + "/" + to.getName());
    }

    public String getMethod() {
        return (String) this.getHeadingAttribute("method");
    }

    public void setMethod(String method) {
        this.setHeadingAttribute("method", method);
    }
}
