package com.robertscerri.jgdscene.nodes;

import com.robertscerri.jgdscene.resources.Texture2D;
import com.robertscerri.jgdscene.variants.vectors.Vector2;
import com.robertscerri.jgdscene.variants.vectors.Vector2i;

public class Sprite2D extends Node2D {
    public Boolean centered = null;
    public Boolean flipH = null;
    public Boolean flipV = null;
    public Integer frame = null;
    public Vector2i frameCoords = null;
    public Integer hFrames = null;
    public Integer vFrames = null;
    public Vector2 offset = null;
    public Boolean regionEnabled = null;
    public Boolean regionFilterClipEnabled = null;
    public Texture2D texture = null;

    public Sprite2D(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (centered != null) {
            builder.append("centered = ").append(this.centered).append("\n");
        }

        if (flipH != null) {
            builder.append("flip_h = ").append(this.flipH).append("\n");
        }

        if (flipV != null) {
            builder.append("flip_v = ").append(this.flipV).append("\n");
        }

        if (frame != null) {
            builder.append("frame = ").append(this.frame).append("\n");
        }

        if (frameCoords != null) {
            builder.append("frame_coords = ").append(this.frameCoords).append("\n");
        }

        if (hFrames != null) {
            builder.append("hframes = ").append(this.hFrames).append("\n");
        }

        if (vFrames != null) {
            builder.append("vframes = ").append(this.vFrames).append("\n");
        }

        if (offset != null) {
            builder.append("offset = ").append(this.offset).append("\n");
        }

        if (regionEnabled != null) {
            builder.append("region_enabled = ").append(this.regionEnabled).append("\n");
        }

        if (regionFilterClipEnabled != null) {
            builder.append("region_filter_clip_enabled = ").append(this.regionFilterClipEnabled).append("\n");
        }

        if (texture != null) {
            builder.append("texture = ").append(this.texture).append("\n");
        }

        return builder.toString();
    }
}
