/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class OauthAuthorizationRevokedEventRevokerType {
    public static final OauthAuthorizationRevokedEventRevokerType APPLICATION =
            new OauthAuthorizationRevokedEventRevokerType(Value.APPLICATION, "APPLICATION");

    public static final OauthAuthorizationRevokedEventRevokerType MERCHANT =
            new OauthAuthorizationRevokedEventRevokerType(Value.MERCHANT, "MERCHANT");

    public static final OauthAuthorizationRevokedEventRevokerType SQUARE =
            new OauthAuthorizationRevokedEventRevokerType(Value.SQUARE, "SQUARE");

    private final Value value;

    private final String string;

    OauthAuthorizationRevokedEventRevokerType(Value value, String string) {
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
                || (other instanceof OauthAuthorizationRevokedEventRevokerType
                        && this.string.equals(((OauthAuthorizationRevokedEventRevokerType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case APPLICATION:
                return visitor.visitApplication();
            case MERCHANT:
                return visitor.visitMerchant();
            case SQUARE:
                return visitor.visitSquare();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OauthAuthorizationRevokedEventRevokerType valueOf(String value) {
        switch (value) {
            case "APPLICATION":
                return APPLICATION;
            case "MERCHANT":
                return MERCHANT;
            case "SQUARE":
                return SQUARE;
            default:
                return new OauthAuthorizationRevokedEventRevokerType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        APPLICATION,

        MERCHANT,

        SQUARE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitApplication();

        T visitMerchant();

        T visitSquare();

        T visitUnknown(String unknownType);
    }
}
