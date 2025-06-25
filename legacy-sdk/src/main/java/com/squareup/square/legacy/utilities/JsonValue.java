package com.squareup.square.legacy.utilities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.squareup.square.legacy.ApiHelper;
import io.apimatic.core.utilities.CoreJsonValue;
import java.util.List;

/**
 * This is a wrapper class for JSON value.
 */
public class JsonValue extends CoreJsonValue {

    /**
     * Initialization private constructor.
     * @param jsonNode The JSON of type JsonNode.
     */
    @JsonCreator
    private JsonValue(JsonNode jsonnode) {
        super(jsonnode);
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
        return new JsonValue(ApiHelper.getMapper().valueToTree(value));
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
        return new JsonValue(ApiHelper.getMapper().valueToTree(values));
    }
    /**
     * Converts the JSON into string.
     * @return String representation of JSON
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
