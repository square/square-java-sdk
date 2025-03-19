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
@JsonDeserialize(builder = SearchInvoicesResponse.Builder.class)
public final class SearchInvoicesResponse {
    private final Optional<List<Invoice>> invoices;

    private final Optional<String> cursor;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private SearchInvoicesResponse(
            Optional<List<Invoice>> invoices,
            Optional<String> cursor,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.invoices = invoices;
        this.cursor = cursor;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The list of invoices returned by the search.
     */
    @JsonProperty("invoices")
    public Optional<List<Invoice>> getInvoices() {
        return invoices;
    }

    /**
     * @return When a response is truncated, it includes a cursor that you can use in a
     * subsequent request to fetch the next set of invoices. If empty, this is the final
     * response.
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
        return other instanceof SearchInvoicesResponse && equalTo((SearchInvoicesResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchInvoicesResponse other) {
        return invoices.equals(other.invoices) && cursor.equals(other.cursor) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.invoices, this.cursor, this.errors);
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
        private Optional<List<Invoice>> invoices = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchInvoicesResponse other) {
            invoices(other.getInvoices());
            cursor(other.getCursor());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "invoices", nulls = Nulls.SKIP)
        public Builder invoices(Optional<List<Invoice>> invoices) {
            this.invoices = invoices;
            return this;
        }

        public Builder invoices(List<Invoice> invoices) {
            this.invoices = Optional.ofNullable(invoices);
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

        public SearchInvoicesResponse build() {
            return new SearchInvoicesResponse(invoices, cursor, errors, additionalProperties);
        }
    }
}
