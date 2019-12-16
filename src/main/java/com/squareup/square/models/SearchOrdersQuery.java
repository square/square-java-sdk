package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersQuery {

    @JsonCreator
    public SearchOrdersQuery(
            @JsonProperty("filter") SearchOrdersFilter filter,
            @JsonProperty("sort") SearchOrdersSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final SearchOrdersFilter filter;
    private final SearchOrdersSort sort;

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersQuery)) {
            return false;
        }
        SearchOrdersQuery searchOrdersQuery = (SearchOrdersQuery) o;
        return Objects.equals(filter, searchOrdersQuery.filter) &&
            Objects.equals(sort, searchOrdersQuery.sort);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    public static class Builder {
        private SearchOrdersFilter filter;
        private SearchOrdersSort sort;

        public Builder() { }

        public Builder filter(SearchOrdersFilter value) {
            filter = value;
            return this;
        }
        public Builder sort(SearchOrdersSort value) {
            sort = value;
            return this;
        }

        public SearchOrdersQuery build() {
            return new SearchOrdersQuery(filter,
                sort);
        }
    }
}
