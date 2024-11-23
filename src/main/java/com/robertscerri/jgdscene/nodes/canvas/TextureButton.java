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

    public TextureButton(TextureButton from) {
        super(from);
        this.flipH = from.flipH;
        this.flipV = from.flipV;
        this.ignoreTextureSize = from.ignoreTextureSize;
        this.stretchMode = from.stretchMode;
        this.textureClickMask = from.textureClickMask;
        this.textureDisabled = from.textureDisabled;
        this.textureFocused = from.textureFocused;
        this.textureHover = from.textureHover;
        this.textureNormal = from.textureNormal;
        this.texturePressed = from.texturePressed;
    }

    @Override
    public TextureButton clone() {
        TextureButton clone = (TextureButton) super.clone();

        clone.flipH = this.flipH;
        clone.flipV = this.flipV;
        clone.ignoreTextureSize = this.ignoreTextureSize;
        clone.stretchMode = this.stretchMode;
        clone.textureClickMask = this.textureClickMask;
        clone.textureDisabled = this.textureDisabled;
        clone.textureFocused = this.textureFocused;
        clone.textureHover = this.textureHover;
        clone.textureNormal = this.textureNormal;
        clone.texturePressed = this.texturePressed;

        return clone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (flipH != null) {
            builder.append("\n").append("flip_h = ").append(flipH);
        }

        if (flipV != null) {
            builder.append("\n").append("flip_v = ").append(flipV);
        }

        if (ignoreTextureSize != null) {
            builder.append("\n").append("ignore_texture_size = ").append(ignoreTextureSize);
        }

        if (stretchMode != null) {
            builder.append("\n").append("stretch_mode = ").append(stretchMode.ordinal());
        }

        if (textureClickMask != null) {
            builder.append("\n").append("texture_click_mask = ").append(textureClickMask.getReference());
        }

        if (textureDisabled != null) {
            builder.append("\n").append("texture_disabled = ").append(textureDisabled.getReference());
        }

        if (textureFocused != null) {
            builder.append("\n").append("texture_focused = ").append(textureFocused.getReference());
        }

        if (textureHover != null) {
            builder.append("\n").append("texture_hover = ").append(textureHover.getReference());
        }

        if (textureNormal != null) {
            builder.append("\n").append("texture_normal = ").append(textureNormal.getReference());
        }

        if (texturePressed != null) {
            builder.append("\n").append("texture_pressed = ").append(texturePressed.getReference());
        }

        return builder.toString();
    }
}
