package com.thrivexcorp.prepview.enums;

public enum SourceType {

    SYSTEM,
    CUSTOM;

    public static SourceType fromValue(String value) {
        for (SourceType type : SourceType.values()) {
            if (type.name().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }


}
