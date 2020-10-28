
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CreateTerminalCheckoutRequest type.
 */
public class CreateTerminalCheckoutRequest {
    private final String idempotencyKey;
    private final TerminalCheckout checkout;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param checkout TerminalCheckout value for checkout.
     */
    @JsonCreator
    public CreateTerminalCheckoutRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("checkout") TerminalCheckout checkout) {
        this.idempotencyKey = idempotencyKey;
        this.checkout = checkout;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateCheckout` request. Keys can be any valid string
     * but must be unique for every `CreateCheckout` request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Checkout.
     * @return Returns the TerminalCheckout
     */
    @JsonGetter("checkout")
    public TerminalCheckout getCheckout() {
        return this.checkout;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, checkout);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateTerminalCheckoutRequest)) {
            return false;
        }
        CreateTerminalCheckoutRequest other = (CreateTerminalCheckoutRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(checkout, other.checkout);
    }

    /**
     * Builds a new {@link CreateTerminalCheckoutRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTerminalCheckoutRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            checkout);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateTerminalCheckoutRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private TerminalCheckout checkout;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         * @param checkout TerminalCheckout value for checkout.
         */
        public Builder(String idempotencyKey,
                TerminalCheckout checkout) {
            this.idempotencyKey = idempotencyKey;
            this.checkout = checkout;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for checkout.
         * @param checkout TerminalCheckout value for checkout.
         * @return Builder
         */
        public Builder checkout(TerminalCheckout checkout) {
            this.checkout = checkout;
            return this;
        }

        /**
         * Builds a new {@link CreateTerminalCheckoutRequest} object using the set fields.
         * @return {@link CreateTerminalCheckoutRequest}
         */
        public CreateTerminalCheckoutRequest build() {
            return new CreateTerminalCheckoutRequest(idempotencyKey,
                checkout);
        }
    }
}
