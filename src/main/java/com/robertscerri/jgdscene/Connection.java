package com.robertscerri.jgdscene;

import com.robertscerri.jgdscene.nodes.Node;

public class Connection {
    public Node from;
    public Node to;

    public String signal;
    public String method;

    public Connection() {
        this.from = null;
        this.to = null;
        this.signal = "";
        this.method = "";
    }

    public Connection(Node from, Node to, String signal, String method) {
        this.from = from;
        this.to = to;
        this.signal = signal;
        this.method = method;
    }

    public String getHeader() {
        return "[connection" +
                " from=" + this.from.getNodePath() + "/" + this.from.name +
                " to=" + this.to.getNodePath() + "/" + this.to.name +
                "]";
    }

    @Override
    public String toString() {
        return this.getHeader() +
                "\nsignal = " + signal +
                "\nmethod = " + method;
    }
}
