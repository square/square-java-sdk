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
@JsonDeserialize(builder = ListPayoutsResponse.Builder.class)
public final class ListPayoutsResponse {
    private final Optional<List<Payout>> payouts;

    private final Optional<String> cursor;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private ListPayoutsResponse(
            Optional<List<Payout>> payouts,
            Optional<String> cursor,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.payouts = payouts;
        this.cursor = cursor;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The requested list of payouts.
     */
    @JsonProperty("payouts")
    public Optional<List<Payout>> getPayouts() {
        return payouts;
    }

    /**
     * @return The pagination cursor to be used in a subsequent request. If empty, this is the final response.
     * For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Information about errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListPayoutsResponse && equalTo((ListPayoutsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListPayoutsResponse other) {
        return payouts.equals(other.payouts) && cursor.equals(other.cursor) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.payouts, this.cursor, this.errors);
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
        private Optional<List<Payout>> payouts = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListPayoutsResponse other) {
            payouts(other.getPayouts());
            cursor(other.getCursor());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "payouts", nulls = Nulls.SKIP)
        public Builder payouts(Optional<List<Payout>> payouts) {
            this.payouts = payouts;
            return this;
        }

        public Builder payouts(List<Payout> payouts) {
            this.payouts = Optional.ofNullable(payouts);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
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

        public ListPayoutsResponse build() {
            return new ListPayoutsResponse(payouts, cursor, errors, additionalProperties);
        }
    }
}
