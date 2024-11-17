package com.robertscerri.jgdscene.animation;

import com.robertscerri.jgdscene.animation.enums.UpdateMode;
import com.robertscerri.jgdscene.variants.PackedArray;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimationKeys<T> {
    PackedArray<Float> times;
    PackedArray<Float> transitions;
    UpdateMode updateMode;
    ArrayList<T> values;

    public AnimationKeys() {
        this.times = new PackedArray<Float>();
        this.transitions = new PackedArray<Float>();
        this.updateMode = UpdateMode.UPDATE_CONTINUOUS;
        this.values = new ArrayList<T>();
    }

    public AnimationKeys(PackedArray<Float> times, PackedArray<Float> transitions, UpdateMode updateMode, ArrayList<T> values) {
        this.times = times;
        this.transitions = transitions;
        this.updateMode = updateMode;
        this.values = values;
    }

    public PackedArray<Float> getTimes() {
        return times;
    }

    public void setTimes(PackedArray<Float> times) {
        this.times = times;
    }

    public PackedArray<Float> getTransitions() {
        return transitions;
    }

    public void setTransitions(PackedArray<Float> transitions) {
        this.transitions = transitions;
    }

    public UpdateMode getUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(UpdateMode updateMode) {
        this.updateMode = updateMode;
    }

    public ArrayList<T> getValues() {
        return values;
    }

    public void setValues(ArrayList<T> values) {
        this.values = values;
    }

    public void addKey(float time, float transition, T value) {
        this.times.add(time);
        this.transitions.add(transition);
        this.values.add(value);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{\n");

        stringBuilder.append("\"times\": ").append(this.times).append(",\n");
        stringBuilder.append("\"transitions\": ").append(this.transitions).append(",\n");
        stringBuilder.append("\"update\": ").append(this.updateMode.ordinal()).append(",\n");

        stringBuilder.append("\"values\": [");

        Iterator<T> valuesIterator = this.values.iterator();
        while (valuesIterator.hasNext()) {
            stringBuilder.append(valuesIterator.next());
            if (valuesIterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]\n");

        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
