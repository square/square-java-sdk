
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityDeactivate type.
 */
public class GiftCardActivityDeactivate {
    private final String reason;

    /**
     * Initialization constructor.
     * @param  reason  String value for reason.
     */
    @JsonCreator
    public GiftCardActivityDeactivate(
            @JsonProperty("reason") String reason) {
        this.reason = reason;
    }

    /**
     * Getter for Reason.
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
        if (!(obj instanceof GiftCardActivityDeactivate)) {
            return false;
        }
        GiftCardActivityDeactivate other = (GiftCardActivityDeactivate) obj;
        return Objects.equals(reason, other.reason);
    }

    /**
     * Converts this GiftCardActivityDeactivate into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityDeactivate [" + "reason=" + reason + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityDeactivate.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityDeactivate.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(reason);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityDeactivate}.
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
         * Builds a new {@link GiftCardActivityDeactivate} object using the set fields.
         * @return {@link GiftCardActivityDeactivate}
         */
        public GiftCardActivityDeactivate build() {
            return new GiftCardActivityDeactivate(reason);
        }
    }
}
