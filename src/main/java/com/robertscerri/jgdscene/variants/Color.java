package com.robertscerri.jgdscene.variants;

import java.awt.color.ColorSpace;

public class Color {
    public int r;
    public int g;
    public int b;
    public int a;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    public String toString() {
        double r = this.r / 255.0;
        double g = this.g / 255.0;
        double b = this.b / 255.0;
        double a = this.a / 255.0;

        return "Color(%f, %f, %f, %f)".formatted(r, g, b, a);
    }
}
