/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ScheduledShiftFilterAssignmentStatus {
    public static final ScheduledShiftFilterAssignmentStatus UNASSIGNED =
            new ScheduledShiftFilterAssignmentStatus(Value.UNASSIGNED, "UNASSIGNED");

    public static final ScheduledShiftFilterAssignmentStatus ASSIGNED =
            new ScheduledShiftFilterAssignmentStatus(Value.ASSIGNED, "ASSIGNED");

    private final Value value;

    private final String string;

    ScheduledShiftFilterAssignmentStatus(Value value, String string) {
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
                || (other instanceof ScheduledShiftFilterAssignmentStatus
                        && this.string.equals(((ScheduledShiftFilterAssignmentStatus) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case UNASSIGNED:
                return visitor.visitUnassigned();
            case ASSIGNED:
                return visitor.visitAssigned();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ScheduledShiftFilterAssignmentStatus valueOf(String value) {
        switch (value) {
            case "UNASSIGNED":
                return UNASSIGNED;
            case "ASSIGNED":
                return ASSIGNED;
            default:
                return new ScheduledShiftFilterAssignmentStatus(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ASSIGNED,

        UNASSIGNED,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAssigned();

        T visitUnassigned();

        T visitUnknown(String unknownType);
    }
}
