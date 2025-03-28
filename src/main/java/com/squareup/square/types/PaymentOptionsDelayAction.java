/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class PaymentOptionsDelayAction {
    public static final PaymentOptionsDelayAction CANCEL = new PaymentOptionsDelayAction(Value.CANCEL, "CANCEL");

    public static final PaymentOptionsDelayAction COMPLETE = new PaymentOptionsDelayAction(Value.COMPLETE, "COMPLETE");

    private final Value value;

    private final String string;

    PaymentOptionsDelayAction(Value value, String string) {
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
                || (other instanceof PaymentOptionsDelayAction
                        && this.string.equals(((PaymentOptionsDelayAction) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CANCEL:
                return visitor.visitCancel();
            case COMPLETE:
                return visitor.visitComplete();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentOptionsDelayAction valueOf(String value) {
        switch (value) {
            case "CANCEL":
                return CANCEL;
            case "COMPLETE":
                return COMPLETE;
            default:
                return new PaymentOptionsDelayAction(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CANCEL,

        COMPLETE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCancel();

        T visitComplete();

        T visitUnknown(String unknownType);
    }
}
