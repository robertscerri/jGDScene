package com.robertscerri.jgdscene;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GDScene extends SceneEntry {
    protected List<ExtResource> extResources = new ArrayList<ExtResource>();
    protected List<SubResource> subResources = new ArrayList<SubResource>();

    protected Node rootNode;

    protected List<Connection> connections = new ArrayList<Connection>();

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

    public List<ExtResource> getExtResources() {
        return this.extResources;
    }

    public void addExtResource(ExtResource extResource) {
        this.extResources.add(extResource);
    }

    public void removeExtResource(ExtResource extResource) {
        this.extResources.remove(extResource);
    }

    public List<SubResource> getSubResources() {
        return this.subResources;
    }

    public void addSubResource(SubResource subResource) {
        this.subResources.add(subResource);
    }

    public void removeSubResource(SubResource subResource) {
        this.subResources.remove(subResource);
    }

    public List<Connection> getConnections() {
        return this.connections;
    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }

    public void removeConnection(Connection connection) {
        this.connections.remove(connection);
    }

    public void writeToFile(String path) {
        try {
            File sceneFile = new File(path);
            sceneFile.createNewFile();

            FileWriter sceneFileWriter = new FileWriter(path);
            PrintWriter scenePrintWriter = new PrintWriter(sceneFileWriter);

            //Print scene file descriptor
            scenePrintWriter.println(this);

            //Print ExtResources
            for (ExtResource extResource : this.extResources) {
                scenePrintWriter.println(extResource);
            }

            //Print SubResources
            for (SubResource subResource : this.subResources) {
                scenePrintWriter.println(subResource);
            }

            //Print nodes
            scenePrintWriter.println(this.rootNode);

            //Print connections
            for (Connection connection : this.connections) {
                scenePrintWriter.println(connection);
            }

            scenePrintWriter.close();
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}