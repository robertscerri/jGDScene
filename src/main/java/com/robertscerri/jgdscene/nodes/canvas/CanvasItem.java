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
            builder.append("clip_children = ").append(this.clipChildren.ordinal()).append("\n");
        }

        if (lightMask != null) {
            builder.append("light_mask = ").append(this.lightMask).append("\n");
        }

        if (modulate != null) {
            builder.append("modulate = ").append(this.modulate).append("\n");
        }

        if (selfModulate != null) {
            builder.append("self_modulate = ").append(this.selfModulate).append("\n");
        }

        if (showBehindParent != null) {
            builder.append("show_behind_parent = ").append(this.showBehindParent).append("\n");
        }

        if (textureFilter != null) {
            builder.append("texture_filter = ").append(this.textureFilter.ordinal()).append("\n");
        }

        if (textureRepeat != null) {
            builder.append("texture_repeat = ").append(this.textureRepeat.ordinal()).append("\n");
        }

        if (topLevel != null) {
            builder.append("top_level = ").append(this.topLevel).append("\n");
        }

        if (useParentMaterial != null) {
            builder.append("use_parent_material = ").append(this.useParentMaterial).append("\n");
        }

        if (visibilityLayer != null) {
            builder.append("visibility_layer = ").append(this.visibilityLayer).append("\n");
        }

        if (visible != null) {
            builder.append("visible = ").append(this.visible).append("\n");
        }

        if (ySortEnabled != null) {
            builder.append("y_sort_enabled = ").append(this.ySortEnabled).append("\n");
        }

        if (zAsRelative != null) {
            builder.append("z_as_relative = ").append(this.zAsRelative).append("\n");
        }

        if (zIndex != null) {
            builder.append("z_index = ").append(this.zIndex).append("\n");
        }

        return builder.toString();
    }
}
