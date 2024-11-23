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
            builder.append("\n").append("action_mode = ").append(actionMode.ordinal());
        }

        if (buttonPressed != null) {
            builder.append("\n").append("button_pressed = ").append(buttonPressed);
        }

        if (disabled != null) {
            builder.append("\n").append("disabled = ").append(disabled);
        }

        if (keepPressedOutside != null) {
            builder.append("\n").append("keep_pressed_outside = ").append(keepPressedOutside);
        }

        if (shortcutFeedback != null) {
            builder.append("\n").append("shortcut_feedback = ").append(shortcutFeedback);
        }

        if (shortcutInTooltip != null) {
            builder.append("\n").append("shortcut_in_tooltip = ").append(shortcutInTooltip);
        }

        if (toggleMode != null) {
            builder.append("\n").append("toggle_mode = ").append(toggleMode);
        }

        return builder.toString();
    }
}
