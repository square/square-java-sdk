
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for PaymentOptions type.
 */
public class PaymentOptions {
    private final OptionalNullable<Boolean> autocomplete;
    private final OptionalNullable<String> delayDuration;
    private final OptionalNullable<Boolean> acceptPartialAuthorization;
    private final String delayAction;

    /**
     * Initialization constructor.
     * @param  autocomplete  Boolean value for autocomplete.
     * @param  delayDuration  String value for delayDuration.
     * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
     * @param  delayAction  String value for delayAction.
     */
    @JsonCreator
    public PaymentOptions(
            @JsonProperty("autocomplete") Boolean autocomplete,
            @JsonProperty("delay_duration") String delayDuration,
            @JsonProperty("accept_partial_authorization") Boolean acceptPartialAuthorization,
            @JsonProperty("delay_action") String delayAction) {
        this.autocomplete = OptionalNullable.of(autocomplete);
        this.delayDuration = OptionalNullable.of(delayDuration);
        this.acceptPartialAuthorization = OptionalNullable.of(acceptPartialAuthorization);
        this.delayAction = delayAction;
    }

    /**
     * Internal initialization constructor.
     */
    protected PaymentOptions(OptionalNullable<Boolean> autocomplete,
            OptionalNullable<String> delayDuration,
            OptionalNullable<Boolean> acceptPartialAuthorization, String delayAction) {
        this.autocomplete = autocomplete;
        this.delayDuration = delayDuration;
        this.acceptPartialAuthorization = acceptPartialAuthorization;
        this.delayAction = delayAction;
    }

    /**
     * Internal Getter for Autocomplete.
     * Indicates whether the `Payment` objects created from this `TerminalCheckout` are
     * automatically `COMPLETED` or left in an `APPROVED` state for later modification.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("autocomplete")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAutocomplete() {
        return this.autocomplete;
    }

    /**
     * Getter for Autocomplete.
     * Indicates whether the `Payment` objects created from this `TerminalCheckout` are
     * automatically `COMPLETED` or left in an `APPROVED` state for later modification.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAutocomplete() {
        return OptionalNullable.getFrom(autocomplete);
    }

    /**
     * Internal Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically cancels the
     * payment. This automatic cancellation applies only to payments that do not reach a terminal
     * state (COMPLETED or CANCELED) before the `delay_duration` time period. This parameter should
     * be specified as a time duration, in RFC 3339 format, with a minimum value of 1 minute. Note:
     * This feature is only supported for card payments. This parameter can only be set for a
     * delayed capture payment (`autocomplete=false`). Default: - Card-present payments: "PT36H" (36
     * hours) from the creation time. - Card-not-present payments: "P7D" (7 days) from the creation
     * time.
     * @return Returns the Internal String
     */
    @JsonGetter("delay_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDelayDuration() {
        return this.delayDuration;
    }

    /**
     * Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically cancels the
     * payment. This automatic cancellation applies only to payments that do not reach a terminal
     * state (COMPLETED or CANCELED) before the `delay_duration` time period. This parameter should
     * be specified as a time duration, in RFC 3339 format, with a minimum value of 1 minute. Note:
     * This feature is only supported for card payments. This parameter can only be set for a
     * delayed capture payment (`autocomplete=false`). Default: - Card-present payments: "PT36H" (36
     * hours) from the creation time. - Card-not-present payments: "P7D" (7 days) from the creation
     * time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDelayDuration() {
        return OptionalNullable.getFrom(delayDuration);
    }

    /**
     * Internal Getter for AcceptPartialAuthorization.
     * If set to `true` and charging a Square Gift Card, a payment might be returned with
     * `amount_money` equal to less than what was requested. For example, a request for $20 when
     * charging a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You
     * might choose to prompt the buyer for an additional payment to cover the remainder or cancel
     * the Gift Card payment. This field cannot be `true` when `autocomplete = true`. This field
     * cannot be `true` when an `order_id` isn't specified. For more information, see [Take Partial
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/partial-payments-with-gift-cards).
     * Default: false
     * @return Returns the Internal Boolean
     */
    @JsonGetter("accept_partial_authorization")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAcceptPartialAuthorization() {
        return this.acceptPartialAuthorization;
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
    @JsonIgnore
    public Boolean getAcceptPartialAuthorization() {
        return OptionalNullable.getFrom(acceptPartialAuthorization);
    }

    /**
     * Getter for DelayAction.
     * Describes the action to be applied to a delayed capture payment when the delay_duration has
     * elapsed.
     * @return Returns the String
     */
    @JsonGetter("delay_action")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDelayAction() {
        return delayAction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autocomplete, delayDuration, acceptPartialAuthorization, delayAction);
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
            && Objects.equals(acceptPartialAuthorization, other.acceptPartialAuthorization)
            && Objects.equals(delayAction, other.delayAction);
    }

    /**
     * Converts this PaymentOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentOptions [" + "autocomplete=" + autocomplete + ", delayDuration="
                + delayDuration + ", acceptPartialAuthorization=" + acceptPartialAuthorization
                + ", delayAction=" + delayAction + "]";
    }

    /**
     * Builds a new {@link PaymentOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .delayAction(getDelayAction());
        builder.autocomplete = internalGetAutocomplete();
        builder.delayDuration = internalGetDelayDuration();
        builder.acceptPartialAuthorization = internalGetAcceptPartialAuthorization();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentOptions}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> autocomplete;
        private OptionalNullable<String> delayDuration;
        private OptionalNullable<Boolean> acceptPartialAuthorization;
        private String delayAction;



        /**
         * Setter for autocomplete.
         * @param  autocomplete  Boolean value for autocomplete.
         * @return Builder
         */
        public Builder autocomplete(Boolean autocomplete) {
            this.autocomplete = OptionalNullable.of(autocomplete);
            return this;
        }

        /**
         * UnSetter for autocomplete.
         * @return Builder
         */
        public Builder unsetAutocomplete() {
            autocomplete = null;
            return this;
        }

        /**
         * Setter for delayDuration.
         * @param  delayDuration  String value for delayDuration.
         * @return Builder
         */
        public Builder delayDuration(String delayDuration) {
            this.delayDuration = OptionalNullable.of(delayDuration);
            return this;
        }

        /**
         * UnSetter for delayDuration.
         * @return Builder
         */
        public Builder unsetDelayDuration() {
            delayDuration = null;
            return this;
        }

        /**
         * Setter for acceptPartialAuthorization.
         * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
         * @return Builder
         */
        public Builder acceptPartialAuthorization(Boolean acceptPartialAuthorization) {
            this.acceptPartialAuthorization = OptionalNullable.of(acceptPartialAuthorization);
            return this;
        }

        /**
         * UnSetter for acceptPartialAuthorization.
         * @return Builder
         */
        public Builder unsetAcceptPartialAuthorization() {
            acceptPartialAuthorization = null;
            return this;
        }

        /**
         * Setter for delayAction.
         * @param  delayAction  String value for delayAction.
         * @return Builder
         */
        public Builder delayAction(String delayAction) {
            this.delayAction = delayAction;
            return this;
        }

        /**
         * Builds a new {@link PaymentOptions} object using the set fields.
         * @return {@link PaymentOptions}
         */
        public PaymentOptions build() {
            return new PaymentOptions(autocomplete, delayDuration, acceptPartialAuthorization,
                    delayAction);
        }
    }
}
