/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class BusinessAppointmentSettingsCancellationPolicy {
    public static final BusinessAppointmentSettingsCancellationPolicy CUSTOM_POLICY =
            new BusinessAppointmentSettingsCancellationPolicy(Value.CUSTOM_POLICY, "CUSTOM_POLICY");

    public static final BusinessAppointmentSettingsCancellationPolicy CANCELLATION_TREATED_AS_NO_SHOW =
            new BusinessAppointmentSettingsCancellationPolicy(
                    Value.CANCELLATION_TREATED_AS_NO_SHOW, "CANCELLATION_TREATED_AS_NO_SHOW");

    private final Value value;

    private final String string;

    BusinessAppointmentSettingsCancellationPolicy(Value value, String string) {
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
                || (other instanceof BusinessAppointmentSettingsCancellationPolicy
                        && this.string.equals(((BusinessAppointmentSettingsCancellationPolicy) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CUSTOM_POLICY:
                return visitor.visitCustomPolicy();
            case CANCELLATION_TREATED_AS_NO_SHOW:
                return visitor.visitCancellationTreatedAsNoShow();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BusinessAppointmentSettingsCancellationPolicy valueOf(String value) {
        switch (value) {
            case "CUSTOM_POLICY":
                return CUSTOM_POLICY;
            case "CANCELLATION_TREATED_AS_NO_SHOW":
                return CANCELLATION_TREATED_AS_NO_SHOW;
            default:
                return new BusinessAppointmentSettingsCancellationPolicy(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CANCELLATION_TREATED_AS_NO_SHOW,

        CUSTOM_POLICY,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCancellationTreatedAsNoShow();

        T visitCustomPolicy();

        T visitUnknown(String unknownType);
    }
}
