package com.robertscerri.jgdscene.animation.enums;

public enum TrackType {
    VALUE ("value");
    
    private final String type;

    TrackType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
