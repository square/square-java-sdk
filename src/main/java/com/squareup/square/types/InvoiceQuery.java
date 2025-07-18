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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = InvoiceQuery.Builder.class)
public final class InvoiceQuery {
    private final InvoiceFilter filter;

    private final Optional<InvoiceSort> sort;

    private final Map<String, Object> additionalProperties;

    private InvoiceQuery(InvoiceFilter filter, Optional<InvoiceSort> sort, Map<String, Object> additionalProperties) {
        this.filter = filter;
        this.sort = sort;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Query filters to apply in searching invoices.
     * For more information, see <a href="https://developer.squareup.com/docs/invoices-api/retrieve-list-search-invoices#search-invoices">Search for invoices</a>.
     */
    @JsonProperty("filter")
    public InvoiceFilter getFilter() {
        return filter;
    }

    /**
     * @return Describes the sort order for the search result.
     */
    @JsonProperty("sort")
    public Optional<InvoiceSort> getSort() {
        return sort;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof InvoiceQuery && equalTo((InvoiceQuery) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(InvoiceQuery other) {
        return filter.equals(other.filter) && sort.equals(other.sort);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.filter, this.sort);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FilterStage builder() {
        return new Builder();
    }

    public interface FilterStage {
        /**
         * <p>Query filters to apply in searching invoices.
         * For more information, see <a href="https://developer.squareup.com/docs/invoices-api/retrieve-list-search-invoices#search-invoices">Search for invoices</a>.</p>
         */
        _FinalStage filter(@NotNull InvoiceFilter filter);

        Builder from(InvoiceQuery other);
    }

    public interface _FinalStage {
        InvoiceQuery build();

        /**
         * <p>Describes the sort order for the search result.</p>
         */
        _FinalStage sort(Optional<InvoiceSort> sort);

        _FinalStage sort(InvoiceSort sort);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FilterStage, _FinalStage {
        private InvoiceFilter filter;

        private Optional<InvoiceSort> sort = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(InvoiceQuery other) {
            filter(other.getFilter());
            sort(other.getSort());
            return this;
        }

        /**
         * <p>Query filters to apply in searching invoices.
         * For more information, see <a href="https://developer.squareup.com/docs/invoices-api/retrieve-list-search-invoices#search-invoices">Search for invoices</a>.</p>
         * <p>Query filters to apply in searching invoices.
         * For more information, see <a href="https://developer.squareup.com/docs/invoices-api/retrieve-list-search-invoices#search-invoices">Search for invoices</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("filter")
        public _FinalStage filter(@NotNull InvoiceFilter filter) {
            this.filter = Objects.requireNonNull(filter, "filter must not be null");
            return this;
        }

        /**
         * <p>Describes the sort order for the search result.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage sort(InvoiceSort sort) {
            this.sort = Optional.ofNullable(sort);
            return this;
        }

        /**
         * <p>Describes the sort order for the search result.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "sort", nulls = Nulls.SKIP)
        public _FinalStage sort(Optional<InvoiceSort> sort) {
            this.sort = sort;
            return this;
        }

        @java.lang.Override
        public InvoiceQuery build() {
            return new InvoiceQuery(filter, sort, additionalProperties);
        }
    }
}
