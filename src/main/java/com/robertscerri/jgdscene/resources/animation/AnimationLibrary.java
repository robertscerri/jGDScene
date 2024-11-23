package com.robertscerri.jgdscene.resources.animation;

import com.robertscerri.jgdscene.resources.SubResource;
import com.robertscerri.jgdscene.variants.Dictionary;

public class AnimationLibrary extends SubResource {
    public Dictionary<String, Animation> _data;

    public AnimationLibrary() {
        this._data = new Dictionary<>();
    }

    public AnimationLibrary(String id) {
        super(id);
        this._data = new Dictionary<>();
    }

    @Override
    public String toString() {
        return super.toString() + "\n_data = " + _data;
    }
}
