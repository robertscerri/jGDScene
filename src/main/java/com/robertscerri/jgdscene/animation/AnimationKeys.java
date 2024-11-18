package com.robertscerri.jgdscene.animation;

import com.robertscerri.jgdscene.animation.enums.UpdateMode;
import com.robertscerri.jgdscene.variants.packedarrays.PackedArray;
import com.robertscerri.jgdscene.variants.packedarrays.PackedFloat32Array;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimationKeys<T> {
    PackedFloat32Array times;
    PackedFloat32Array transitions;
    UpdateMode updateMode;
    ArrayList<T> values;

    public AnimationKeys() {
        this.times = new PackedFloat32Array();
        this.transitions = new PackedFloat32Array();
        this.updateMode = UpdateMode.UPDATE_CONTINUOUS;
        this.values = new ArrayList<T>();
    }

    public AnimationKeys(PackedFloat32Array times, PackedFloat32Array transitions, UpdateMode updateMode, ArrayList<T> values) {
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

    public ArrayList<T> getValues() {
        return values;
    }

    public void setValues(ArrayList<T> values) {
        this.values = values;
    }

    public void addKey(float time, float transition, T value) {
        this.times.append(time);
        this.transitions.append(transition);
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
