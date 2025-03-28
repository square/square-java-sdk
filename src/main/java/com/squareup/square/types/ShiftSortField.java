/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ShiftSortField {
    public static final ShiftSortField END_AT = new ShiftSortField(Value.END_AT, "END_AT");

    public static final ShiftSortField START_AT = new ShiftSortField(Value.START_AT, "START_AT");

    public static final ShiftSortField UPDATED_AT = new ShiftSortField(Value.UPDATED_AT, "UPDATED_AT");

    public static final ShiftSortField CREATED_AT = new ShiftSortField(Value.CREATED_AT, "CREATED_AT");

    private final Value value;

    private final String string;

    ShiftSortField(Value value, String string) {
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
                || (other instanceof ShiftSortField && this.string.equals(((ShiftSortField) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case END_AT:
                return visitor.visitEndAt();
            case START_AT:
                return visitor.visitStartAt();
            case UPDATED_AT:
                return visitor.visitUpdatedAt();
            case CREATED_AT:
                return visitor.visitCreatedAt();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ShiftSortField valueOf(String value) {
        switch (value) {
            case "END_AT":
                return END_AT;
            case "START_AT":
                return START_AT;
            case "UPDATED_AT":
                return UPDATED_AT;
            case "CREATED_AT":
                return CREATED_AT;
            default:
                return new ShiftSortField(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        START_AT,

        END_AT,

        CREATED_AT,

        UPDATED_AT,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitStartAt();

        T visitEndAt();

        T visitCreatedAt();

        T visitUpdatedAt();

        T visitUnknown(String unknownType);
    }
}
