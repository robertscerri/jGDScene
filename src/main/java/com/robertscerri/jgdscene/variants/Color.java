package com.robertscerri.jgdscene.variants;

public class Color {
    public float r;
    public float g;
    public float b;
    public float a;

    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color add(Color other) {
        return new Color(this.r + other.r, this.g + other.g, this.b + other.b, this.a + other.a);
    }

    public Color subtract(Color other) {
        return new Color(this.r - other.r, this.g - other.g, this.b - other.b, this.a - other.a);
    }

    public Color multiply(Color other) {
        return new Color(this.r * other.r, this.g * other.g, this.b * other.b, this.a * other.a);
    }

    public Color divide(Color other) {
        return new Color(this.r / other.r, this.g / other.g, this.b / other.b, this.a / other.a);
    }

    @Override
    public String toString() {
        float r = this.r / 255.0f;
        float g = this.g / 255.0f;
        float b = this.b / 255.0f;
        float a = this.a / 255.0f;

        return "Color(%f, %f, %f, %f)".formatted(r, g, b, a);
    }
}
