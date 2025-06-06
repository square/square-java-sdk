/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class BusinessBookingProfileBookingPolicy {
    public static final BusinessBookingProfileBookingPolicy REQUIRES_ACCEPTANCE =
            new BusinessBookingProfileBookingPolicy(Value.REQUIRES_ACCEPTANCE, "REQUIRES_ACCEPTANCE");

    public static final BusinessBookingProfileBookingPolicy ACCEPT_ALL =
            new BusinessBookingProfileBookingPolicy(Value.ACCEPT_ALL, "ACCEPT_ALL");

    private final Value value;

    private final String string;

    BusinessBookingProfileBookingPolicy(Value value, String string) {
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
                || (other instanceof BusinessBookingProfileBookingPolicy
                        && this.string.equals(((BusinessBookingProfileBookingPolicy) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case REQUIRES_ACCEPTANCE:
                return visitor.visitRequiresAcceptance();
            case ACCEPT_ALL:
                return visitor.visitAcceptAll();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BusinessBookingProfileBookingPolicy valueOf(String value) {
        switch (value) {
            case "REQUIRES_ACCEPTANCE":
                return REQUIRES_ACCEPTANCE;
            case "ACCEPT_ALL":
                return ACCEPT_ALL;
            default:
                return new BusinessBookingProfileBookingPolicy(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ACCEPT_ALL,

        REQUIRES_ACCEPTANCE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAcceptAll();

        T visitRequiresAcceptance();

        T visitUnknown(String unknownType);
    }
}
