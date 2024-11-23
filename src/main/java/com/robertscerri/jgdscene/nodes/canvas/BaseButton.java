package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.nodes.enums.ActionMode;

public abstract class BaseButton extends Control {
    public ActionMode actionMode = null;
    public Boolean buttonPressed = null;
    public Boolean disabled = null;
    public Boolean keepPressedOutside = null;
    public Boolean shortcutFeedback = null;
    public Boolean shortcutInTooltip = null;
    public Boolean toggleMode = null;

    public BaseButton(String name) {
        super(name);
    }

    public BaseButton(BaseButton from) {
        super(from);
        this.actionMode = from.actionMode;
        this.buttonPressed = from.buttonPressed;
        this.disabled = from.disabled;
        this.keepPressedOutside = from.keepPressedOutside;
        this.shortcutFeedback = from.shortcutFeedback;
        this.shortcutInTooltip = from.shortcutInTooltip;
        this.toggleMode = from.toggleMode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (actionMode != null) {
            builder.append("action_mode = ").append(actionMode.ordinal()).append("\n");
        }

        if (buttonPressed != null) {
            builder.append("button_pressed = ").append(buttonPressed).append("\n");
        }

        if (disabled != null) {
            builder.append("disabled = ").append(disabled).append("\n");
        }

        if (keepPressedOutside != null) {
            builder.append("keep_pressed_outside = ").append(keepPressedOutside).append("\n");
        }

        if (shortcutFeedback != null) {
            builder.append("shortcut_feedback = ").append(shortcutFeedback).append("\n");
        }

        if (shortcutInTooltip != null) {
            builder.append("shortcut_in_tooltip = ").append(shortcutInTooltip).append("\n");
        }

        if (toggleMode != null) {
            builder.append("toggle_mode = ").append(toggleMode).append("\n");
        }

        return builder.toString();
    }
}
