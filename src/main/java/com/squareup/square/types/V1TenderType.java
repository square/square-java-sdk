/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class V1TenderType {
    public static final V1TenderType OTHER = new V1TenderType(Value.OTHER, "OTHER");

    public static final V1TenderType THIRD_PARTY_CARD = new V1TenderType(Value.THIRD_PARTY_CARD, "THIRD_PARTY_CARD");

    public static final V1TenderType NO_SALE = new V1TenderType(Value.NO_SALE, "NO_SALE");

    public static final V1TenderType CASH = new V1TenderType(Value.CASH, "CASH");

    public static final V1TenderType CREDIT_CARD = new V1TenderType(Value.CREDIT_CARD, "CREDIT_CARD");

    public static final V1TenderType SQUARE_WALLET = new V1TenderType(Value.SQUARE_WALLET, "SQUARE_WALLET");

    public static final V1TenderType UNKNOWN = new V1TenderType(Value.UNKNOWN, "UNKNOWN");

    public static final V1TenderType SQUARE_GIFT_CARD = new V1TenderType(Value.SQUARE_GIFT_CARD, "SQUARE_GIFT_CARD");

    private final Value value;

    private final String string;

    V1TenderType(Value value, String string) {
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
        return (this == other) || (other instanceof V1TenderType && this.string.equals(((V1TenderType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case OTHER:
                return visitor.visitOther();
            case THIRD_PARTY_CARD:
                return visitor.visitThirdPartyCard();
            case NO_SALE:
                return visitor.visitNoSale();
            case CASH:
                return visitor.visitCash();
            case CREDIT_CARD:
                return visitor.visitCreditCard();
            case SQUARE_WALLET:
                return visitor.visitSquareWallet();
            case UNKNOWN:
                return visitor.visitUnknown();
            case SQUARE_GIFT_CARD:
                return visitor.visitSquareGiftCard();
            case _UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static V1TenderType valueOf(String value) {
        switch (value) {
            case "OTHER":
                return OTHER;
            case "THIRD_PARTY_CARD":
                return THIRD_PARTY_CARD;
            case "NO_SALE":
                return NO_SALE;
            case "CASH":
                return CASH;
            case "CREDIT_CARD":
                return CREDIT_CARD;
            case "SQUARE_WALLET":
                return SQUARE_WALLET;
            case "UNKNOWN":
                return UNKNOWN;
            case "SQUARE_GIFT_CARD":
                return SQUARE_GIFT_CARD;
            default:
                return new V1TenderType(Value._UNKNOWN, value);
        }
    }

    public enum Value {
        CREDIT_CARD,

        CASH,

        THIRD_PARTY_CARD,

        NO_SALE,

        SQUARE_WALLET,

        SQUARE_GIFT_CARD,

        UNKNOWN,

        OTHER,

        _UNKNOWN
    }

    public interface Visitor<T> {
        T visitCreditCard();

        T visitCash();

        T visitThirdPartyCard();

        T visitNoSale();

        T visitSquareWallet();

        T visitSquareGiftCard();

        T visitUnknown();

        T visitOther();

        T visitUnknown(String unknownType);
    }
}
