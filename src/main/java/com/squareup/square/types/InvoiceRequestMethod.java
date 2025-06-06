/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class InvoiceRequestMethod {
    public static final InvoiceRequestMethod SMS = new InvoiceRequestMethod(Value.SMS, "SMS");

    public static final InvoiceRequestMethod CHARGE_BANK_ON_FILE =
            new InvoiceRequestMethod(Value.CHARGE_BANK_ON_FILE, "CHARGE_BANK_ON_FILE");

    public static final InvoiceRequestMethod SMS_CHARGE_BANK_ON_FILE =
            new InvoiceRequestMethod(Value.SMS_CHARGE_BANK_ON_FILE, "SMS_CHARGE_BANK_ON_FILE");

    public static final InvoiceRequestMethod SMS_CHARGE_CARD_ON_FILE =
            new InvoiceRequestMethod(Value.SMS_CHARGE_CARD_ON_FILE, "SMS_CHARGE_CARD_ON_FILE");

    public static final InvoiceRequestMethod CHARGE_CARD_ON_FILE =
            new InvoiceRequestMethod(Value.CHARGE_CARD_ON_FILE, "CHARGE_CARD_ON_FILE");

    public static final InvoiceRequestMethod SHARE_MANUALLY =
            new InvoiceRequestMethod(Value.SHARE_MANUALLY, "SHARE_MANUALLY");

    public static final InvoiceRequestMethod EMAIL = new InvoiceRequestMethod(Value.EMAIL, "EMAIL");

    private final Value value;

    private final String string;

    InvoiceRequestMethod(Value value, String string) {
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
                || (other instanceof InvoiceRequestMethod && this.string.equals(((InvoiceRequestMethod) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SMS:
                return visitor.visitSms();
            case CHARGE_BANK_ON_FILE:
                return visitor.visitChargeBankOnFile();
            case SMS_CHARGE_BANK_ON_FILE:
                return visitor.visitSmsChargeBankOnFile();
            case SMS_CHARGE_CARD_ON_FILE:
                return visitor.visitSmsChargeCardOnFile();
            case CHARGE_CARD_ON_FILE:
                return visitor.visitChargeCardOnFile();
            case SHARE_MANUALLY:
                return visitor.visitShareManually();
            case EMAIL:
                return visitor.visitEmail();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static InvoiceRequestMethod valueOf(String value) {
        switch (value) {
            case "SMS":
                return SMS;
            case "CHARGE_BANK_ON_FILE":
                return CHARGE_BANK_ON_FILE;
            case "SMS_CHARGE_BANK_ON_FILE":
                return SMS_CHARGE_BANK_ON_FILE;
            case "SMS_CHARGE_CARD_ON_FILE":
                return SMS_CHARGE_CARD_ON_FILE;
            case "CHARGE_CARD_ON_FILE":
                return CHARGE_CARD_ON_FILE;
            case "SHARE_MANUALLY":
                return SHARE_MANUALLY;
            case "EMAIL":
                return EMAIL;
            default:
                return new InvoiceRequestMethod(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        EMAIL,

        CHARGE_CARD_ON_FILE,

        SHARE_MANUALLY,

        CHARGE_BANK_ON_FILE,

        SMS,

        SMS_CHARGE_CARD_ON_FILE,

        SMS_CHARGE_BANK_ON_FILE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitEmail();

        T visitChargeCardOnFile();

        T visitShareManually();

        T visitChargeBankOnFile();

        T visitSms();

        T visitSmsChargeCardOnFile();

        T visitSmsChargeBankOnFile();

        T visitUnknown(String unknownType);
    }
}
