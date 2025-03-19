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
@JsonDeserialize(builder = BulkRetrieveCustomersResponse.Builder.class)
public final class BulkRetrieveCustomersResponse {
    private final Optional<Map<String, GetCustomerResponse>> responses;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private BulkRetrieveCustomersResponse(
            Optional<Map<String, GetCustomerResponse>> responses,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.responses = responses;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A map of responses that correspond to individual retrieve requests, represented by
     * key-value pairs.
     * <p>Each key is the customer ID that was specified for a retrieve request and each value
     * is the corresponding response.
     * If the request succeeds, the value is the requested customer profile.
     * If the request fails, the value contains any errors that occurred during the request.</p>
     */
    @JsonProperty("responses")
    public Optional<Map<String, GetCustomerResponse>> getResponses() {
        return responses;
    }

    /**
     * @return Any top-level errors that prevented the bulk operation from running.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkRetrieveCustomersResponse && equalTo((BulkRetrieveCustomersResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkRetrieveCustomersResponse other) {
        return responses.equals(other.responses) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.responses, this.errors);
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
        private Optional<Map<String, GetCustomerResponse>> responses = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkRetrieveCustomersResponse other) {
            responses(other.getResponses());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "responses", nulls = Nulls.SKIP)
        public Builder responses(Optional<Map<String, GetCustomerResponse>> responses) {
            this.responses = responses;
            return this;
        }

        public Builder responses(Map<String, GetCustomerResponse> responses) {
            this.responses = Optional.ofNullable(responses);
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

        public BulkRetrieveCustomersResponse build() {
            return new BulkRetrieveCustomersResponse(responses, errors, additionalProperties);
        }
    }
}
