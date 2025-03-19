/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class SubscriptionPricingType {
    public static final SubscriptionPricingType RELATIVE = new SubscriptionPricingType(Value.RELATIVE, "RELATIVE");

    public static final SubscriptionPricingType STATIC = new SubscriptionPricingType(Value.STATIC, "STATIC");

    private final Value value;

    private final String string;

    SubscriptionPricingType(Value value, String string) {
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
                || (other instanceof SubscriptionPricingType
                        && this.string.equals(((SubscriptionPricingType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case RELATIVE:
                return visitor.visitRelative();
            case STATIC:
                return visitor.visitStatic();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionPricingType valueOf(String value) {
        switch (value) {
            case "RELATIVE":
                return RELATIVE;
            case "STATIC":
                return STATIC;
            default:
                return new SubscriptionPricingType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        STATIC,

        RELATIVE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitStatic();

        T visitRelative();

        T visitUnknown(String unknownType);
    }
}
