/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ScheduledShiftNotificationAudience {
    public static final ScheduledShiftNotificationAudience AFFECTED =
            new ScheduledShiftNotificationAudience(Value.AFFECTED, "AFFECTED");

    public static final ScheduledShiftNotificationAudience ALL =
            new ScheduledShiftNotificationAudience(Value.ALL, "ALL");

    public static final ScheduledShiftNotificationAudience NONE =
            new ScheduledShiftNotificationAudience(Value.NONE, "NONE");

    private final Value value;

    private final String string;

    ScheduledShiftNotificationAudience(Value value, String string) {
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
                || (other instanceof ScheduledShiftNotificationAudience
                        && this.string.equals(((ScheduledShiftNotificationAudience) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case AFFECTED:
                return visitor.visitAffected();
            case ALL:
                return visitor.visitAll();
            case NONE:
                return visitor.visitNone();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ScheduledShiftNotificationAudience valueOf(String value) {
        switch (value) {
            case "AFFECTED":
                return AFFECTED;
            case "ALL":
                return ALL;
            case "NONE":
                return NONE;
            default:
                return new ScheduledShiftNotificationAudience(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ALL,

        AFFECTED,

        NONE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAll();

        T visitAffected();

        T visitNone();

        T visitUnknown(String unknownType);
    }
}
