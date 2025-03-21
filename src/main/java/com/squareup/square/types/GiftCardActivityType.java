/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class GiftCardActivityType {
    public static final GiftCardActivityType UNLINKED_ACTIVITY_REFUND =
            new GiftCardActivityType(Value.UNLINKED_ACTIVITY_REFUND, "UNLINKED_ACTIVITY_REFUND");

    public static final GiftCardActivityType CLEAR_BALANCE =
            new GiftCardActivityType(Value.CLEAR_BALANCE, "CLEAR_BALANCE");

    public static final GiftCardActivityType REFUND = new GiftCardActivityType(Value.REFUND, "REFUND");

    public static final GiftCardActivityType LOAD = new GiftCardActivityType(Value.LOAD, "LOAD");

    public static final GiftCardActivityType TRANSFER_BALANCE_TO =
            new GiftCardActivityType(Value.TRANSFER_BALANCE_TO, "TRANSFER_BALANCE_TO");

    public static final GiftCardActivityType UNBLOCK = new GiftCardActivityType(Value.UNBLOCK, "UNBLOCK");

    public static final GiftCardActivityType ACTIVATE = new GiftCardActivityType(Value.ACTIVATE, "ACTIVATE");

    public static final GiftCardActivityType ADJUST_INCREMENT =
            new GiftCardActivityType(Value.ADJUST_INCREMENT, "ADJUST_INCREMENT");

    public static final GiftCardActivityType ADJUST_DECREMENT =
            new GiftCardActivityType(Value.ADJUST_DECREMENT, "ADJUST_DECREMENT");

    public static final GiftCardActivityType DEACTIVATE = new GiftCardActivityType(Value.DEACTIVATE, "DEACTIVATE");

    public static final GiftCardActivityType IMPORT_REVERSAL =
            new GiftCardActivityType(Value.IMPORT_REVERSAL, "IMPORT_REVERSAL");

    public static final GiftCardActivityType BLOCK = new GiftCardActivityType(Value.BLOCK, "BLOCK");

    public static final GiftCardActivityType TRANSFER_BALANCE_FROM =
            new GiftCardActivityType(Value.TRANSFER_BALANCE_FROM, "TRANSFER_BALANCE_FROM");

    public static final GiftCardActivityType REDEEM = new GiftCardActivityType(Value.REDEEM, "REDEEM");

    public static final GiftCardActivityType IMPORT = new GiftCardActivityType(Value.IMPORT, "IMPORT");

    private final Value value;

    private final String string;

    GiftCardActivityType(Value value, String string) {
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
                || (other instanceof GiftCardActivityType && this.string.equals(((GiftCardActivityType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case UNLINKED_ACTIVITY_REFUND:
                return visitor.visitUnlinkedActivityRefund();
            case CLEAR_BALANCE:
                return visitor.visitClearBalance();
            case REFUND:
                return visitor.visitRefund();
            case LOAD:
                return visitor.visitLoad();
            case TRANSFER_BALANCE_TO:
                return visitor.visitTransferBalanceTo();
            case UNBLOCK:
                return visitor.visitUnblock();
            case ACTIVATE:
                return visitor.visitActivate();
            case ADJUST_INCREMENT:
                return visitor.visitAdjustIncrement();
            case ADJUST_DECREMENT:
                return visitor.visitAdjustDecrement();
            case DEACTIVATE:
                return visitor.visitDeactivate();
            case IMPORT_REVERSAL:
                return visitor.visitImportReversal();
            case BLOCK:
                return visitor.visitBlock();
            case TRANSFER_BALANCE_FROM:
                return visitor.visitTransferBalanceFrom();
            case REDEEM:
                return visitor.visitRedeem();
            case IMPORT:
                return visitor.visitImport();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GiftCardActivityType valueOf(String value) {
        switch (value) {
            case "UNLINKED_ACTIVITY_REFUND":
                return UNLINKED_ACTIVITY_REFUND;
            case "CLEAR_BALANCE":
                return CLEAR_BALANCE;
            case "REFUND":
                return REFUND;
            case "LOAD":
                return LOAD;
            case "TRANSFER_BALANCE_TO":
                return TRANSFER_BALANCE_TO;
            case "UNBLOCK":
                return UNBLOCK;
            case "ACTIVATE":
                return ACTIVATE;
            case "ADJUST_INCREMENT":
                return ADJUST_INCREMENT;
            case "ADJUST_DECREMENT":
                return ADJUST_DECREMENT;
            case "DEACTIVATE":
                return DEACTIVATE;
            case "IMPORT_REVERSAL":
                return IMPORT_REVERSAL;
            case "BLOCK":
                return BLOCK;
            case "TRANSFER_BALANCE_FROM":
                return TRANSFER_BALANCE_FROM;
            case "REDEEM":
                return REDEEM;
            case "IMPORT":
                return IMPORT;
            default:
                return new GiftCardActivityType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ACTIVATE,

        LOAD,

        REDEEM,

        CLEAR_BALANCE,

        DEACTIVATE,

        ADJUST_INCREMENT,

        ADJUST_DECREMENT,

        REFUND,

        UNLINKED_ACTIVITY_REFUND,

        IMPORT,

        BLOCK,

        UNBLOCK,

        IMPORT_REVERSAL,

        TRANSFER_BALANCE_FROM,

        TRANSFER_BALANCE_TO,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitActivate();

        T visitLoad();

        T visitRedeem();

        T visitClearBalance();

        T visitDeactivate();

        T visitAdjustIncrement();

        T visitAdjustDecrement();

        T visitRefund();

        T visitUnlinkedActivityRefund();

        T visitImport();

        T visitBlock();

        T visitUnblock();

        T visitImportReversal();

        T visitTransferBalanceFrom();

        T visitTransferBalanceTo();

        T visitUnknown(String unknownType);
    }
}
