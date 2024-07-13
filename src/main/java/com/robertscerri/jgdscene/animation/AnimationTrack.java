package com.robertscerri.jgdscene.animation;

import com.robertscerri.jgdscene.animation.enums.InterpolationType;
import com.robertscerri.jgdscene.animation.enums.TrackType;

public class AnimationTrack<T> {
    private TrackType trackType;
    private boolean imported;
    private boolean enabled;
    private String path;
    private InterpolationType interpolationType;
    private boolean loopWrap;
    private AnimationKeys<T> keys;

    public AnimationTrack(TrackType trackType, boolean imported, boolean enabled, String path, InterpolationType interpolationType, boolean loopWrap) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
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
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("tracks/%d/type = \"%s\"\n".formatted(index, this.trackType));
        stringBuilder.append("tracks/%d/imported = %s\n".formatted(index, this.imported));
        stringBuilder.append("tracks/%d/enabled = %s\n".formatted(index, this.enabled));
        stringBuilder.append("tracks/%d/path = NodePath(%s)\n".formatted(index, this.path));
        stringBuilder.append("tracks/%d/interp = %d\n".formatted(index, this.interpolationType.ordinal()));
        stringBuilder.append("tracks/%d/loop_wrap = %s\n".formatted(index, this.loopWrap));
        stringBuilder.append("tracks/%d/keys = %s\n".formatted(index, this.keys));

        return stringBuilder.toString();
    }

    public String toString() {
        return this.toString(0);
    }
}
