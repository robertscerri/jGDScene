package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.nodes.enums.*;
import com.robertscerri.jgdscene.variants.NodePath;
import com.robertscerri.jgdscene.variants.vectors.Vector2;

import java.math.BigDecimal;

public class Control extends CanvasItem {
    public Float anchorBottom = null;
    public Float anchorLeft = null;
    public Float anchorRight = null;
    public Float anchorTop = null;
    public Boolean clipContents = null;
    public Vector2 customMinimumSize = null;
    public FocusMode focusMode = null;
    public NodePath focusNeighborBottom = null;
    public NodePath focusNeighborLeft = null;
    public NodePath focusNeighborRight = null;
    public NodePath focusNeighborTop = null;
    public NodePath focusNext = null;
    public NodePath focusPrevious = null;
    public GrowDirection growHorizontal = null;
    public GrowDirection growVertical = null;
    public LayoutDirection layoutHorizontal = null;
    public Boolean localizeNumeralSystem = null;
    public CursorShape mouseDefaultCursorShape = null;
    public MouseFilter mouseFilter = null;
    public Boolean mouseForcePassScrollEvents = null;
    public Float offsetBottom = null;
    public Float offsetLeft = null;
    public Float offsetRight = null;
    public Float offsetTop = null;
    public Vector2 pivotOffset = null;
    public Vector2 position = null;
    public BigDecimal rotation = null;
    public Vector2 scale = null;
    public Vector2 size = null;
    public Float sizeFlagsStretchRatio = null;
    public String themeTypeVariation = null;
    public String tooltipText = null;

    public Control(String name) {
        super(name);
    }

    public Control(Control from) {
        super(from);
        this.anchorBottom = from.anchorBottom;
        this.anchorLeft = from.anchorLeft;
        this.anchorRight = from.anchorRight;
        this.anchorTop = from.anchorTop;
        this.clipContents = from.clipContents;
        this.customMinimumSize = from.customMinimumSize;
        this.focusMode = from.focusMode;
        this.focusNeighborBottom = from.focusNeighborBottom;
        this.focusNeighborLeft = from.focusNeighborLeft;
        this.focusNeighborRight = from.focusNeighborRight;
        this.focusNeighborTop = from.focusNeighborTop;
        this.focusNext = from.focusNext;
        this.focusPrevious = from.focusPrevious;
        this.growHorizontal = from.growHorizontal;
        this.growVertical = from.growVertical;
        this.layoutHorizontal = from.layoutHorizontal;
        this.localizeNumeralSystem = from.localizeNumeralSystem;
        this.mouseDefaultCursorShape = from.mouseDefaultCursorShape;
        this.mouseFilter = from.mouseFilter;
        this.mouseForcePassScrollEvents = from.mouseForcePassScrollEvents;
        this.offsetBottom = from.offsetBottom;
        this.offsetLeft = from.offsetLeft;
        this.offsetRight = from.offsetRight;
        this.offsetTop = from.offsetTop;
        this.pivotOffset = from.pivotOffset;
        this.position = from.position;
        this.rotation = from.rotation;
        this.scale = from.scale;
        this.size = from.size;
        this.sizeFlagsStretchRatio = from.sizeFlagsStretchRatio;
        this.themeTypeVariation = from.themeTypeVariation;
        this.tooltipText = from.tooltipText;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (anchorBottom != null) {
            builder.append("anchor_bottom = ").append(anchorBottom).append("\n");
        }

        if (anchorLeft != null) {
            builder.append("anchor_left = ").append(anchorLeft).append("\n");
        }

        if (anchorRight != null) {
            builder.append("anchor_right = ").append(anchorRight).append("\n");
        }

        if (anchorTop != null) {
            builder.append("anchor_top = ").append(anchorTop).append("\n");
        }

        if (clipContents != null) {
            builder.append("clip_contents = ").append(clipContents).append("\n");
        }

        if (customMinimumSize != null) {
            builder.append("custom_minimum_size = ").append(customMinimumSize).append("\n");
        }

        if (focusMode != null) {
            builder.append("focus_mode = ").append(focusMode.ordinal()).append("\n");
        }

        if (focusNeighborBottom != null) {
            builder.append("focus_neighbor_bottom = ").append(focusNeighborBottom).append("\n");
        }

        if (focusNeighborLeft != null) {
            builder.append("focus_neighbor_left = ").append(focusNeighborLeft).append("\n");
        }

        if (focusNeighborRight != null) {
            builder.append("focus_neighbor_right = ").append(focusNeighborRight).append("\n");
        }

        if (focusNeighborTop != null) {
            builder.append("focus_neighbor_top = ").append(focusNeighborTop).append("\n");
        }

        if (focusNext != null) {
            builder.append("focus_next = ").append(focusNext).append("\n");
        }

        if (focusPrevious != null) {
            builder.append("focus_previous = ").append(focusPrevious).append("\n");
        }

        if (growHorizontal != null) {
            builder.append("grow_horizontal = ").append(growHorizontal.ordinal()).append("\n");
        }

        if (growVertical != null) {
            builder.append("grow_vertical = ").append(growVertical.ordinal()).append("\n");
        }

        if (layoutHorizontal != null) {
            builder.append("layout_horizontal = ").append(layoutHorizontal.ordinal()).append("\n");
        }

        if (localizeNumeralSystem != null) {
            builder.append("localize_numeral_system = ").append(localizeNumeralSystem).append("\n");
        }

        if (mouseDefaultCursorShape != null) {
            builder.append("mouse_default_cursor_shape = ").append(mouseDefaultCursorShape.ordinal()).append("\n");
        }

        if (mouseFilter != null) {
            builder.append("mouse_filter = ").append(mouseFilter.ordinal()).append("\n");
        }

        if (mouseForcePassScrollEvents != null) {
            builder.append("mouse_force_pass_scroll_events = ").append(mouseForcePassScrollEvents).append("\n");
        }

        if (offsetBottom != null) {
            builder.append("offset_bottom = ").append(offsetBottom).append("\n");
        }

        if (offsetLeft != null) {
            builder.append("offset_left = ").append(offsetLeft).append("\n");
        }

        if (offsetRight != null) {
            builder.append("offset_right = ").append(offsetRight).append("\n");
        }

        if (offsetTop != null) {
            builder.append("offset_top = ").append(offsetTop).append("\n");
        }

        if (pivotOffset != null) {
            builder.append("pivot_offset = ").append(pivotOffset).append("\n");
        }

        if (position != null) {
            builder.append("position = ").append(position).append("\n");
        }

        if (rotation != null) {
            builder.append("rotation = ").append(rotation).append("\n");
        }

        if (scale != null) {
            builder.append("scale = ").append(scale).append("\n");
        }

        if (size != null) {
            builder.append("size = ").append(size).append("\n");
        }

        if (sizeFlagsStretchRatio != null) {
            builder.append("size_flags_stretch_ratio = ").append(sizeFlagsStretchRatio).append("\n");
        }

        if (themeTypeVariation != null) {
            builder.append("theme_type_variation = \"").append(themeTypeVariation).append("\"\n");
        }

        if (tooltipText != null) {
            builder.append("tooltip_text = \"").append(tooltipText).append("\"\n");
        }

        return builder.toString();
    }
}
