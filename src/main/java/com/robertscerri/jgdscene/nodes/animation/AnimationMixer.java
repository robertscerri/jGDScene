package com.robertscerri.jgdscene.nodes.animation;

import com.robertscerri.jgdscene.nodes.Node;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeDiscrete;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeMethod;
import com.robertscerri.jgdscene.nodes.enums.AnimationCallbackModeProcess;
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

    public AnimationMixer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (active != null) {
            builder.append("active = ").append(active).append("\n");
        }

        if (audioMaxPolyphony != null) {
            builder.append("audioMaxPolyphony = ").append(audioMaxPolyphony).append("\n");
        }

        if (callbackModeDiscrete != null) {
            builder.append("callbackModeDiscrete = ").append(callbackModeDiscrete.ordinal()).append("\n");
        }

        if (callbackModeMethod != null) {
            builder.append("callbackModeMethod = ").append(callbackModeMethod.ordinal()).append("\n");
        }

        if (callbackModeProcess != null) {
            builder.append("callbackModeProcess = ").append(callbackModeProcess.ordinal()).append("\n");
        }

        if (deterministic != null) {
            builder.append("deterministic = ").append(deterministic).append("\n");
        }

        if (resetOnSave != null) {
            builder.append("resetOnSave = ").append(resetOnSave).append("\n");
        }

        if (rootMotionTrack != null) {
            builder.append("rootMotionTrack = ").append(rootMotionTrack).append("\n");
        }

        if (rootNode != null) {
            builder.append("rootNode = ").append(rootNode).append("\n");
        }

        return builder.toString();
    }
}