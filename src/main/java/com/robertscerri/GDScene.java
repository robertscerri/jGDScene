package com.robertscerri;

public class GDScene {
    protected int loadSteps;
    protected int format;

    public GDScene() {
        this.loadSteps = 4;
        this.format = 3;
    }

    public GDScene(int loadSteps, int format) {
        this.loadSteps = loadSteps;
        this.format = format;
    }

    public String getFileDescriptor() {
        return String.format("[gd_scene load_steps=%s format=%s]", this.loadSteps, this.format);
    }
}