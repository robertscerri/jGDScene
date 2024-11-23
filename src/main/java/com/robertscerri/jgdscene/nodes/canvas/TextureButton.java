package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.nodes.enums.StretchMode;
import com.robertscerri.jgdscene.resources.BitMap;
import com.robertscerri.jgdscene.resources.Texture2D;

public class TextureButton extends BaseButton {
    public Boolean flipH = null;
    public Boolean flipV = null;
    public Boolean ignoreTextureSize = null;
    public StretchMode stretchMode = null;
    public BitMap textureClickMask = null;
    public Texture2D textureDisabled = null;
    public Texture2D textureFocused = null;
    public Texture2D textureHover = null;
    public Texture2D textureNormal = null;
    public Texture2D texturePressed = null;

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

        if (textureClickMask != null) {
            builder.append("texture_click_mask = ").append(textureClickMask).append("\n");
        }

        if (textureDisabled != null) {
            builder.append("texture_disabled = ").append(textureDisabled).append("\n");
        }

        if (textureFocused != null) {
            builder.append("texture_focused = ").append(textureFocused).append("\n");
        }

        if (textureHover != null) {
            builder.append("texture_hover = ").append(textureHover).append("\n");
        }

        if (textureNormal != null) {
            builder.append("texture_normal = ").append(textureNormal).append("\n");
        }

        if (texturePressed != null) {
            builder.append("texture_pressed = ").append(texturePressed).append("\n");
        }

        return builder.toString();
    }
}
