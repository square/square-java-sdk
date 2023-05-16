
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdatePaymentLinkRequest type.
 */
public class UpdatePaymentLinkRequest {
    private final PaymentLink paymentLink;

    /**
     * Initialization constructor.
     * @param  paymentLink  PaymentLink value for paymentLink.
     */
    @JsonCreator
    public UpdatePaymentLinkRequest(
            @JsonProperty("payment_link") PaymentLink paymentLink) {
        this.paymentLink = paymentLink;
    }

    /**
     * Getter for PaymentLink.
     * @return Returns the PaymentLink
     */
    @JsonGetter("payment_link")
    public PaymentLink getPaymentLink() {
        return paymentLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentLink);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdatePaymentLinkRequest)) {
            return false;
        }
        UpdatePaymentLinkRequest other = (UpdatePaymentLinkRequest) obj;
        return Objects.equals(paymentLink, other.paymentLink);
    }

    /**
     * Converts this UpdatePaymentLinkRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdatePaymentLinkRequest [" + "paymentLink=" + paymentLink + "]";
    }

    /**
     * Builds a new {@link UpdatePaymentLinkRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdatePaymentLinkRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(paymentLink);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdatePaymentLinkRequest}.
     */
    public static class Builder {
        private PaymentLink paymentLink;

        /**
         * Initialization constructor.
         * @param  paymentLink  PaymentLink value for paymentLink.
         */
        public Builder(PaymentLink paymentLink) {
            this.paymentLink = paymentLink;
        }

        /**
         * Setter for paymentLink.
         * @param  paymentLink  PaymentLink value for paymentLink.
         * @return Builder
         */
        public Builder paymentLink(PaymentLink paymentLink) {
            this.paymentLink = paymentLink;
            return this;
        }

        /**
         * Builds a new {@link UpdatePaymentLinkRequest} object using the set fields.
         * @return {@link UpdatePaymentLinkRequest}
         */
        public UpdatePaymentLinkRequest build() {
            return new UpdatePaymentLinkRequest(paymentLink);
        }
    }
}
