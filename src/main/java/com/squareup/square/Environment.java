
package com.squareup.square;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Environment to be used.
 */
public enum Environment {
    PRODUCTION,

    SANDBOX,

    CUSTOM;


    private static TreeMap<String, Environment> valueMap = new TreeMap<>();
    private String value;

    static {
        PRODUCTION.value = "production";
        SANDBOX.value = "sandbox";
        CUSTOM.value = "custom";

        valueMap.put("production", PRODUCTION);
        valueMap.put("sandbox", SANDBOX);
        valueMap.put("custom", CUSTOM);
    }

    /**
     * Returns the enum member associated with the given string value.
     * @param toConvert String value to get enum member.
     * @return The enum member against the given string value.
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static Environment fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member.
     * @return The string value against enum member.
     */
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        
    /**
     * Get string representation of this enum.
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Convert list of Environment values to list of string values.
     * @param toConvert The list of Environment values to convert.
     * @return List of representative string values.
     */
    public static List<String> toValue(List<Environment> toConvert) {
        if (toConvert == null) {
            return null;
        }
        List<String> convertedValues = new ArrayList<>();
        for (Environment enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 