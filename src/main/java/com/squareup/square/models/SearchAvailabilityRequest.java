
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchAvailabilityRequest type.
 */
public class SearchAvailabilityRequest {
    private final SearchAvailabilityQuery query;

    /**
     * Initialization constructor.
     * @param  query  SearchAvailabilityQuery value for query.
     */
    @JsonCreator
    public SearchAvailabilityRequest(
            @JsonProperty("query") SearchAvailabilityQuery query) {
        this.query = query;
    }

    /**
     * Getter for Query.
     * The query used to search for buyer-accessible availabilities of bookings.
     * @return Returns the SearchAvailabilityQuery
     */
    @JsonGetter("query")
    public SearchAvailabilityQuery getQuery() {
        return query;
    }

    @Override
    public int hashCode() {
        return Objects.hash(query);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchAvailabilityRequest)) {
            return false;
        }
        SearchAvailabilityRequest other = (SearchAvailabilityRequest) obj;
        return Objects.equals(query, other.query);
    }

    /**
     * Converts this SearchAvailabilityRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchAvailabilityRequest [" + "query=" + query + "]";
    }

    /**
     * Builds a new {@link SearchAvailabilityRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchAvailabilityRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(query);
        return builder;
    }

    /**
     * Class to build instances of {@link SearchAvailabilityRequest}.
     */
    public static class Builder {
        private SearchAvailabilityQuery query;

        /**
         * Initialization constructor.
         * @param  query  SearchAvailabilityQuery value for query.
         */
        public Builder(SearchAvailabilityQuery query) {
            this.query = query;
        }

        /**
         * Setter for query.
         * @param  query  SearchAvailabilityQuery value for query.
         * @return Builder
         */
        public Builder query(SearchAvailabilityQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Builds a new {@link SearchAvailabilityRequest} object using the set fields.
         * @return {@link SearchAvailabilityRequest}
         */
        public SearchAvailabilityRequest build() {
            return new SearchAvailabilityRequest(query);
        }
    }
}
