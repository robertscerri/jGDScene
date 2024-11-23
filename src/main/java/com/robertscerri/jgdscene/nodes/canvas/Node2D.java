package com.robertscerri.jgdscene.nodes.canvas;

import com.robertscerri.jgdscene.variants.vectors.Vector2;

import java.math.BigDecimal;

public class Node2D extends CanvasItem {
    public Vector2 position = null;
    public BigDecimal rotation = null;
    public Vector2 scale = null;
    public Float skew = null;

    public Node2D(String name) {
        super(name);
    }

    public Node2D(Node2D from) {
        super(from);
        this.position = from.position;
        this.rotation = from.rotation;
        this.scale = from.scale;
        this.skew = from.skew;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        if (this.position != null) {
            builder.append("\n").append("position = ").append(position);
        }

        if (this.rotation != null) {
            builder.append("\n").append("rotation = ").append(rotation);
        }

        if (this.scale != null) {
            builder.append("\n").append("scale = ").append(scale);
        }

        if (this.skew != null) {
            builder.append("\n").append("skew = ").append(skew);
        }

        return builder.toString();
    }
}
