package com.squareup.square.legacy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
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
     * Returns the enum member associated with the given string value.
     * @param toConvert String value to get enum member.
     * @return The enum member against the given string value.
     * @throws IOException when provided value is not mapped to any enum member.
     */
    @JsonCreator
    public static Server constructFromString(String toConvert) throws IOException {
        Server enumValue = fromString(toConvert);
        if (enumValue == null) {
            throw new IOException("Unable to create enum instance with value: " + toConvert);
        }
        return enumValue;
    }

    /**
     * Returns the enum member associated with the given string value.
     * @param toConvert String value to get enum member.
     * @return The enum member against the given string value.
     */
    public static Server fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member.
     * @return The string value against enum member.
     */
    @JsonValue
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
     * Convert list of Server values to list of string values.
     * @param toConvert The list of Server values to convert.
     * @return List of representative string values.
     */
    public static List<String> toValue(List<Server> toConvert) {
        if (toConvert == null) {
            return null;
        }
        List<String> convertedValues = new ArrayList<>();
        for (Server enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
}
