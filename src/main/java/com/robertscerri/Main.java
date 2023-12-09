package com.robertscerri;

public class Main {
    public static void main(String[] args) {
        Node rootNode = new Node("World", "Node2D");

        GDScene gdScene = new GDScene(rootNode);

        Node bird = new Node("Bird", "RigidBody2D");
        bird.setProperty("position", "Vector2(106, 192)");
        rootNode.addChild(bird);

        Node collisionShape2D = new Node("CollisionShape2D", "CollisionShape2D");
        collisionShape2D.setProperty("shape", "SubResource(\"CircleShape2D_mta1t\")");
        collisionShape2D.setProperty("metadata/_edit_lock_", "true");
        bird.addChild(collisionShape2D);

        Node area2D = new Node("Area2D", "Area2D");
        bird.addChild(area2D);

        Node collisionShape2D2 = new Node("CollisionShape2D", "CollisionShape2D");
        collisionShape2D2.setProperty("shape", "SubResource(\"CircleShape2D_ixabh\")");
        area2D.addChild(collisionShape2D2);

        gdScene.writeToFile("C:\\Users\\Robert\\Desktop\\scene.tscn");
    }
}
