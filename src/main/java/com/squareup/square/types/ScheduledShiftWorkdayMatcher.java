/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ScheduledShiftWorkdayMatcher {
    public static final ScheduledShiftWorkdayMatcher END_AT = new ScheduledShiftWorkdayMatcher(Value.END_AT, "END_AT");

    public static final ScheduledShiftWorkdayMatcher INTERSECTION =
            new ScheduledShiftWorkdayMatcher(Value.INTERSECTION, "INTERSECTION");

    public static final ScheduledShiftWorkdayMatcher START_AT =
            new ScheduledShiftWorkdayMatcher(Value.START_AT, "START_AT");

    private final Value value;

    private final String string;

    ScheduledShiftWorkdayMatcher(Value value, String string) {
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
                || (other instanceof ScheduledShiftWorkdayMatcher
                        && this.string.equals(((ScheduledShiftWorkdayMatcher) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case END_AT:
                return visitor.visitEndAt();
            case INTERSECTION:
                return visitor.visitIntersection();
            case START_AT:
                return visitor.visitStartAt();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ScheduledShiftWorkdayMatcher valueOf(String value) {
        switch (value) {
            case "END_AT":
                return END_AT;
            case "INTERSECTION":
                return INTERSECTION;
            case "START_AT":
                return START_AT;
            default:
                return new ScheduledShiftWorkdayMatcher(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        START_AT,

        END_AT,

        INTERSECTION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitStartAt();

        T visitEndAt();

        T visitIntersection();

        T visitUnknown(String unknownType);
    }
}
