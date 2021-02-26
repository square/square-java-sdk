
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchSubscriptionsQuery type.
 */
public class SearchSubscriptionsQuery {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SearchSubscriptionsFilter filter;

    /**
     * Initialization constructor.
     * @param  filter  SearchSubscriptionsFilter value for filter.
     */
    @JsonCreator
    public SearchSubscriptionsQuery(
            @JsonProperty("filter") SearchSubscriptionsFilter filter) {
        this.filter = filter;
    }

    /**
     * Getter for Filter.
     * Represents a set of SearchSubscriptionsQuery filters used to limit the set of Subscriptions
     * returned by SearchSubscriptions.
     * @return Returns the SearchSubscriptionsFilter
     */
    @JsonGetter("filter")
    public SearchSubscriptionsFilter getFilter() {
        return filter;
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
        if (!(obj instanceof SearchSubscriptionsQuery)) {
            return false;
        }
        SearchSubscriptionsQuery other = (SearchSubscriptionsQuery) obj;
        return Objects.equals(filter, other.filter);
    }

    /**
     * Converts this SearchSubscriptionsQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsQuery [" + "filter=" + filter + "]";
    }

    /**
     * Builds a new {@link SearchSubscriptionsQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsQuery}.
     */
    public static class Builder {
        private SearchSubscriptionsFilter filter;



        /**
         * Setter for filter.
         * @param  filter  SearchSubscriptionsFilter value for filter.
         * @return Builder
         */
        public Builder filter(SearchSubscriptionsFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsQuery} object using the set fields.
         * @return {@link SearchSubscriptionsQuery}
         */
        public SearchSubscriptionsQuery build() {
            return new SearchSubscriptionsQuery(filter);
        }
    }
}
