package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for PaymentOptions type.
 */
public class PaymentOptions {

    /**
     * Initialization constructor.
     * @param autocomplete
     */
    @JsonCreator
    public PaymentOptions(
            @JsonProperty("autocomplete") Boolean autocomplete) {
        this.autocomplete = autocomplete;
    }

    private final Boolean autocomplete;
    /**
     * Getter for Autocomplete.
     * Indicates whether the Payment objects created from this `TerminalCheckout` will automatically be
     * COMPLETED or left in an APPROVED state for later modification.
     */
    @JsonGetter("autocomplete")
    public Boolean getAutocomplete() {
        return this.autocomplete;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(autocomplete);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof PaymentOptions)) {
            return false;
        }
        PaymentOptions paymentOptions = (PaymentOptions) obj;
        return Objects.equals(autocomplete, paymentOptions.autocomplete);
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
     * Class to build instances of {@link PaymentOptions}
     */
    public static class Builder {
        private Boolean autocomplete;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for autocomplete
         * @param autocomplete
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
