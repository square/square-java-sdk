package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersQuery type.
 */
public class SearchOrdersQuery {

    /**
     * Initialization constructor.
     * @param filter
     * @param sort
     */
    @JsonCreator
    public SearchOrdersQuery(
            @JsonProperty("filter") SearchOrdersFilter filter,
            @JsonProperty("sort") SearchOrdersSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final SearchOrdersFilter filter;
    private final SearchOrdersSort sort;
    /**
     * Getter for Filter.
     * Filtering criteria to use for a SearchOrders request. Multiple filters
     * will be ANDed together.
     */
    @JsonGetter("filter")
    public SearchOrdersFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     * Sorting criteria for a SearchOrders request. Results can only be sorted
     * by a timestamp field.
     */
    @JsonGetter("sort")
    public SearchOrdersSort getSort() {
        return this.sort;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersQuery)) {
            return false;
        }
        SearchOrdersQuery searchOrdersQuery = (SearchOrdersQuery) obj;
        return Objects.equals(filter, searchOrdersQuery.filter) &&
            Objects.equals(sort, searchOrdersQuery.sort);
    }

    /**
     * Builds a new {@link SearchOrdersQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersQuery}
     */
    public static class Builder {
        private SearchOrdersFilter filter;
        private SearchOrdersSort sort;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filter
         * @param filter
         * @return Builder
         */
        public Builder filter(SearchOrdersFilter filter) {
            this.filter = filter;
            return this;
        }
        /**
         * Setter for sort
         * @param sort
         * @return Builder
         */
        public Builder sort(SearchOrdersSort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersQuery} object using the set fields.
         * @return {@link SearchOrdersQuery}
         */
        public SearchOrdersQuery build() {
            return new SearchOrdersQuery(filter,
                sort);
        }
    }
}
