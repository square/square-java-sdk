/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class Product {
    public static final Product ITEM_LIBRARY_IMPORT = new Product(Value.ITEM_LIBRARY_IMPORT, "ITEM_LIBRARY_IMPORT");

    public static final Product APPOINTMENTS = new Product(Value.APPOINTMENTS, "APPOINTMENTS");

    public static final Product OTHER = new Product(Value.OTHER, "OTHER");

    public static final Product BILLING = new Product(Value.BILLING, "BILLING");

    public static final Product INVOICES = new Product(Value.INVOICES, "INVOICES");

    public static final Product DASHBOARD = new Product(Value.DASHBOARD, "DASHBOARD");

    public static final Product SQUARE_POS = new Product(Value.SQUARE_POS, "SQUARE_POS");

    public static final Product EXTERNAL_API = new Product(Value.EXTERNAL_API, "EXTERNAL_API");

    public static final Product ONLINE_STORE = new Product(Value.ONLINE_STORE, "ONLINE_STORE");

    public static final Product PAYROLL = new Product(Value.PAYROLL, "PAYROLL");

    private final Value value;

    private final String string;

    Product(Value value, String string) {
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
        return (this == other) || (other instanceof Product && this.string.equals(((Product) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ITEM_LIBRARY_IMPORT:
                return visitor.visitItemLibraryImport();
            case APPOINTMENTS:
                return visitor.visitAppointments();
            case OTHER:
                return visitor.visitOther();
            case BILLING:
                return visitor.visitBilling();
            case INVOICES:
                return visitor.visitInvoices();
            case DASHBOARD:
                return visitor.visitDashboard();
            case SQUARE_POS:
                return visitor.visitSquarePos();
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
    public static Product valueOf(String value) {
        switch (value) {
            case "ITEM_LIBRARY_IMPORT":
                return ITEM_LIBRARY_IMPORT;
            case "APPOINTMENTS":
                return APPOINTMENTS;
            case "OTHER":
                return OTHER;
            case "BILLING":
                return BILLING;
            case "INVOICES":
                return INVOICES;
            case "DASHBOARD":
                return DASHBOARD;
            case "SQUARE_POS":
                return SQUARE_POS;
            case "EXTERNAL_API":
                return EXTERNAL_API;
            case "ONLINE_STORE":
                return ONLINE_STORE;
            case "PAYROLL":
                return PAYROLL;
            default:
                return new Product(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SQUARE_POS,

        EXTERNAL_API,

        BILLING,

        APPOINTMENTS,

        INVOICES,

        ONLINE_STORE,

        PAYROLL,

        DASHBOARD,

        ITEM_LIBRARY_IMPORT,

        OTHER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSquarePos();

        T visitExternalApi();

        T visitBilling();

        T visitAppointments();

        T visitInvoices();

        T visitOnlineStore();

        T visitPayroll();

        T visitDashboard();

        T visitItemLibraryImport();

        T visitOther();

        T visitUnknown(String unknownType);
    }
}
