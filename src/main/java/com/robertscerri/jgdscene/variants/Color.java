package com.robertscerri.jgdscene.variants;

import java.awt.color.ColorSpace;

public class Color extends java.awt.Color {
    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Color(int rgb) {
        super(rgb);
    }

    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Color(float r, float g, float b) {
        super(r, g, b);
    }

    public Color(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Color(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    @Override
    public String toString() {
        double r = this.getRed() / 255.0;
        double g = this.getGreen() / 255.0;
        double b = this.getBlue() / 255.0;
        double a = this.getAlpha() / 255.0;

        return "Color(%f, %f, %f, %f)".formatted(r, g, b, a);
    }
}
