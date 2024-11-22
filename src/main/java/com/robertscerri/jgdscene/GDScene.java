package com.robertscerri.jgdscene;

import com.robertscerri.jgdscene.nodes.Node;
import com.robertscerri.jgdscene.resources.ExtResource;
import com.robertscerri.jgdscene.resources.SubResource;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GDScene {
    private int loadSteps;
    private int format;

    private List<ExtResource> extResources;
    private List<SubResource> subResources;

    private Node rootNode;

    private List<Connection> connections;

    public GDScene() {
        this.loadSteps = 4;
        this.format = 3;
        this.extResources = new ArrayList<>();
        this.subResources = new ArrayList<>();
        this.rootNode = null;
        this.connections = new ArrayList<>();
    }

    public GDScene(Node rootNode) {
        this.loadSteps = 4;
        this.format = 3;
        this.rootNode = rootNode;
        this.extResources = new ArrayList<>();
        this.subResources = new ArrayList<>();
        this.rootNode = null;
        this.connections = new ArrayList<>();
    }

    public GDScene(Node rootNode, List<ExtResource> extResources, List<SubResource> subResources, List<Connection> connections) {
        this.loadSteps = 4;
        this.format = 3;
        this.rootNode = rootNode;
        this.extResources = extResources;
        this.subResources = subResources;
        this.connections = connections;
    }

    public GDScene(int loadSteps, int format, Node rootNode, List<ExtResource> extResources, List<SubResource> subResources, List<Connection> connections) {
        this.loadSteps = loadSteps;
        this.format = format;
        this.rootNode = rootNode;
        this.extResources = extResources;
        this.subResources = subResources;
        this.connections = connections;
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

    public List<ExtResource> getExtResources() {
        return extResources;
    }

    public void setExtResources(List<ExtResource> extResources) {
        this.extResources = extResources;
    }

    public void addExtResource(ExtResource extResource) {
        this.extResources.add(extResource);
    }

    public void removeExtResource(ExtResource extResource) {
        this.extResources.remove(extResource);
    }

    public List<SubResource> getSubResources() {
        return subResources;
    }

    public void setSubResources(List<SubResource> subResources) {
        this.subResources = subResources;
    }

    public void addSubResource(SubResource subResource) {
        this.subResources.add(subResource);
    }

    public void removeSubResource(SubResource subResource) {
        this.subResources.remove(subResource);
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }

    public void removeConnection(Connection connection) {
        this.connections.remove(connection);
    }

    private String getHeader() {
        return "[gd_scene loadSteps=" + this.loadSteps + " format=" + this.format + "]\n";
    }

    public void writeToFile(String path) {
        try {
            File sceneFile = new File(path);
            sceneFile.createNewFile();

            FileWriter sceneFileWriter = new FileWriter(path);
            PrintWriter scenePrintWriter = new PrintWriter(sceneFileWriter);

            //Print scene file descriptor
            scenePrintWriter.println(this.getHeader());

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