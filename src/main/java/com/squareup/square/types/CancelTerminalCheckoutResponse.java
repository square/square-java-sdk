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
@JsonDeserialize(builder = CancelTerminalCheckoutResponse.Builder.class)
public final class CancelTerminalCheckoutResponse {
    private final Optional<List<Error>> errors;

    private final Optional<TerminalCheckout> checkout;

    private final Map<String, Object> additionalProperties;

    private CancelTerminalCheckoutResponse(
            Optional<List<Error>> errors,
            Optional<TerminalCheckout> checkout,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.checkout = checkout;
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
     * @return The canceled <code>TerminalCheckout</code>.
     */
    @JsonProperty("checkout")
    public Optional<TerminalCheckout> getCheckout() {
        return checkout;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CancelTerminalCheckoutResponse && equalTo((CancelTerminalCheckoutResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CancelTerminalCheckoutResponse other) {
        return errors.equals(other.errors) && checkout.equals(other.checkout);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.checkout);
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

        private Optional<TerminalCheckout> checkout = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CancelTerminalCheckoutResponse other) {
            errors(other.getErrors());
            checkout(other.getCheckout());
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

        @JsonSetter(value = "checkout", nulls = Nulls.SKIP)
        public Builder checkout(Optional<TerminalCheckout> checkout) {
            this.checkout = checkout;
            return this;
        }

        public Builder checkout(TerminalCheckout checkout) {
            this.checkout = Optional.ofNullable(checkout);
            return this;
        }

        public CancelTerminalCheckoutResponse build() {
            return new CancelTerminalCheckoutResponse(errors, checkout, additionalProperties);
        }
    }
}
