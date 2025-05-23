/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TimecardStatus {
    public static final TimecardStatus CLOSED = new TimecardStatus(Value.CLOSED, "CLOSED");

    public static final TimecardStatus OPEN = new TimecardStatus(Value.OPEN, "OPEN");

    private final Value value;

    private final String string;

    TimecardStatus(Value value, String string) {
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
                || (other instanceof TimecardStatus && this.string.equals(((TimecardStatus) other).string));
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
    public static TimecardStatus valueOf(String value) {
        switch (value) {
            case "CLOSED":
                return CLOSED;
            case "OPEN":
                return OPEN;
            default:
                return new TimecardStatus(Value.UNKNOWN, value);
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
