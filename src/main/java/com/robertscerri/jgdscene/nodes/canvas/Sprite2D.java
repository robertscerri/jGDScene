package com.robertscerri.jgdscene.nodes.canvas;

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

    public Sprite2D(Sprite2D from) {
        super(from);
        this.centered = from.centered;
        this.flipH = from.flipH;
        this.flipV = from.flipV;
        this.frame = from.frame;
        this.frameCoords = from.frameCoords == null ? null : new Vector2i(from.frameCoords);
        this.hFrames = from.hFrames;
        this.vFrames = from.vFrames;
        this.offset = from.offset == null ? null : new Vector2(from.offset);
        this.regionEnabled = from.regionEnabled;
        this.regionFilterClipEnabled = from.regionFilterClipEnabled;
        this.texture = from.texture;
    }

    @Override
    public Sprite2D clone() {
        Sprite2D clone = (Sprite2D) super.clone();

        clone.centered = this.centered;
        clone.flipH = this.flipH;
        clone.flipV = this.flipV;
        clone.frame = this.frame;
        clone.frameCoords = this.frameCoords == null ? null : new Vector2i(this.frameCoords);
        clone.hFrames = this.hFrames;
        clone.vFrames = this.vFrames;
        clone.offset = this.offset == null ? null : new Vector2(this.offset);
        clone.regionEnabled = this.regionEnabled;
        clone.regionFilterClipEnabled = this.regionFilterClipEnabled;
        clone.texture = this.texture;

        return clone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (centered != null) {
            builder.append("\n").append("centered = ").append(this.centered);
        }

        if (flipH != null) {
            builder.append("\n").append("flip_h = ").append(this.flipH);
        }

        if (flipV != null) {
            builder.append("\n").append("flip_v = ").append(this.flipV);
        }

        if (frame != null) {
            builder.append("\n").append("frame = ").append(this.frame);
        }

        if (frameCoords != null) {
            builder.append("\n").append("frame_coords = ").append(this.frameCoords);
        }

        if (hFrames != null) {
            builder.append("\n").append("hframes = ").append(this.hFrames);
        }

        if (vFrames != null) {
            builder.append("\n").append("vframes = ").append(this.vFrames);
        }

        if (offset != null) {
            builder.append("\n").append("offset = ").append(this.offset);
        }

        if (regionEnabled != null) {
            builder.append("\n").append("region_enabled = ").append(this.regionEnabled);
        }

        if (regionFilterClipEnabled != null) {
            builder.append("\n").append("region_filter_clip_enabled = ").append(this.regionFilterClipEnabled);
        }

        if (texture != null) {
            builder.append("\n").append("texture = ").append(this.texture.getReference());
        }

        return builder.toString();
    }
}
