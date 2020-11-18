
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchAvailabilityQuery type.
 */
public class SearchAvailabilityQuery {
    private final SearchAvailabilityFilter filter;

    /**
     * Initialization constructor.
     * @param filter SearchAvailabilityFilter value for filter.
     */
    @JsonCreator
    public SearchAvailabilityQuery(
            @JsonProperty("filter") SearchAvailabilityFilter filter) {
        this.filter = filter;
    }

    /**
     * Getter for Filter.
     * A query filter to search for availabilities by.
     * @return Returns the SearchAvailabilityFilter
     */
    @JsonGetter("filter")
    public SearchAvailabilityFilter getFilter() {
        return this.filter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchAvailabilityQuery)) {
            return false;
        }
        SearchAvailabilityQuery other = (SearchAvailabilityQuery) obj;
        return Objects.equals(filter, other.filter);
    }

    /**
     * Converts this SearchAvailabilityQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchAvailabilityQuery [" + "filter=" + filter + "]";
    }

    /**
     * Builds a new {@link SearchAvailabilityQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchAvailabilityQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(filter);
        return builder;
    }

    /**
     * Class to build instances of {@link SearchAvailabilityQuery}.
     */
    public static class Builder {
        private SearchAvailabilityFilter filter;

        /**
         * Initialization constructor.
         * @param filter SearchAvailabilityFilter value for filter.
         */
        public Builder(SearchAvailabilityFilter filter) {
            this.filter = filter;
        }

        /**
         * Setter for filter.
         * @param filter SearchAvailabilityFilter value for filter.
         * @return Builder
         */
        public Builder filter(SearchAvailabilityFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Builds a new {@link SearchAvailabilityQuery} object using the set fields.
         * @return {@link SearchAvailabilityQuery}
         */
        public SearchAvailabilityQuery build() {
            return new SearchAvailabilityQuery(filter);
        }
    }
}
