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
@JsonDeserialize(builder = GetPaymentRefundResponse.Builder.class)
public final class GetPaymentRefundResponse {
    private final Optional<List<Error>> errors;

    private final Optional<PaymentRefund> refund;

    private final Map<String, Object> additionalProperties;

    private GetPaymentRefundResponse(
            Optional<List<Error>> errors, Optional<PaymentRefund> refund, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.refund = refund;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information about errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The requested <code>PaymentRefund</code>.
     */
    @JsonProperty("refund")
    public Optional<PaymentRefund> getRefund() {
        return refund;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetPaymentRefundResponse && equalTo((GetPaymentRefundResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetPaymentRefundResponse other) {
        return errors.equals(other.errors) && refund.equals(other.refund);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.refund);
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

        private Optional<PaymentRefund> refund = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetPaymentRefundResponse other) {
            errors(other.getErrors());
            refund(other.getRefund());
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

        @JsonSetter(value = "refund", nulls = Nulls.SKIP)
        public Builder refund(Optional<PaymentRefund> refund) {
            this.refund = refund;
            return this;
        }

        public Builder refund(PaymentRefund refund) {
            this.refund = Optional.ofNullable(refund);
            return this;
        }

        public GetPaymentRefundResponse build() {
            return new GetPaymentRefundResponse(errors, refund, additionalProperties);
        }
    }
}
