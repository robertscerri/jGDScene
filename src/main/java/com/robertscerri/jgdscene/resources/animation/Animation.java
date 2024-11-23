package com.robertscerri.jgdscene.resources.animation;

import com.robertscerri.jgdscene.resources.SubResource;

import java.util.ArrayList;
import java.util.List;

public class Animation extends SubResource {
    private float length;
    private List<AnimationTrack<?>> tracks;

    public Animation() {
        this.length = 1.0f;
        this.tracks = new ArrayList<>();
    }

    public Animation(String id) {
        super(id);
        this.length = 1.0f;
        this.tracks = new ArrayList<>();
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void addTrack(AnimationTrack<?> track) {
        this.tracks.add(track);
    }

    public void removeTrack(AnimationTrack<?> track) {
        this.tracks.remove(track);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (this.length != 1.0f) {
            builder.append("length = ").append(this.length).append("\n");
        }

        int trackIndex = 0;
        for (AnimationTrack<?> track : this.tracks) {
            builder.append(track.toString(trackIndex));
            trackIndex++;
        }

        return builder.toString();
    }
}
