
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
    private final String delayDuration;
    private final Boolean acceptPartialAuthorization;

    /**
     * Initialization constructor.
     * @param  autocomplete  Boolean value for autocomplete.
     * @param  delayDuration  String value for delayDuration.
     * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
     */
    @JsonCreator
    public PaymentOptions(
            @JsonProperty("autocomplete") Boolean autocomplete,
            @JsonProperty("delay_duration") String delayDuration,
            @JsonProperty("accept_partial_authorization") Boolean acceptPartialAuthorization) {
        this.autocomplete = autocomplete;
        this.delayDuration = delayDuration;
        this.acceptPartialAuthorization = acceptPartialAuthorization;
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

    /**
     * Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically cancels the
     * payment. This automatic cancellation applies only to payments that do not reach a terminal
     * state (COMPLETED, CANCELED, or FAILED) before the `delay_duration` time period. This
     * parameter should be specified as a time duration, in RFC 3339 format, with a minimum value of
     * 1 minute. Note: This feature is only supported for card payments. This parameter can only be
     * set for a delayed capture payment (`autocomplete=false`). Default: - Card-present payments:
     * "PT36H" (36 hours) from the creation time. - Card-not-present payments: "P7D" (7 days) from
     * the creation time.
     * @return Returns the String
     */
    @JsonGetter("delay_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDelayDuration() {
        return delayDuration;
    }

    /**
     * Getter for AcceptPartialAuthorization.
     * If set to `true` and charging a Square Gift Card, a payment might be returned with
     * `amount_money` equal to less than what was requested. For example, a request for $20 when
     * charging a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You
     * might choose to prompt the buyer for an additional payment to cover the remainder or cancel
     * the Gift Card payment. This field cannot be `true` when `autocomplete = true`. This field
     * cannot be `true` when an `order_id` isn't specified. For more information, see [Take Partial
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/partial-payments-with-gift-cards).
     * Default: false
     * @return Returns the Boolean
     */
    @JsonGetter("accept_partial_authorization")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAcceptPartialAuthorization() {
        return acceptPartialAuthorization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autocomplete, delayDuration, acceptPartialAuthorization);
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
        return Objects.equals(autocomplete, other.autocomplete)
            && Objects.equals(delayDuration, other.delayDuration)
            && Objects.equals(acceptPartialAuthorization, other.acceptPartialAuthorization);
    }

    /**
     * Converts this PaymentOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentOptions [" + "autocomplete=" + autocomplete + ", delayDuration="
                + delayDuration + ", acceptPartialAuthorization=" + acceptPartialAuthorization
                + "]";
    }

    /**
     * Builds a new {@link PaymentOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .autocomplete(getAutocomplete())
                .delayDuration(getDelayDuration())
                .acceptPartialAuthorization(getAcceptPartialAuthorization());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentOptions}.
     */
    public static class Builder {
        private Boolean autocomplete;
        private String delayDuration;
        private Boolean acceptPartialAuthorization;



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
         * Setter for delayDuration.
         * @param  delayDuration  String value for delayDuration.
         * @return Builder
         */
        public Builder delayDuration(String delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        /**
         * Setter for acceptPartialAuthorization.
         * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
         * @return Builder
         */
        public Builder acceptPartialAuthorization(Boolean acceptPartialAuthorization) {
            this.acceptPartialAuthorization = acceptPartialAuthorization;
            return this;
        }

        /**
         * Builds a new {@link PaymentOptions} object using the set fields.
         * @return {@link PaymentOptions}
         */
        public PaymentOptions build() {
            return new PaymentOptions(autocomplete, delayDuration, acceptPartialAuthorization);
        }
    }
}
