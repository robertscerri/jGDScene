package com.robertscerri;

public class GDScene {
    protected int loadSteps;
    protected int format;

    protected Node rootNode;

    public GDScene() {
        this.loadSteps = 4;
        this.format = 3;
        this.rootNode = new Node("RootNode", "Node2D");
    }

    public GDScene(int loadSteps, int format) {
        this.loadSteps = loadSteps;
        this.format = format;
        this.rootNode = new Node("RootNode", "Node2D");
    }

    public GDScene(int loadSteps, int format, Node rootNode) {
        this(loadSteps, format);
        this.rootNode = rootNode;
    }

    public int getLoadSteps() {
        return loadSteps;
    }

    public void setLoadSteps(int loadSteps) {
        this.loadSteps = loadSteps;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public String getFileDescriptor() {
        return String.format("[gd_scene load_steps=%s format=%s]", this.loadSteps, this.format);
    }
}