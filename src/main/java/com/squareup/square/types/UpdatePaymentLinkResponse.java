/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdatePaymentLinkResponse.Builder.class)
public final class UpdatePaymentLinkResponse {
    private final Optional<List<Error>> errors;

    private final Optional<PaymentLink> paymentLink;

    private final Map<String, Object> additionalProperties;

    private UpdatePaymentLinkResponse(
            Optional<List<Error>> errors, Optional<PaymentLink> paymentLink, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.paymentLink = paymentLink;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred when updating the payment link.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The updated payment link.
     */
    @JsonProperty("payment_link")
    public Optional<PaymentLink> getPaymentLink() {
        return paymentLink;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdatePaymentLinkResponse && equalTo((UpdatePaymentLinkResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdatePaymentLinkResponse other) {
        return errors.equals(other.errors) && paymentLink.equals(other.paymentLink);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.paymentLink);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<PaymentLink> paymentLink = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdatePaymentLinkResponse other) {
            errors(other.getErrors());
            paymentLink(other.getPaymentLink());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "payment_link", nulls = Nulls.SKIP)
        public Builder paymentLink(Optional<PaymentLink> paymentLink) {
            this.paymentLink = paymentLink;
            return this;
        }

        public Builder paymentLink(PaymentLink paymentLink) {
            this.paymentLink = Optional.ofNullable(paymentLink);
            return this;
        }

        public UpdatePaymentLinkResponse build() {
            return new UpdatePaymentLinkResponse(errors, paymentLink, additionalProperties);
        }
    }
}
