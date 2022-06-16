
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityUnblock type.
 */
public class GiftCardActivityUnblock {
    private final String reason;

    /**
     * Initialization constructor.
     * @param  reason  String value for reason.
     */
    @JsonCreator
    public GiftCardActivityUnblock(
            @JsonProperty("reason") String reason) {
        this.reason = reason;
    }

    /**
     * Getter for Reason.
     * Indicates the reason for unblocking a [gift card]($m/GiftCard).
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
        if (!(obj instanceof GiftCardActivityUnblock)) {
            return false;
        }
        GiftCardActivityUnblock other = (GiftCardActivityUnblock) obj;
        return Objects.equals(reason, other.reason);
    }

    /**
     * Converts this GiftCardActivityUnblock into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityUnblock [" + "reason=" + reason + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityUnblock.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityUnblock.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(reason);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityUnblock}.
     */
    public static class Builder {
        private String reason = "CHARGEBACK_UNBLOCK";

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
         * Builds a new {@link GiftCardActivityUnblock} object using the set fields.
         * @return {@link GiftCardActivityUnblock}
         */
        public GiftCardActivityUnblock build() {
            return new GiftCardActivityUnblock(reason);
        }
    }
}
