package com.robertscerri.jgdscene.nodes.animation;

import com.robertscerri.jgdscene.nodes.enums.EaseType;
import com.robertscerri.jgdscene.nodes.enums.TransitionType;

public class AnimationPlayer extends AnimationMixer {
    public String autoplay = null;
    public String currentAnimation = null;
    public Boolean movieQuitOnFinish = null;
    public Boolean playbackAutoCapture = null;
    public Float playbackAutoCaptureDuration = null;
    public EaseType playbackAutoCaptureEaseType = null;
    public TransitionType playbackAutoCaptureTransitionType = null;
    public Float playbackDefaultBlendTime = null;
    public Float speedScale = null;

    public AnimationPlayer(String name) {
        super(name);
    }

    public AnimationPlayer(AnimationPlayer from) {
        super(from);
        this.autoplay = from.autoplay;
        this.currentAnimation = from.currentAnimation;
        this.movieQuitOnFinish = from.movieQuitOnFinish;
        this.playbackAutoCapture = from.playbackAutoCapture;
        this.playbackAutoCaptureDuration = from.playbackAutoCaptureDuration;
        this.playbackAutoCaptureEaseType = from.playbackAutoCaptureEaseType;
        this.playbackAutoCaptureTransitionType = from.playbackAutoCaptureTransitionType;
        this.playbackDefaultBlendTime = from.playbackDefaultBlendTime;
        this.speedScale = from.speedScale;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (autoplay != null) {
            builder.append("\n").append("autoplay = \"").append(autoplay).append("\"");
        }

        if (currentAnimation != null) {
            builder.append("\n").append("current_animation = \"").append(currentAnimation).append("\"");
        }

        if (movieQuitOnFinish != null) {
            builder.append("\n").append("movie_quit_on_finish = ").append(movieQuitOnFinish);
        }

        if (playbackAutoCapture != null) {
            builder.append("\n").append("playback_auto_capture = ").append(playbackAutoCapture);
        }

        if (playbackAutoCaptureDuration != null) {
            builder.append("\n").append("playback_auto_capture_duration = ").append(playbackAutoCaptureDuration);
        }

        if (playbackAutoCaptureEaseType != null) {
            builder.append("\n").append("playback_auto_capture_ease_type = ").append(playbackAutoCaptureEaseType);
        }

        if (playbackAutoCaptureTransitionType != null) {
            builder.append("\n").append("playback_auto_cature_transition_type = ").append(playbackAutoCaptureTransitionType);
        }

        if (playbackDefaultBlendTime != null) {
            builder.append("\n").append("playback_default_blend_time = ").append(playbackDefaultBlendTime);
        }

        if (speedScale != null) {
            builder.append("\n").append("speed_scale = ").append(speedScale);
        }

        return builder.toString();
    }
}
