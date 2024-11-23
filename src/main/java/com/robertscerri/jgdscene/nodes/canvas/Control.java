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
            builder.append("\n").append("anchor_bottom = ").append(anchorBottom);
        }

        if (anchorLeft != null) {
            builder.append("\n").append("anchor_left = ").append(anchorLeft);
        }

        if (anchorRight != null) {
            builder.append("\n").append("anchor_right = ").append(anchorRight);
        }

        if (anchorTop != null) {
            builder.append("\n").append("anchor_top = ").append(anchorTop);
        }

        if (clipContents != null) {
            builder.append("\n").append("clip_contents = ").append(clipContents);
        }

        if (customMinimumSize != null) {
            builder.append("\n").append("custom_minimum_size = ").append(customMinimumSize);
        }

        if (focusMode != null) {
            builder.append("\n").append("focus_mode = ").append(focusMode.ordinal());
        }

        if (focusNeighborBottom != null) {
            builder.append("\n").append("focus_neighbor_bottom = ").append(focusNeighborBottom);
        }

        if (focusNeighborLeft != null) {
            builder.append("\n").append("focus_neighbor_left = ").append(focusNeighborLeft);
        }

        if (focusNeighborRight != null) {
            builder.append("\n").append("focus_neighbor_right = ").append(focusNeighborRight);
        }

        if (focusNeighborTop != null) {
            builder.append("\n").append("focus_neighbor_top = ").append(focusNeighborTop);
        }

        if (focusNext != null) {
            builder.append("\n").append("focus_next = ").append(focusNext);
        }

        if (focusPrevious != null) {
            builder.append("\n").append("focus_previous = ").append(focusPrevious);
        }

        if (growHorizontal != null) {
            builder.append("\n").append("grow_horizontal = ").append(growHorizontal.ordinal());
        }

        if (growVertical != null) {
            builder.append("\n").append("grow_vertical = ").append(growVertical.ordinal());
        }

        if (layoutHorizontal != null) {
            builder.append("\n").append("layout_horizontal = ").append(layoutHorizontal.ordinal());
        }

        if (localizeNumeralSystem != null) {
            builder.append("\n").append("localize_numeral_system = ").append(localizeNumeralSystem);
        }

        if (mouseDefaultCursorShape != null) {
            builder.append("\n").append("mouse_default_cursor_shape = ").append(mouseDefaultCursorShape.ordinal());
        }

        if (mouseFilter != null) {
            builder.append("\n").append("mouse_filter = ").append(mouseFilter.ordinal());
        }

        if (mouseForcePassScrollEvents != null) {
            builder.append("\n").append("mouse_force_pass_scroll_events = ").append(mouseForcePassScrollEvents);
        }

        if (offsetBottom != null) {
            builder.append("\n").append("offset_bottom = ").append(offsetBottom);
        }

        if (offsetLeft != null) {
            builder.append("\n").append("offset_left = ").append(offsetLeft);
        }

        if (offsetRight != null) {
            builder.append("\n").append("offset_right = ").append(offsetRight);
        }

        if (offsetTop != null) {
            builder.append("\n").append("offset_top = ").append(offsetTop);
        }

        if (pivotOffset != null) {
            builder.append("\n").append("pivot_offset = ").append(pivotOffset);
        }

        if (position != null) {
            builder.append("\n").append("position = ").append(position);
        }

        if (rotation != null) {
            builder.append("\n").append("rotation = ").append(rotation);
        }

        if (scale != null) {
            builder.append("\n").append("scale = ").append(scale);
        }

        if (size != null) {
            builder.append("\n").append("size = ").append(size);
        }

        if (sizeFlagsStretchRatio != null) {
            builder.append("\n").append("size_flags_stretch_ratio = ").append(sizeFlagsStretchRatio);
        }

        if (themeTypeVariation != null) {
            builder.append("\n").append("theme_type_variation = \"").append(themeTypeVariation).append("\"");
        }

        if (tooltipText != null) {
            builder.append("\n").append("tooltip_text = \"").append(tooltipText).append("\"");
        }

        return builder.toString();
    }
}
