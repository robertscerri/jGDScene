package com.robertscerri.jgdscene.resources.animation;

import com.robertscerri.jgdscene.resources.animation.enums.InterpolationType;
import com.robertscerri.jgdscene.resources.animation.enums.TrackType;
import com.robertscerri.jgdscene.variants.NodePath;

public class AnimationTrack<T> {
    private TrackType trackType;
    private boolean imported;
    private boolean enabled;
    private NodePath path;
    private InterpolationType interpolationType;
    private boolean loopWrap;
    private AnimationKeys<T> keys;

    public AnimationTrack(TrackType trackType, boolean imported, boolean enabled, NodePath path, InterpolationType interpolationType, boolean loopWrap) {
        this.trackType = trackType;
        this.imported = imported;
        this.enabled = enabled;
        this.path = path;
        this.interpolationType = interpolationType;
        this.loopWrap = loopWrap;
        this.keys = new AnimationKeys<>();
    }

    public TrackType getTrackType() {
        return trackType;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public NodePath getPath() {
        return path;
    }

    public void setPath(NodePath path) {
        this.path = path;
    }

    public InterpolationType getInterpolationType() {
        return interpolationType;
    }

    public void setInterpolationType(InterpolationType interpolationType) {
        this.interpolationType = interpolationType;
    }

    public boolean isLoopWrap() {
        return loopWrap;
    }

    public void setLoopWrap(boolean loopWrap) {
        this.loopWrap = loopWrap;
    }

    public AnimationKeys<T> getKeys() {
        return keys;
    }

    public void setKeys(AnimationKeys<T> keys) {
        this.keys = keys;
    }

    public String toString(int index) {
        return "tracks/%d/type = \"%s\"\n".formatted(index, this.trackType) +
                "tracks/%d/imported = %s\n".formatted(index, this.imported) +
                "tracks/%d/enabled = %s\n".formatted(index, this.enabled) +
                "tracks/%d/path = %s\n".formatted(index, this.path) +
                "tracks/%d/interp = %d\n".formatted(index, this.interpolationType.ordinal()) +
                "tracks/%d/loop_wrap = %s\n".formatted(index, this.loopWrap) +
                "tracks/%d/keys = %s".formatted(index, this.keys);
    }

    public String toString() {
        return this.toString(0);
    }
}
