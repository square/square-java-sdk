package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreatePaymentLinkResponse type.
 */
public class CreatePaymentLinkResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final PaymentLink paymentLink;
    private final PaymentLinkRelatedResources relatedResources;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  paymentLink  PaymentLink value for paymentLink.
     * @param  relatedResources  PaymentLinkRelatedResources value for relatedResources.
     */
    @JsonCreator
    public CreatePaymentLinkResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment_link") PaymentLink paymentLink,
            @JsonProperty("related_resources") PaymentLinkRelatedResources relatedResources) {
        this.errors = errors;
        this.paymentLink = paymentLink;
        this.relatedResources = relatedResources;
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

    /**
     * Getter for RelatedResources.
     * @return Returns the PaymentLinkRelatedResources
     */
    @JsonGetter("related_resources")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentLinkRelatedResources getRelatedResources() {
        return relatedResources;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, paymentLink, relatedResources);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreatePaymentLinkResponse)) {
            return false;
        }
        CreatePaymentLinkResponse other = (CreatePaymentLinkResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(paymentLink, other.paymentLink)
                && Objects.equals(relatedResources, other.relatedResources);
    }

    /**
     * Converts this CreatePaymentLinkResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreatePaymentLinkResponse [" + "errors=" + errors + ", paymentLink=" + paymentLink
                + ", relatedResources=" + relatedResources + "]";
    }

    /**
     * Builds a new {@link CreatePaymentLinkResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreatePaymentLinkResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder =
                new Builder().errors(getErrors()).paymentLink(getPaymentLink()).relatedResources(getRelatedResources());
        return builder;
    }

    /**
     * Class to build instances of {@link CreatePaymentLinkResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private PaymentLink paymentLink;
        private PaymentLinkRelatedResources relatedResources;

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
         * Setter for relatedResources.
         * @param  relatedResources  PaymentLinkRelatedResources value for relatedResources.
         * @return Builder
         */
        public Builder relatedResources(PaymentLinkRelatedResources relatedResources) {
            this.relatedResources = relatedResources;
            return this;
        }

        /**
         * Builds a new {@link CreatePaymentLinkResponse} object using the set fields.
         * @return {@link CreatePaymentLinkResponse}
         */
        public CreatePaymentLinkResponse build() {
            CreatePaymentLinkResponse model = new CreatePaymentLinkResponse(errors, paymentLink, relatedResources);
            model.httpContext = httpContext;
            return model;
        }
    }
}
