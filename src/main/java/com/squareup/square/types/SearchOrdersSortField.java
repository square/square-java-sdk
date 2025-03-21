/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class SearchOrdersSortField {
    public static final SearchOrdersSortField UPDATED_AT = new SearchOrdersSortField(Value.UPDATED_AT, "UPDATED_AT");

    public static final SearchOrdersSortField CLOSED_AT = new SearchOrdersSortField(Value.CLOSED_AT, "CLOSED_AT");

    public static final SearchOrdersSortField CREATED_AT = new SearchOrdersSortField(Value.CREATED_AT, "CREATED_AT");

    private final Value value;

    private final String string;

    SearchOrdersSortField(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other)
                || (other instanceof SearchOrdersSortField
                        && this.string.equals(((SearchOrdersSortField) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case UPDATED_AT:
                return visitor.visitUpdatedAt();
            case CLOSED_AT:
                return visitor.visitClosedAt();
            case CREATED_AT:
                return visitor.visitCreatedAt();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SearchOrdersSortField valueOf(String value) {
        switch (value) {
            case "UPDATED_AT":
                return UPDATED_AT;
            case "CLOSED_AT":
                return CLOSED_AT;
            case "CREATED_AT":
                return CREATED_AT;
            default:
                return new SearchOrdersSortField(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CREATED_AT,

        UPDATED_AT,

        CLOSED_AT,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCreatedAt();

        T visitUpdatedAt();

        T visitClosedAt();

        T visitUnknown(String unknownType);
    }
}
