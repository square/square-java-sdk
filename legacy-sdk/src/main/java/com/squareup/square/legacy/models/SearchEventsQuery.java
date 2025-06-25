package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchEventsQuery type.
 */
public class SearchEventsQuery {
    private final SearchEventsFilter filter;
    private final SearchEventsSort sort;

    /**
     * Initialization constructor.
     * @param  filter  SearchEventsFilter value for filter.
     * @param  sort  SearchEventsSort value for sort.
     */
    @JsonCreator
    public SearchEventsQuery(
            @JsonProperty("filter") SearchEventsFilter filter, @JsonProperty("sort") SearchEventsSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * Criteria to filter events by.
     * @return Returns the SearchEventsFilter
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchEventsFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * Criteria to sort events by.
     * @return Returns the SearchEventsSort
     */
    @JsonGetter("sort")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchEventsSort getSort() {
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
        if (!(obj instanceof SearchEventsQuery)) {
            return false;
        }
        SearchEventsQuery other = (SearchEventsQuery) obj;
        return Objects.equals(filter, other.filter) && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this SearchEventsQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchEventsQuery [" + "filter=" + filter + ", sort=" + sort + "]";
    }

    /**
     * Builds a new {@link SearchEventsQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchEventsQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().filter(getFilter()).sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchEventsQuery}.
     */
    public static class Builder {
        private SearchEventsFilter filter;
        private SearchEventsSort sort;

        /**
         * Setter for filter.
         * @param  filter  SearchEventsFilter value for filter.
         * @return Builder
         */
        public Builder filter(SearchEventsFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  SearchEventsSort value for sort.
         * @return Builder
         */
        public Builder sort(SearchEventsSort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link SearchEventsQuery} object using the set fields.
         * @return {@link SearchEventsQuery}
         */
        public SearchEventsQuery build() {
            return new SearchEventsQuery(filter, sort);
        }
    }
}
