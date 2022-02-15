
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchCatalogItemsResponse type.
 */
public class SearchCatalogItemsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CatalogObject> items;
    private final String cursor;
    private final List<String> matchedVariationIds;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  items  List of CatalogObject value for items.
     * @param  cursor  String value for cursor.
     * @param  matchedVariationIds  List of String value for matchedVariationIds.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Items.
     * Returned items matching the specified query expressions.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogObject> getItems() {
        return items;
    }

    /**
     * Getter for Cursor.
     * Pagination token used in the next request to return more of the search result.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for MatchedVariationIds.
     * Ids of returned item variations matching the specified query expression.
     * @return Returns the List of String
     */
    @JsonGetter("matched_variation_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getMatchedVariationIds() {
        return matchedVariationIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, items, cursor, matchedVariationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCatalogItemsResponse)) {
            return false;
        }
        SearchCatalogItemsResponse other = (SearchCatalogItemsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(items, other.items)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(matchedVariationIds, other.matchedVariationIds);
    }

    /**
     * Converts this SearchCatalogItemsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCatalogItemsResponse [" + "errors=" + errors + ", items=" + items
                + ", cursor=" + cursor + ", matchedVariationIds=" + matchedVariationIds + "]";
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
     * Class to build instances of {@link SearchCatalogItemsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> items;
        private String cursor;
        private List<String> matchedVariationIds;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for items.
         * @param  items  List of CatalogObject value for items.
         * @return Builder
         */
        public Builder items(List<CatalogObject> items) {
            this.items = items;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for matchedVariationIds.
         * @param  matchedVariationIds  List of String value for matchedVariationIds.
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
            SearchCatalogItemsResponse model =
                    new SearchCatalogItemsResponse(errors, items, cursor, matchedVariationIds);
            model.httpContext = httpContext;
            return model;
        }
    }
}
