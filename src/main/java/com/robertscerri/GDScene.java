package com.robertscerri;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    public GDScene(Node rootNode){
        this();
        this.rootNode = rootNode;
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

    private String getFileDescriptor() {
        return String.format("[gd_scene load_steps=%s format=%s]", this.loadSteps, this.format);
    }

    public void writeToFile(String path) {
        try {
            File sceneFile = new File(path);
            sceneFile.createNewFile();

            FileWriter sceneFileWriter = new FileWriter(path);
            PrintWriter scenePrintWriter = new PrintWriter(sceneFileWriter);

            //Print scene file descriptor
            scenePrintWriter.println(this.getFileDescriptor());

            scenePrintWriter.println();

            //Print nodes
            rootNode.printNode(scenePrintWriter);

            scenePrintWriter.close();
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}