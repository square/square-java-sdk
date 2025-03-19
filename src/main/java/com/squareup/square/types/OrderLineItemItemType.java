/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class OrderLineItemItemType {
    public static final OrderLineItemItemType GIFT_CARD = new OrderLineItemItemType(Value.GIFT_CARD, "GIFT_CARD");

    public static final OrderLineItemItemType ITEM = new OrderLineItemItemType(Value.ITEM, "ITEM");

    public static final OrderLineItemItemType CUSTOM_AMOUNT =
            new OrderLineItemItemType(Value.CUSTOM_AMOUNT, "CUSTOM_AMOUNT");

    private final Value value;

    private final String string;

    OrderLineItemItemType(Value value, String string) {
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
                || (other instanceof OrderLineItemItemType
                        && this.string.equals(((OrderLineItemItemType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case GIFT_CARD:
                return visitor.visitGiftCard();
            case ITEM:
                return visitor.visitItem();
            case CUSTOM_AMOUNT:
                return visitor.visitCustomAmount();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OrderLineItemItemType valueOf(String value) {
        switch (value) {
            case "GIFT_CARD":
                return GIFT_CARD;
            case "ITEM":
                return ITEM;
            case "CUSTOM_AMOUNT":
                return CUSTOM_AMOUNT;
            default:
                return new OrderLineItemItemType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ITEM,

        CUSTOM_AMOUNT,

        GIFT_CARD,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitItem();

        T visitCustomAmount();

        T visitGiftCard();

        T visitUnknown(String unknownType);
    }
}
