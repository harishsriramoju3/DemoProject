package com.thrivexcorp.prepview.enums;

public enum FieldType {
    STRING("VARCHAR"),
    CURRENCY("NUMERIC"),
    NUMBER("INTEGER"),
    BOOLEAN("BOOLEAN"),
    DATE("DATE"),
    URL("TEXT"),
    DATE_TIME("TIMESTAMP"),
    PICKLIST("TEXT"), // or create a separate table for options
    MULTI_PICKLIST("TEXT[]"), // Array type
    PERCENTAGE("NUMERIC");

    private final String postgresType;

    FieldType(String postgresType) {
        this.postgresType = postgresType;
    }

    public String getPostgresType() {
        return postgresType;
    }

}
