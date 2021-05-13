
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersQuery type.
 */
public class SearchOrdersQuery {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SearchOrdersFilter filter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SearchOrdersSort sort;

    /**
     * Initialization constructor.
     * @param  filter  SearchOrdersFilter value for filter.
     * @param  sort  SearchOrdersSort value for sort.
     */
    @JsonCreator
    public SearchOrdersQuery(
            @JsonProperty("filter") SearchOrdersFilter filter,
            @JsonProperty("sort") SearchOrdersSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * Filtering criteria to use for a `SearchOrders` request. Multiple filters are ANDed together.
     * @return Returns the SearchOrdersFilter
     */
    @JsonGetter("filter")
    public SearchOrdersFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * Sorting criteria for a `SearchOrders` request. Results can only be sorted by a timestamp
     * field.
     * @return Returns the SearchOrdersSort
     */
    @JsonGetter("sort")
    public SearchOrdersSort getSort() {
        return sort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersQuery)) {
            return false;
        }
        SearchOrdersQuery other = (SearchOrdersQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this SearchOrdersQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersQuery [" + "filter=" + filter + ", sort=" + sort + "]";
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
     * Class to build instances of {@link SearchOrdersQuery}.
     */
    public static class Builder {
        private SearchOrdersFilter filter;
        private SearchOrdersSort sort;



        /**
         * Setter for filter.
         * @param  filter  SearchOrdersFilter value for filter.
         * @return Builder
         */
        public Builder filter(SearchOrdersFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  SearchOrdersSort value for sort.
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
            return new SearchOrdersQuery(filter, sort);
        }
    }
}
