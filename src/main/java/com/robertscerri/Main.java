package com.robertscerri;

public class Main {
    public static void main(String[] args) {
        Node rootNode = new Node("World", "Node2D");

        GDScene gdScene = new GDScene(rootNode);

        ExtResource birdScript = new ExtResource("Script", "res://Bird.gd");
        gdScene.addExtResource(birdScript);

        ExtResource birdTexture = new ExtResource("Texture2D", "res://Flappy Bird Assets/Player/StyleBird1/Bird1-2.png");
        gdScene.addExtResource(birdTexture);

        Node bird = new Node("Bird", "RigidBody2D");
        bird.setProperty("position", "Vector2(106, 192)");
        bird.setProperty("script", birdScript);
        rootNode.addChild(bird);

        SubResource circleShape2D1 = new SubResource("CircleShape2D");
        circleShape2D1.setProperty("radius", 7.0);
        gdScene.addSubResource(circleShape2D1);

        SubResource circleShape2D2 = new SubResource("CircleShape2D");
        circleShape2D2.setProperty("radius", 8.0);
        gdScene.addSubResource(circleShape2D2);

        SubResource atlasTexture = new SubResource("AtlasTexture");
        atlasTexture.setProperty("atlas", birdTexture);
        atlasTexture.setProperty("region", "Rect2(0, 0, 16, 16)");
        gdScene.addSubResource(atlasTexture);

        Node collisionShape2D = new Node("CollisionShape2D", "CollisionShape2D");
        collisionShape2D.setProperty("shape", circleShape2D1);
        collisionShape2D.setProperty("metadata/_edit_lock_", true);
        bird.addChild(collisionShape2D);

        Node area2D = new Node("Area2D", "Area2D");
        bird.addChild(area2D);

        Node collisionShape2D2 = new Node("CollisionShape2D", "CollisionShape2D");
        collisionShape2D2.setProperty("shape", circleShape2D2);
        area2D.addChild(collisionShape2D2);

        Connection connection1 = new Connection("body_entered", area2D, bird, "_on_area_2d_body_entered");
        gdScene.addConnection(connection1);

        gdScene.writeToFile("C:\\Users\\Robert\\Desktop\\scene.tscn");
    }
}