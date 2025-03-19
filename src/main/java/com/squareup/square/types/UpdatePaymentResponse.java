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
@JsonDeserialize(builder = UpdatePaymentResponse.Builder.class)
public final class UpdatePaymentResponse {
    private final Optional<List<Error>> errors;

    private final Optional<Payment> payment;

    private final Map<String, Object> additionalProperties;

    private UpdatePaymentResponse(
            Optional<List<Error>> errors, Optional<Payment> payment, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.payment = payment;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The updated payment.
     */
    @JsonProperty("payment")
    public Optional<Payment> getPayment() {
        return payment;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdatePaymentResponse && equalTo((UpdatePaymentResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdatePaymentResponse other) {
        return errors.equals(other.errors) && payment.equals(other.payment);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.payment);
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

        private Optional<Payment> payment = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdatePaymentResponse other) {
            errors(other.getErrors());
            payment(other.getPayment());
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

        @JsonSetter(value = "payment", nulls = Nulls.SKIP)
        public Builder payment(Optional<Payment> payment) {
            this.payment = payment;
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = Optional.ofNullable(payment);
            return this;
        }

        public UpdatePaymentResponse build() {
            return new UpdatePaymentResponse(errors, payment, additionalProperties);
        }
    }
}
