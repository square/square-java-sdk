/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TransactionProduct {
    public static final TransactionProduct APPOINTMENTS = new TransactionProduct(Value.APPOINTMENTS, "APPOINTMENTS");

    public static final TransactionProduct OTHER = new TransactionProduct(Value.OTHER, "OTHER");

    public static final TransactionProduct BILLING = new TransactionProduct(Value.BILLING, "BILLING");

    public static final TransactionProduct INVOICES = new TransactionProduct(Value.INVOICES, "INVOICES");

    public static final TransactionProduct REGISTER = new TransactionProduct(Value.REGISTER, "REGISTER");

    public static final TransactionProduct EXTERNAL_API = new TransactionProduct(Value.EXTERNAL_API, "EXTERNAL_API");

    public static final TransactionProduct ONLINE_STORE = new TransactionProduct(Value.ONLINE_STORE, "ONLINE_STORE");

    public static final TransactionProduct PAYROLL = new TransactionProduct(Value.PAYROLL, "PAYROLL");

    private final Value value;

    private final String string;

    TransactionProduct(Value value, String string) {
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
                || (other instanceof TransactionProduct && this.string.equals(((TransactionProduct) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case APPOINTMENTS:
                return visitor.visitAppointments();
            case OTHER:
                return visitor.visitOther();
            case BILLING:
                return visitor.visitBilling();
            case INVOICES:
                return visitor.visitInvoices();
            case REGISTER:
                return visitor.visitRegister();
            case EXTERNAL_API:
                return visitor.visitExternalApi();
            case ONLINE_STORE:
                return visitor.visitOnlineStore();
            case PAYROLL:
                return visitor.visitPayroll();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TransactionProduct valueOf(String value) {
        switch (value) {
            case "APPOINTMENTS":
                return APPOINTMENTS;
            case "OTHER":
                return OTHER;
            case "BILLING":
                return BILLING;
            case "INVOICES":
                return INVOICES;
            case "REGISTER":
                return REGISTER;
            case "EXTERNAL_API":
                return EXTERNAL_API;
            case "ONLINE_STORE":
                return ONLINE_STORE;
            case "PAYROLL":
                return PAYROLL;
            default:
                return new TransactionProduct(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        REGISTER,

        EXTERNAL_API,

        BILLING,

        APPOINTMENTS,

        INVOICES,

        ONLINE_STORE,

        PAYROLL,

        OTHER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitRegister();

        T visitExternalApi();

        T visitBilling();

        T visitAppointments();

        T visitInvoices();

        T visitOnlineStore();

        T visitPayroll();

        T visitOther();

        T visitUnknown(String unknownType);
    }
}
