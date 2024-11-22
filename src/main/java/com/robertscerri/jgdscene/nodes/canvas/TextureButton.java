package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.nodes.enums.StretchMode;

public class TextureButton extends BaseButton {
    public Boolean flipH = null;
    public Boolean flipV = null;
    public Boolean ignoreTextureSize = null;
    public StretchMode stretchMode = null;

    public TextureButton(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (flipH != null) {
            builder.append("flip_h = ").append(flipH).append("\n");
        }

        if (flipV != null) {
            builder.append("flip_v = ").append(flipV).append("\n");
        }

        if (ignoreTextureSize != null) {
            builder.append("ignore_texture_size = ").append(ignoreTextureSize).append("\n");
        }

        if (stretchMode != null) {
            builder.append("stretch_mode = ").append(stretchMode.ordinal()).append("\n");
        }

        return builder.toString();
    }
}
