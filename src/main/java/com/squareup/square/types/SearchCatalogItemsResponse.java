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
@JsonDeserialize(builder = SearchCatalogItemsResponse.Builder.class)
public final class SearchCatalogItemsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<List<CatalogObject>> items;

    private final Optional<String> cursor;

    private final Optional<List<String>> matchedVariationIds;

    private final Map<String, Object> additionalProperties;

    private SearchCatalogItemsResponse(
            Optional<List<Error>> errors,
            Optional<List<CatalogObject>> items,
            Optional<String> cursor,
            Optional<List<String>> matchedVariationIds,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.items = items;
        this.cursor = cursor;
        this.matchedVariationIds = matchedVariationIds;
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
     * @return Returned items matching the specified query expressions.
     */
    @JsonProperty("items")
    public Optional<List<CatalogObject>> getItems() {
        return items;
    }

    /**
     * @return Pagination token used in the next request to return more of the search result.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Ids of returned item variations matching the specified query expression.
     */
    @JsonProperty("matched_variation_ids")
    public Optional<List<String>> getMatchedVariationIds() {
        return matchedVariationIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchCatalogItemsResponse && equalTo((SearchCatalogItemsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchCatalogItemsResponse other) {
        return errors.equals(other.errors)
                && items.equals(other.items)
                && cursor.equals(other.cursor)
                && matchedVariationIds.equals(other.matchedVariationIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.items, this.cursor, this.matchedVariationIds);
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

        private Optional<List<CatalogObject>> items = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<String>> matchedVariationIds = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchCatalogItemsResponse other) {
            errors(other.getErrors());
            items(other.getItems());
            cursor(other.getCursor());
            matchedVariationIds(other.getMatchedVariationIds());
            return this;
        }

        /**
         * <p>Any errors that occurred during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        /**
         * <p>Returned items matching the specified query expressions.</p>
         */
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(Optional<List<CatalogObject>> items) {
            this.items = items;
            return this;
        }

        public Builder items(List<CatalogObject> items) {
            this.items = Optional.ofNullable(items);
            return this;
        }

        /**
         * <p>Pagination token used in the next request to return more of the search result.</p>
         */
        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        /**
         * <p>Ids of returned item variations matching the specified query expression.</p>
         */
        @JsonSetter(value = "matched_variation_ids", nulls = Nulls.SKIP)
        public Builder matchedVariationIds(Optional<List<String>> matchedVariationIds) {
            this.matchedVariationIds = matchedVariationIds;
            return this;
        }

        public Builder matchedVariationIds(List<String> matchedVariationIds) {
            this.matchedVariationIds = Optional.ofNullable(matchedVariationIds);
            return this;
        }

        public SearchCatalogItemsResponse build() {
            return new SearchCatalogItemsResponse(errors, items, cursor, matchedVariationIds, additionalProperties);
        }
    }
}
