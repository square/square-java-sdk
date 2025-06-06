/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class SubscriptionStatus {
    public static final SubscriptionStatus CANCELED = new SubscriptionStatus(Value.CANCELED, "CANCELED");

    public static final SubscriptionStatus DEACTIVATED = new SubscriptionStatus(Value.DEACTIVATED, "DEACTIVATED");

    public static final SubscriptionStatus PAUSED = new SubscriptionStatus(Value.PAUSED, "PAUSED");

    public static final SubscriptionStatus ACTIVE = new SubscriptionStatus(Value.ACTIVE, "ACTIVE");

    public static final SubscriptionStatus PENDING = new SubscriptionStatus(Value.PENDING, "PENDING");

    private final Value value;

    private final String string;

    SubscriptionStatus(Value value, String string) {
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
                || (other instanceof SubscriptionStatus && this.string.equals(((SubscriptionStatus) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CANCELED:
                return visitor.visitCanceled();
            case DEACTIVATED:
                return visitor.visitDeactivated();
            case PAUSED:
                return visitor.visitPaused();
            case ACTIVE:
                return visitor.visitActive();
            case PENDING:
                return visitor.visitPending();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionStatus valueOf(String value) {
        switch (value) {
            case "CANCELED":
                return CANCELED;
            case "DEACTIVATED":
                return DEACTIVATED;
            case "PAUSED":
                return PAUSED;
            case "ACTIVE":
                return ACTIVE;
            case "PENDING":
                return PENDING;
            default:
                return new SubscriptionStatus(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        PENDING,

        ACTIVE,

        CANCELED,

        DEACTIVATED,

        PAUSED,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitPending();

        T visitActive();

        T visitCanceled();

        T visitDeactivated();

        T visitPaused();

        T visitUnknown(String unknownType);
    }
}
