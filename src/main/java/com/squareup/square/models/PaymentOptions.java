
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PaymentOptions type.
 */
public class PaymentOptions {
    private final Boolean autocomplete;

    /**
     * Initialization constructor.
     * @param  autocomplete  Boolean value for autocomplete.
     */
    @JsonCreator
    public PaymentOptions(
            @JsonProperty("autocomplete") Boolean autocomplete) {
        this.autocomplete = autocomplete;
    }

    /**
     * Getter for Autocomplete.
     * Indicates whether the `Payment` objects created from this `TerminalCheckout` are
     * automatically `COMPLETED` or left in an `APPROVED` state for later modification.
     * @return Returns the Boolean
     */
    @JsonGetter("autocomplete")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAutocomplete() {
        return autocomplete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autocomplete);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOptions)) {
            return false;
        }
        PaymentOptions other = (PaymentOptions) obj;
        return Objects.equals(autocomplete, other.autocomplete);
    }

    /**
     * Converts this PaymentOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentOptions [" + "autocomplete=" + autocomplete + "]";
    }

    /**
     * Builds a new {@link PaymentOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .autocomplete(getAutocomplete());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentOptions}.
     */
    public static class Builder {
        private Boolean autocomplete;



        /**
         * Setter for autocomplete.
         * @param  autocomplete  Boolean value for autocomplete.
         * @return Builder
         */
        public Builder autocomplete(Boolean autocomplete) {
            this.autocomplete = autocomplete;
            return this;
        }

        /**
         * Builds a new {@link PaymentOptions} object using the set fields.
         * @return {@link PaymentOptions}
         */
        public PaymentOptions build() {
            return new PaymentOptions(autocomplete);
        }
    }
}
