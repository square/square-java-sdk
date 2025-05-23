/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ScheduledShiftFilterScheduledShiftStatus {
    public static final ScheduledShiftFilterScheduledShiftStatus PUBLISHED =
            new ScheduledShiftFilterScheduledShiftStatus(Value.PUBLISHED, "PUBLISHED");

    public static final ScheduledShiftFilterScheduledShiftStatus DRAFT =
            new ScheduledShiftFilterScheduledShiftStatus(Value.DRAFT, "DRAFT");

    private final Value value;

    private final String string;

    ScheduledShiftFilterScheduledShiftStatus(Value value, String string) {
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
                || (other instanceof ScheduledShiftFilterScheduledShiftStatus
                        && this.string.equals(((ScheduledShiftFilterScheduledShiftStatus) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case PUBLISHED:
                return visitor.visitPublished();
            case DRAFT:
                return visitor.visitDraft();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ScheduledShiftFilterScheduledShiftStatus valueOf(String value) {
        switch (value) {
            case "PUBLISHED":
                return PUBLISHED;
            case "DRAFT":
                return DRAFT;
            default:
                return new ScheduledShiftFilterScheduledShiftStatus(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        DRAFT,

        PUBLISHED,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitDraft();

        T visitPublished();

        T visitUnknown(String unknownType);
    }
}
