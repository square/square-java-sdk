/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CardPrepaidType {
    public static final CardPrepaidType NOT_PREPAID = new CardPrepaidType(Value.NOT_PREPAID, "NOT_PREPAID");

    public static final CardPrepaidType PREPAID = new CardPrepaidType(Value.PREPAID, "PREPAID");

    public static final CardPrepaidType UNKNOWN_PREPAID_TYPE =
            new CardPrepaidType(Value.UNKNOWN_PREPAID_TYPE, "UNKNOWN_PREPAID_TYPE");

    private final Value value;

    private final String string;

    CardPrepaidType(Value value, String string) {
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
                || (other instanceof CardPrepaidType && this.string.equals(((CardPrepaidType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case NOT_PREPAID:
                return visitor.visitNotPrepaid();
            case PREPAID:
                return visitor.visitPrepaid();
            case UNKNOWN_PREPAID_TYPE:
                return visitor.visitUnknownPrepaidType();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CardPrepaidType valueOf(String value) {
        switch (value) {
            case "NOT_PREPAID":
                return NOT_PREPAID;
            case "PREPAID":
                return PREPAID;
            case "UNKNOWN_PREPAID_TYPE":
                return UNKNOWN_PREPAID_TYPE;
            default:
                return new CardPrepaidType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        UNKNOWN_PREPAID_TYPE,

        NOT_PREPAID,

        PREPAID,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitUnknownPrepaidType();

        T visitNotPrepaid();

        T visitPrepaid();

        T visitUnknown(String unknownType);
    }
}
