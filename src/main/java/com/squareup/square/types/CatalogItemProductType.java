/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CatalogItemProductType {
    public static final CatalogItemProductType FOOD_AND_BEV =
            new CatalogItemProductType(Value.FOOD_AND_BEV, "FOOD_AND_BEV");

    public static final CatalogItemProductType REGULAR = new CatalogItemProductType(Value.REGULAR, "REGULAR");

    public static final CatalogItemProductType GIFT_CARD = new CatalogItemProductType(Value.GIFT_CARD, "GIFT_CARD");

    public static final CatalogItemProductType DIGITAL = new CatalogItemProductType(Value.DIGITAL, "DIGITAL");

    public static final CatalogItemProductType LEGACY_SQUARE_ONLINE_SERVICE =
            new CatalogItemProductType(Value.LEGACY_SQUARE_ONLINE_SERVICE, "LEGACY_SQUARE_ONLINE_SERVICE");

    public static final CatalogItemProductType LEGACY_SQUARE_ONLINE_MEMBERSHIP =
            new CatalogItemProductType(Value.LEGACY_SQUARE_ONLINE_MEMBERSHIP, "LEGACY_SQUARE_ONLINE_MEMBERSHIP");

    public static final CatalogItemProductType APPOINTMENTS_SERVICE =
            new CatalogItemProductType(Value.APPOINTMENTS_SERVICE, "APPOINTMENTS_SERVICE");

    public static final CatalogItemProductType EVENT = new CatalogItemProductType(Value.EVENT, "EVENT");

    public static final CatalogItemProductType DONATION = new CatalogItemProductType(Value.DONATION, "DONATION");

    private final Value value;

    private final String string;

    CatalogItemProductType(Value value, String string) {
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
                || (other instanceof CatalogItemProductType
                        && this.string.equals(((CatalogItemProductType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case FOOD_AND_BEV:
                return visitor.visitFoodAndBev();
            case REGULAR:
                return visitor.visitRegular();
            case GIFT_CARD:
                return visitor.visitGiftCard();
            case DIGITAL:
                return visitor.visitDigital();
            case LEGACY_SQUARE_ONLINE_SERVICE:
                return visitor.visitLegacySquareOnlineService();
            case LEGACY_SQUARE_ONLINE_MEMBERSHIP:
                return visitor.visitLegacySquareOnlineMembership();
            case APPOINTMENTS_SERVICE:
                return visitor.visitAppointmentsService();
            case EVENT:
                return visitor.visitEvent();
            case DONATION:
                return visitor.visitDonation();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CatalogItemProductType valueOf(String value) {
        switch (value) {
            case "FOOD_AND_BEV":
                return FOOD_AND_BEV;
            case "REGULAR":
                return REGULAR;
            case "GIFT_CARD":
                return GIFT_CARD;
            case "DIGITAL":
                return DIGITAL;
            case "LEGACY_SQUARE_ONLINE_SERVICE":
                return LEGACY_SQUARE_ONLINE_SERVICE;
            case "LEGACY_SQUARE_ONLINE_MEMBERSHIP":
                return LEGACY_SQUARE_ONLINE_MEMBERSHIP;
            case "APPOINTMENTS_SERVICE":
                return APPOINTMENTS_SERVICE;
            case "EVENT":
                return EVENT;
            case "DONATION":
                return DONATION;
            default:
                return new CatalogItemProductType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        REGULAR,

        GIFT_CARD,

        APPOINTMENTS_SERVICE,

        FOOD_AND_BEV,

        EVENT,

        DIGITAL,

        DONATION,

        LEGACY_SQUARE_ONLINE_SERVICE,

        LEGACY_SQUARE_ONLINE_MEMBERSHIP,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitRegular();

        T visitGiftCard();

        T visitAppointmentsService();

        T visitFoodAndBev();

        T visitEvent();

        T visitDigital();

        T visitDonation();

        T visitLegacySquareOnlineService();

        T visitLegacySquareOnlineMembership();

        T visitUnknown(String unknownType);
    }
}
