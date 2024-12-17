package com.robertscerri.jgdscene.resources.animation;

import com.robertscerri.jgdscene.resources.animation.enums.UpdateMode;
import com.robertscerri.jgdscene.variants.Dictionary;
import com.robertscerri.jgdscene.variants.packedarrays.PackedFloat32Array;

import java.util.ArrayList;
import java.util.List;

public class AnimationKeys<T> {
    PackedFloat32Array times;
    PackedFloat32Array transitions;
    UpdateMode updateMode;
    List<T> values;

    public AnimationKeys() {
        this.times = new PackedFloat32Array();
        this.transitions = new PackedFloat32Array();
        this.updateMode = UpdateMode.UPDATE_CONTINUOUS;
        this.values = new ArrayList<T>();
    }

    public AnimationKeys(PackedFloat32Array times, PackedFloat32Array transitions, UpdateMode updateMode, List<T> values) {
        this.times = times;
        this.transitions = transitions;
        this.updateMode = updateMode;
        this.values = values;
    }

    public PackedFloat32Array getTimes() {
        return times;
    }

    public void setTimes(PackedFloat32Array times) {
        this.times = times;
    }

    public PackedFloat32Array getTransitions() {
        return transitions;
    }

    public void setTransitions(PackedFloat32Array transitions) {
        this.transitions = transitions;
    }

    public UpdateMode getUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(UpdateMode updateMode) {
        this.updateMode = updateMode;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public void addKey(float time, float transition, T value) {
        this.times.append(time);
        this.transitions.append(transition);
        this.values.add(value);
    }

    @Override
    public String toString() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("times", this.times);
        dictionary.add("transitions", this.transitions);
        dictionary.add("update", this.updateMode.ordinal());
        dictionary.add("values", this.values);

        return dictionary.toString();
    }
}
