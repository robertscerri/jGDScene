package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.vectors.Vector2;
import org.w3c.dom.css.Rect;

public class Rect2 {
    public Vector2 position;
    public Vector2 size;

    public Rect2() {
        this.position = Vector2.ZERO;
        this.size = Vector2.ZERO;
    }

    public Rect2(Rect2 from) {
        this.position = new Vector2(from.position);
        this.size = new Vector2(from.size);
    }

    //TODO
//    public Rect2(Rect2i from) {
//        this.position = new Vector2(from.position);
//        this.size = new Vector2(from.size);
//    }

    public Rect2(Vector2 position, Vector2 size) {
        this.position = new Vector2(position);
        this.size = new Vector2(size);
    }

    public Rect2(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
    }

    public Rect2 abs() {
        return new Rect2(this.position.abs(), this.size.abs());
    }

    //TODO: Implement encloses/expand

    public float getArea() {
        return this.size.x * this.size.y;
    }

    public Vector2 getCenter() {
        //TODO
        return new Vector2();
    }
}
