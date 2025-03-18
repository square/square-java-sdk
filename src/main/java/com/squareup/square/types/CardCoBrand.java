/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CardCoBrand {
    public static final CardCoBrand AFTERPAY = new CardCoBrand(Value.AFTERPAY, "AFTERPAY");

    public static final CardCoBrand CLEARPAY = new CardCoBrand(Value.CLEARPAY, "CLEARPAY");

    public static final CardCoBrand UNKNOWN = new CardCoBrand(Value.UNKNOWN, "UNKNOWN");

    private final Value value;

    private final String string;

    CardCoBrand(Value value, String string) {
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
        return (this == other) || (other instanceof CardCoBrand && this.string.equals(((CardCoBrand) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case AFTERPAY:
                return visitor.visitAfterpay();
            case CLEARPAY:
                return visitor.visitClearpay();
            case UNKNOWN:
                return visitor.visitUnknown();
            case _UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CardCoBrand valueOf(String value) {
        switch (value) {
            case "AFTERPAY":
                return AFTERPAY;
            case "CLEARPAY":
                return CLEARPAY;
            case "UNKNOWN":
                return UNKNOWN;
            default:
                return new CardCoBrand(Value._UNKNOWN, value);
        }
    }

    public enum Value {
        UNKNOWN,

        AFTERPAY,

        CLEARPAY,

        _UNKNOWN
    }

    public interface Visitor<T> {
        T visitUnknown();

        T visitAfterpay();

        T visitClearpay();

        T visitUnknown(String unknownType);
    }
}
