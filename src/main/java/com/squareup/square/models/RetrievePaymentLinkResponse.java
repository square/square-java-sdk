
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrievePaymentLinkResponse type.
 */
public class RetrievePaymentLinkResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final PaymentLink paymentLink;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  paymentLink  PaymentLink value for paymentLink.
     */
    @JsonCreator
    public RetrievePaymentLinkResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment_link") PaymentLink paymentLink) {
        this.errors = errors;
        this.paymentLink = paymentLink;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for PaymentLink.
     * @return Returns the PaymentLink
     */
    @JsonGetter("payment_link")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentLink getPaymentLink() {
        return paymentLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, paymentLink);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrievePaymentLinkResponse)) {
            return false;
        }
        RetrievePaymentLinkResponse other = (RetrievePaymentLinkResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(paymentLink, other.paymentLink);
    }

    /**
     * Converts this RetrievePaymentLinkResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrievePaymentLinkResponse [" + "errors=" + errors + ", paymentLink=" + paymentLink
                + "]";
    }

    /**
     * Builds a new {@link RetrievePaymentLinkResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrievePaymentLinkResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .paymentLink(getPaymentLink());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrievePaymentLinkResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private PaymentLink paymentLink;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
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
         * Builds a new {@link RetrievePaymentLinkResponse} object using the set fields.
         * @return {@link RetrievePaymentLinkResponse}
         */
        public RetrievePaymentLinkResponse build() {
            RetrievePaymentLinkResponse model =
                    new RetrievePaymentLinkResponse(errors, paymentLink);
            model.httpContext = httpContext;
            return model;
        }
    }
}
