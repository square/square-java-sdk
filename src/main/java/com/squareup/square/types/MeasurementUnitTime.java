/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class MeasurementUnitTime {
    public static final MeasurementUnitTime GENERIC_MILLISECOND =
            new MeasurementUnitTime(Value.GENERIC_MILLISECOND, "GENERIC_MILLISECOND");

    public static final MeasurementUnitTime GENERIC_DAY = new MeasurementUnitTime(Value.GENERIC_DAY, "GENERIC_DAY");

    public static final MeasurementUnitTime GENERIC_HOUR = new MeasurementUnitTime(Value.GENERIC_HOUR, "GENERIC_HOUR");

    public static final MeasurementUnitTime GENERIC_SECOND =
            new MeasurementUnitTime(Value.GENERIC_SECOND, "GENERIC_SECOND");

    public static final MeasurementUnitTime GENERIC_MINUTE =
            new MeasurementUnitTime(Value.GENERIC_MINUTE, "GENERIC_MINUTE");

    private final Value value;

    private final String string;

    MeasurementUnitTime(Value value, String string) {
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
                || (other instanceof MeasurementUnitTime && this.string.equals(((MeasurementUnitTime) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case GENERIC_MILLISECOND:
                return visitor.visitGenericMillisecond();
            case GENERIC_DAY:
                return visitor.visitGenericDay();
            case GENERIC_HOUR:
                return visitor.visitGenericHour();
            case GENERIC_SECOND:
                return visitor.visitGenericSecond();
            case GENERIC_MINUTE:
                return visitor.visitGenericMinute();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MeasurementUnitTime valueOf(String value) {
        switch (value) {
            case "GENERIC_MILLISECOND":
                return GENERIC_MILLISECOND;
            case "GENERIC_DAY":
                return GENERIC_DAY;
            case "GENERIC_HOUR":
                return GENERIC_HOUR;
            case "GENERIC_SECOND":
                return GENERIC_SECOND;
            case "GENERIC_MINUTE":
                return GENERIC_MINUTE;
            default:
                return new MeasurementUnitTime(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        GENERIC_MILLISECOND,

        GENERIC_SECOND,

        GENERIC_MINUTE,

        GENERIC_HOUR,

        GENERIC_DAY,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitGenericMillisecond();

        T visitGenericSecond();

        T visitGenericMinute();

        T visitGenericHour();

        T visitGenericDay();

        T visitUnknown(String unknownType);
    }
}
