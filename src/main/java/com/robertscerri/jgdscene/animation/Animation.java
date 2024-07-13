package com.robertscerri.jgdscene.animation;

import com.robertscerri.jgdscene.SubResource;

import java.util.ArrayList;

public class Animation extends SubResource {
    private ArrayList<AnimationTrack> tracks;

    public Animation() {
        super("Animation");

        this.setProperty("resource_name", "\"\"");
        this.setProperty("length", 0);

        this.tracks = new ArrayList<AnimationTrack>();
    }

    public Animation(String id) {
        super("Animation", id);

        this.tracks = new ArrayList<AnimationTrack>();
    }

    public Animation(String resourceName, float length) {
        super("Animation");

        this.setProperty("resource_name", "\"" + resourceName + "\"");
        this.setProperty("length", length);

        this.tracks = new ArrayList<AnimationTrack>();
    }

    public Animation(String resourceName, float length, String id) {
        super("Animation", id);

        this.setProperty("resource_name", "\"" + resourceName + "\"");
        this.setProperty("length", length);

        this.tracks = new ArrayList<AnimationTrack>();
    }

    public String getResourceName() {
        return (String) this.getProperty("resource_name");
    }

    public float getLength() {
        return (float) this.getProperty("length");
    }

    public void setResourceName(String resourceName) {
        this.setProperty("resource_name", "\"" + resourceName + "\"");
    }

    public void setLength(float length) {
        this.setProperty("length", length);
    }

    public ArrayList<AnimationTrack> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<AnimationTrack> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(AnimationTrack track) {
        this.tracks.add(track);
    }

    public AnimationTrack getTrack(int index) {
        return this.tracks.get(index);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());

        for (int i = 0; i < this.tracks.size(); i++) {
            AnimationTrack track = this.tracks.get(i);
            stringBuilder.append(track.toString(i));
        }

        return stringBuilder.toString();
    }
}
