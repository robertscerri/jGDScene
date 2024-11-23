package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.nodes.Node;
import com.robertscerri.jgdscene.nodes.enums.ClipChildrenMode;
import com.robertscerri.jgdscene.nodes.enums.TextureFilter;
import com.robertscerri.jgdscene.variants.Color;

public class CanvasItem extends Node {
    public ClipChildrenMode clipChildren = null;
    public Integer lightMask = null;
    public Color modulate = null;
    public Color selfModulate = null;
    public Boolean showBehindParent = null;
    public TextureFilter textureFilter = null;
    public TextureFilter textureRepeat = null;
    public Boolean topLevel = null;
    public Boolean useParentMaterial = null;
    public Integer visibilityLayer = null;
    public Boolean visible = null;
    public Boolean ySortEnabled = null;
    public Boolean zAsRelative = null;
    public Integer zIndex = null;

    public CanvasItem(String name) {
        super(name);
    }

    public CanvasItem(CanvasItem from) {
        super(from);
        this.clipChildren = from.clipChildren;
        this.lightMask = from.lightMask;
        this.modulate = from.modulate;
        this.selfModulate = from.selfModulate;
        this.showBehindParent = from.showBehindParent;
        this.textureFilter = from.textureFilter;
        this.textureRepeat = from.textureRepeat;
        this.topLevel = from.topLevel;
        this.useParentMaterial = from.useParentMaterial;
        this.visibilityLayer = from.visibilityLayer;
        this.visible = from.visible;
        this.ySortEnabled = from.ySortEnabled;
        this.zAsRelative = from.zAsRelative;
        this.zIndex = from.zIndex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (clipChildren != null) {
            builder.append("\n").append("clip_children = ").append(this.clipChildren.ordinal());
        }

        if (lightMask != null) {
            builder.append("\n").append("light_mask = ").append(this.lightMask);
        }

        if (modulate != null) {
            builder.append("\n").append("modulate = ").append(this.modulate);
        }

        if (selfModulate != null) {
            builder.append("\n").append("self_modulate = ").append(this.selfModulate);
        }

        if (showBehindParent != null) {
            builder.append("\n").append("show_behind_parent = ").append(this.showBehindParent);
        }

        if (textureFilter != null) {
            builder.append("\n").append("texture_filter = ").append(this.textureFilter.ordinal());
        }

        if (textureRepeat != null) {
            builder.append("\n").append("texture_repeat = ").append(this.textureRepeat.ordinal());
        }

        if (topLevel != null) {
            builder.append("\n").append("top_level = ").append(this.topLevel);
        }

        if (useParentMaterial != null) {
            builder.append("\n").append("use_parent_material = ").append(this.useParentMaterial);
        }

        if (visibilityLayer != null) {
            builder.append("\n").append("visibility_layer = ").append(this.visibilityLayer);
        }

        if (visible != null) {
            builder.append("\n").append("visible = ").append(this.visible);
        }

        if (ySortEnabled != null) {
            builder.append("\n").append("y_sort_enabled = ").append(this.ySortEnabled);
        }

        if (zAsRelative != null) {
            builder.append("\n").append("z_as_relative = ").append(this.zAsRelative);
        }

        if (zIndex != null) {
            builder.append("\n").append("z_index = ").append(this.zIndex);
        }

        return builder.toString();
    }
}
