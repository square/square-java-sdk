
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityClearBalance type.
 */
public class GiftCardActivityClearBalance {
    private final String reason;

    /**
     * Initialization constructor.
     * @param  reason  String value for reason.
     */
    @JsonCreator
    public GiftCardActivityClearBalance(
            @JsonProperty("reason") String reason) {
        this.reason = reason;
    }

    /**
     * Getter for Reason.
     * Indicates the reason for clearing the balance of a [gift card]($m/GiftCard).
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return reason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityClearBalance)) {
            return false;
        }
        GiftCardActivityClearBalance other = (GiftCardActivityClearBalance) obj;
        return Objects.equals(reason, other.reason);
    }

    /**
     * Converts this GiftCardActivityClearBalance into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityClearBalance [" + "reason=" + reason + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityClearBalance.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityClearBalance.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(reason);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityClearBalance}.
     */
    public static class Builder {
        private String reason;

        /**
         * Initialization constructor.
         * @param  reason  String value for reason.
         */
        public Builder(String reason) {
            this.reason = reason;
        }

        /**
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivityClearBalance} object using the set fields.
         * @return {@link GiftCardActivityClearBalance}
         */
        public GiftCardActivityClearBalance build() {
            return new GiftCardActivityClearBalance(reason);
        }
    }
}
