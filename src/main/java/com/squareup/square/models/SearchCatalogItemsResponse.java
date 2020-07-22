package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchCatalogItemsResponse type.
 */
public class SearchCatalogItemsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param items
     * @param cursor
     * @param matchedVariationIds
     */
    @JsonCreator
    public SearchCatalogItemsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("items") List<CatalogObject> items,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("matched_variation_ids") List<String> matchedVariationIds) {
        this.errors = errors;
        this.items = items;
        this.cursor = cursor;
        this.matchedVariationIds = matchedVariationIds;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CatalogObject> items;
    private final String cursor;
    private final List<String> matchedVariationIds;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors detected when the call to [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems) endpoint fails.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Items.
     * Returned items matching the specified query expressions.
     */
    @JsonGetter("items")
    public List<CatalogObject> getItems() {
        return this.items;
    }

    /**
     * Getter for Cursor.
     * Pagination token used in the next request to return more of the search result.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for MatchedVariationIds.
     * Ids of returned item variations matching the specified query expression.
     */
    @JsonGetter("matched_variation_ids")
    public List<String> getMatchedVariationIds() {
        return this.matchedVariationIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, items, cursor, matchedVariationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchCatalogItemsResponse)) {
            return false;
        }
        SearchCatalogItemsResponse searchCatalogItemsResponse = (SearchCatalogItemsResponse) obj;
        return Objects.equals(errors, searchCatalogItemsResponse.errors) &&
            Objects.equals(items, searchCatalogItemsResponse.items) &&
            Objects.equals(cursor, searchCatalogItemsResponse.cursor) &&
            Objects.equals(matchedVariationIds, searchCatalogItemsResponse.matchedVariationIds);
    }

    /**
     * Builds a new {@link SearchCatalogItemsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCatalogItemsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .items(getItems())
            .cursor(getCursor())
            .matchedVariationIds(getMatchedVariationIds());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchCatalogItemsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> items;
        private String cursor;
        private List<String> matchedVariationIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for items
         * @param items
         * @return Builder
         */
        public Builder items(List<CatalogObject> items) {
            this.items = items;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for matchedVariationIds
         * @param matchedVariationIds
         * @return Builder
         */
        public Builder matchedVariationIds(List<String> matchedVariationIds) {
            this.matchedVariationIds = matchedVariationIds;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogItemsResponse} object using the set fields.
         * @return {@link SearchCatalogItemsResponse}
         */
        public SearchCatalogItemsResponse build() {
            SearchCatalogItemsResponse model = new SearchCatalogItemsResponse(errors,
                items,
                cursor,
                matchedVariationIds);
            model.httpContext = httpContext;
            return model;
        }
    }
}
