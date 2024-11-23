package com.robertscerri.jgdscene.nodes.animation;

import com.robertscerri.jgdscene.nodes.Node;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeDiscrete;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeMethod;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeProcess;
import com.robertscerri.jgdscene.variants.Dictionary;
import com.robertscerri.jgdscene.variants.NodePath;

public class AnimationMixer extends Node {
    public Boolean active = null;
    public Integer audioMaxPolyphony = null;
    public AnimationCallbackModeDiscrete callbackModeDiscrete = null;
    public AnimationCallbackModeMethod callbackModeMethod = null;
    public AnimationCallbackModeProcess callbackModeProcess = null;
    public Boolean deterministic = null;
    public Boolean resetOnSave = null;
    public NodePath rootMotionTrack = null;
    public NodePath rootNode = null;
    public Dictionary libraries = null;

    public AnimationMixer(String name) {
        super(name);
    }

    public AnimationMixer(AnimationMixer from) {
        super(from);
        this.active = from.active;
        this.audioMaxPolyphony = from.audioMaxPolyphony;
        this.callbackModeDiscrete = from.callbackModeDiscrete;
        this.callbackModeMethod = from.callbackModeMethod;
        this.callbackModeProcess = from.callbackModeProcess;
        this.deterministic = from.deterministic;
        this.resetOnSave = from.resetOnSave;
        this.rootMotionTrack = from.rootMotionTrack == null ? null : new NodePath(from.rootMotionTrack);
        this.rootNode = from.rootNode == null ? null : new NodePath(from.rootNode);
        this.libraries = from.libraries == null ? null : new Dictionary(from.libraries);
    }

    @Override
    public AnimationMixer clone() {
        AnimationMixer clone = (AnimationMixer) super.clone();

        clone.active = this.active;
        clone.audioMaxPolyphony = this.audioMaxPolyphony;
        clone.callbackModeDiscrete = this.callbackModeDiscrete;
        clone.callbackModeMethod = this.callbackModeMethod;
        clone.callbackModeProcess = this.callbackModeProcess;
        clone.deterministic = this.deterministic;
        clone.resetOnSave = this.resetOnSave;
        clone.rootMotionTrack = this.rootMotionTrack == null ? null : new NodePath(this.rootMotionTrack);
        clone.rootNode = this.rootNode == null ? null : new NodePath(this.rootNode);
        clone.libraries = this.libraries == null ? null : new Dictionary(this.libraries);

        return clone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (active != null) {
            builder.append("\n").append("active = ").append(active);
        }

        if (audioMaxPolyphony != null) {
            builder.append("\n").append("audioMaxPolyphony = ").append(audioMaxPolyphony);
        }

        if (callbackModeDiscrete != null) {
            builder.append("\n").append("callbackModeDiscrete = ").append(callbackModeDiscrete.ordinal());
        }

        if (callbackModeMethod != null) {
            builder.append("\n").append("callbackModeMethod = ").append(callbackModeMethod.ordinal());
        }

        if (callbackModeProcess != null) {
            builder.append("\n").append("callbackModeProcess = ").append(callbackModeProcess.ordinal());
        }

        if (deterministic != null) {
            builder.append("\n").append("deterministic = ").append(deterministic);
        }

        if (resetOnSave != null) {
            builder.append("\n").append("resetOnSave = ").append(resetOnSave);
        }

        if (rootMotionTrack != null) {
            builder.append("\n").append("rootMotionTrack = ").append(rootMotionTrack);
        }

        if (rootNode != null) {
            builder.append("\n").append("rootNode = ").append(rootNode);
        }

        if (libraries != null) {
            builder.append("\n").append("libraries = ").append(libraries);
        }

        return builder.toString();
    }
}
