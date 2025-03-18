/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CheckoutLocationSettingsBrandingHeaderType {
    public static final CheckoutLocationSettingsBrandingHeaderType FRAMED_LOGO =
            new CheckoutLocationSettingsBrandingHeaderType(Value.FRAMED_LOGO, "FRAMED_LOGO");

    public static final CheckoutLocationSettingsBrandingHeaderType BUSINESS_NAME =
            new CheckoutLocationSettingsBrandingHeaderType(Value.BUSINESS_NAME, "BUSINESS_NAME");

    public static final CheckoutLocationSettingsBrandingHeaderType FULL_WIDTH_LOGO =
            new CheckoutLocationSettingsBrandingHeaderType(Value.FULL_WIDTH_LOGO, "FULL_WIDTH_LOGO");

    private final Value value;

    private final String string;

    CheckoutLocationSettingsBrandingHeaderType(Value value, String string) {
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
                || (other instanceof CheckoutLocationSettingsBrandingHeaderType
                        && this.string.equals(((CheckoutLocationSettingsBrandingHeaderType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case FRAMED_LOGO:
                return visitor.visitFramedLogo();
            case BUSINESS_NAME:
                return visitor.visitBusinessName();
            case FULL_WIDTH_LOGO:
                return visitor.visitFullWidthLogo();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CheckoutLocationSettingsBrandingHeaderType valueOf(String value) {
        switch (value) {
            case "FRAMED_LOGO":
                return FRAMED_LOGO;
            case "BUSINESS_NAME":
                return BUSINESS_NAME;
            case "FULL_WIDTH_LOGO":
                return FULL_WIDTH_LOGO;
            default:
                return new CheckoutLocationSettingsBrandingHeaderType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        BUSINESS_NAME,

        FRAMED_LOGO,

        FULL_WIDTH_LOGO,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitBusinessName();

        T visitFramedLogo();

        T visitFullWidthLogo();

        T visitUnknown(String unknownType);
    }
}
