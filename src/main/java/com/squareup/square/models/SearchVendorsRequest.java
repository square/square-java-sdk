
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchVendorsRequest type.
 */
public class SearchVendorsRequest {
    private final SearchVendorsRequestFilter filter;
    private final SearchVendorsRequestSort sort;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  filter  SearchVendorsRequestFilter value for filter.
     * @param  sort  SearchVendorsRequestSort value for sort.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchVendorsRequest(
            @JsonProperty("filter") SearchVendorsRequestFilter filter,
            @JsonProperty("sort") SearchVendorsRequestSort sort,
            @JsonProperty("cursor") String cursor) {
        this.filter = filter;
        this.sort = sort;
        this.cursor = cursor;
    }

    /**
     * Getter for Filter.
     * Defines supported query expressions to search for vendors by.
     * @return Returns the SearchVendorsRequestFilter
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchVendorsRequestFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * Defines a sorter used to sort results from [SearchVendors]($e/Vendors/SearchVendors).
     * @return Returns the SearchVendorsRequestSort
     */
    @JsonGetter("sort")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchVendorsRequestSort getSort() {
        return sort;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchVendorsRequest)) {
            return false;
        }
        SearchVendorsRequest other = (SearchVendorsRequest) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchVendorsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchVendorsRequest [" + "filter=" + filter + ", sort=" + sort + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link SearchVendorsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchVendorsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter())
                .sort(getSort())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchVendorsRequest}.
     */
    public static class Builder {
        private SearchVendorsRequestFilter filter;
        private SearchVendorsRequestSort sort;
        private String cursor;



        /**
         * Setter for filter.
         * @param  filter  SearchVendorsRequestFilter value for filter.
         * @return Builder
         */
        public Builder filter(SearchVendorsRequestFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  SearchVendorsRequestSort value for sort.
         * @return Builder
         */
        public Builder sort(SearchVendorsRequestSort sort) {
            this.sort = sort;
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
         * Builds a new {@link SearchVendorsRequest} object using the set fields.
         * @return {@link SearchVendorsRequest}
         */
        public SearchVendorsRequest build() {
            return new SearchVendorsRequest(filter, sort, cursor);
        }
    }
}
