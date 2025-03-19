/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class GiftCardActivityClearBalanceReason {
    public static final GiftCardActivityClearBalanceReason SUSPICIOUS_ACTIVITY =
            new GiftCardActivityClearBalanceReason(Value.SUSPICIOUS_ACTIVITY, "SUSPICIOUS_ACTIVITY");

    public static final GiftCardActivityClearBalanceReason UNKNOWN_REASON =
            new GiftCardActivityClearBalanceReason(Value.UNKNOWN_REASON, "UNKNOWN_REASON");

    public static final GiftCardActivityClearBalanceReason REUSE_GIFTCARD =
            new GiftCardActivityClearBalanceReason(Value.REUSE_GIFTCARD, "REUSE_GIFTCARD");

    private final Value value;

    private final String string;

    GiftCardActivityClearBalanceReason(Value value, String string) {
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
                || (other instanceof GiftCardActivityClearBalanceReason
                        && this.string.equals(((GiftCardActivityClearBalanceReason) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SUSPICIOUS_ACTIVITY:
                return visitor.visitSuspiciousActivity();
            case UNKNOWN_REASON:
                return visitor.visitUnknownReason();
            case REUSE_GIFTCARD:
                return visitor.visitReuseGiftcard();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GiftCardActivityClearBalanceReason valueOf(String value) {
        switch (value) {
            case "SUSPICIOUS_ACTIVITY":
                return SUSPICIOUS_ACTIVITY;
            case "UNKNOWN_REASON":
                return UNKNOWN_REASON;
            case "REUSE_GIFTCARD":
                return REUSE_GIFTCARD;
            default:
                return new GiftCardActivityClearBalanceReason(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SUSPICIOUS_ACTIVITY,

        REUSE_GIFTCARD,

        UNKNOWN_REASON,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSuspiciousActivity();

        T visitReuseGiftcard();

        T visitUnknownReason();

        T visitUnknown(String unknownType);
    }
}
