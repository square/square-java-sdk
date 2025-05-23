/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ShiftStatus {
    public static final ShiftStatus CLOSED = new ShiftStatus(Value.CLOSED, "CLOSED");

    public static final ShiftStatus OPEN = new ShiftStatus(Value.OPEN, "OPEN");

    private final Value value;

    private final String string;

    ShiftStatus(Value value, String string) {
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
        return (this == other) || (other instanceof ShiftStatus && this.string.equals(((ShiftStatus) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CLOSED:
                return visitor.visitClosed();
            case OPEN:
                return visitor.visitOpen();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ShiftStatus valueOf(String value) {
        switch (value) {
            case "CLOSED":
                return CLOSED;
            case "OPEN":
                return OPEN;
            default:
                return new ShiftStatus(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        OPEN,

        CLOSED,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitOpen();

        T visitClosed();

        T visitUnknown(String unknownType);
    }
}
