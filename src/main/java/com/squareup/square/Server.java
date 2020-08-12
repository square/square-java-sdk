package com.squareup.square;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Server to be used.
 */
public enum Server {
    ENUM_DEFAULT;


    private static TreeMap<String, Server> valueMap = new TreeMap<>();
    private String value;

    static {
        ENUM_DEFAULT.value = "default";

        valueMap.put("default", ENUM_DEFAULT);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static Server fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member
     * @return The string value against enum member */
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        
    /**
     * Get string representation of this enum
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Convert list of Server values to list of string values
     * @param toConvert The list of Server values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<Server> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<>();
        for (Server enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
}
