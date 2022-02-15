
package com.squareup.square.utilities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.squareup.square.ApiHelper;
import java.util.List;

/**
 * This is a wrapper class for JSON value.
 */
public class JsonValue {
    @com.fasterxml.jackson.annotation.JsonValue
    private JsonNode value;

    /**
     * Initialization constructor.
     * 
     * @param jsonNode The JSON of type JsonNode.
     */
    @JsonCreator
    private JsonValue(JsonNode value) {
        this.value = value;
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The string value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromString(String value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(TextNode.valueOf(value));
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The boolean value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromBoolean(Boolean value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(BooleanNode.valueOf(value));
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The integer value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromInteger(Integer value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(IntNode.valueOf(value));
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The long value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromLong(Long value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(LongNode.valueOf(value));
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The double value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromDouble(Double value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(DoubleNode.valueOf(value));
    }

    /**
     * Initializes JsonValue instance with provided value.
     * @param value The double value to initialize with.
     * @return The JsonValue instance.
     */
    public static JsonValue fromObject(Object value) {
        if (value == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(ApiHelper.mapper.valueToTree(value));
    }

    /**
     * Initializes JsonValue instance with provided list of values.
     * @param <T> The list type
     * @param values The list of values of given type.
     * @return The JsonValue instance.
     */
    public static <T> JsonValue fromArray(List<T> values) {
        if (values == null) {
            return new JsonValue(null);            
        }
        return new JsonValue(ApiHelper.mapper.valueToTree(values));
    }

    /**
     * Getter for stored JSON object.
     * @return The stored JSON as Object.
     */
    public Object getStoredObject() {
        return ApiHelper.deserializeAsObject(toString());
    }

    /**
     * Converts the JSON into string.
     * @return String representation of JSON
     */
    @Override
    public String toString() {
        try {
            return ApiHelper.mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
