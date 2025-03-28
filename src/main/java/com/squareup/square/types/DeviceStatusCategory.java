/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class DeviceStatusCategory {
    public static final DeviceStatusCategory NEEDS_ATTENTION =
            new DeviceStatusCategory(Value.NEEDS_ATTENTION, "NEEDS_ATTENTION");

    public static final DeviceStatusCategory OFFLINE = new DeviceStatusCategory(Value.OFFLINE, "OFFLINE");

    public static final DeviceStatusCategory AVAILABLE = new DeviceStatusCategory(Value.AVAILABLE, "AVAILABLE");

    private final Value value;

    private final String string;

    DeviceStatusCategory(Value value, String string) {
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
                || (other instanceof DeviceStatusCategory && this.string.equals(((DeviceStatusCategory) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case NEEDS_ATTENTION:
                return visitor.visitNeedsAttention();
            case OFFLINE:
                return visitor.visitOffline();
            case AVAILABLE:
                return visitor.visitAvailable();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DeviceStatusCategory valueOf(String value) {
        switch (value) {
            case "NEEDS_ATTENTION":
                return NEEDS_ATTENTION;
            case "OFFLINE":
                return OFFLINE;
            case "AVAILABLE":
                return AVAILABLE;
            default:
                return new DeviceStatusCategory(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        AVAILABLE,

        NEEDS_ATTENTION,

        OFFLINE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAvailable();

        T visitNeedsAttention();

        T visitOffline();

        T visitUnknown(String unknownType);
    }
}
