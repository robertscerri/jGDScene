package com.robertscerri;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GDScene extends SceneEntry {
    protected Node rootNode;

    public GDScene() {
        super("gd_scene");

        this.setHeadingAttribute("loadSteps", 4);
        this.setHeadingAttribute("format", 3);

        this.rootNode = new Node("RootNode", "Node2D");
    }

    public GDScene(Node rootNode){
        this();
        this.rootNode = rootNode;
    }

    public GDScene(int loadSteps, int format) {
        super("gd_scene");

        this.setHeadingAttribute("loadSteps", loadSteps);
        this.setHeadingAttribute("format", format);

        this.rootNode = new Node("RootNode", "Node2D");
    }

    public GDScene(int loadSteps, int format, Node rootNode) {
        this(loadSteps, format);
        this.rootNode = rootNode;
    }

    public int getLoadSteps() {
        return (int) this.getHeadingAttribute("loadSteps");
    }

    public void setLoadSteps(int loadSteps) {
        this.setHeadingAttribute("loadSteps", loadSteps);
    }

    public int getFormat() {
        return (int) this.getHeadingAttribute("format");
    }

    public void setFormat(int format) {
        this.setHeadingAttribute("format", format);
    }

    public void writeToFile(String path) {
        try {
            File sceneFile = new File(path);
            sceneFile.createNewFile();

            FileWriter sceneFileWriter = new FileWriter(path);
            PrintWriter scenePrintWriter = new PrintWriter(sceneFileWriter);

            //Print scene file descriptor
            scenePrintWriter.println(this);

            //scenePrintWriter.println();

            //Print nodes
            scenePrintWriter.println(rootNode);
            //rootNode.printNode(scenePrintWriter);

            scenePrintWriter.close();
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}