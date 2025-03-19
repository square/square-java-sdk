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
@JsonDeserialize(builder = CancelTerminalRefundResponse.Builder.class)
public final class CancelTerminalRefundResponse {
    private final Optional<List<Error>> errors;

    private final Optional<TerminalRefund> refund;

    private final Map<String, Object> additionalProperties;

    private CancelTerminalRefundResponse(
            Optional<List<Error>> errors, Optional<TerminalRefund> refund, Map<String, Object> additionalProperties) {
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
     * @return The updated <code>TerminalRefund</code>.
     */
    @JsonProperty("refund")
    public Optional<TerminalRefund> getRefund() {
        return refund;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CancelTerminalRefundResponse && equalTo((CancelTerminalRefundResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CancelTerminalRefundResponse other) {
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

        private Optional<TerminalRefund> refund = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CancelTerminalRefundResponse other) {
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
        public Builder refund(Optional<TerminalRefund> refund) {
            this.refund = refund;
            return this;
        }

        public Builder refund(TerminalRefund refund) {
            this.refund = Optional.ofNullable(refund);
            return this;
        }

        public CancelTerminalRefundResponse build() {
            return new CancelTerminalRefundResponse(errors, refund, additionalProperties);
        }
    }
}
