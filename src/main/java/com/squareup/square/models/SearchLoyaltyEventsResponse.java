package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchLoyaltyEventsResponse type.
 */
public class SearchLoyaltyEventsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param events
     * @param cursor
     */
    @JsonCreator
    public SearchLoyaltyEventsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("events") List<LoyaltyEvent> events,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.events = events;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyEvent> events;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Events.
     * The loyalty events that satisfy the search criteria.
     */
    @JsonGetter("events")
    public List<LoyaltyEvent> getEvents() {
        return this.events;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent 
     * request. If empty, this is the final response. 
     * For more information, 
     * see [Pagination](https://developer.squareup.com/docs/docs/basics/api101/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, events, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchLoyaltyEventsResponse)) {
            return false;
        }
        SearchLoyaltyEventsResponse searchLoyaltyEventsResponse = (SearchLoyaltyEventsResponse) obj;
        return Objects.equals(errors, searchLoyaltyEventsResponse.errors) &&
            Objects.equals(events, searchLoyaltyEventsResponse.events) &&
            Objects.equals(cursor, searchLoyaltyEventsResponse.cursor);
    }

    /**
     * Builds a new {@link SearchLoyaltyEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .events(getEvents())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyEventsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyEvent> events;
        private String cursor;

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
         * Setter for events
         * @param events
         * @return Builder
         */
        public Builder events(List<LoyaltyEvent> events) {
            this.events = events;
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
         * Builds a new {@link SearchLoyaltyEventsResponse} object using the set fields.
         * @return {@link SearchLoyaltyEventsResponse}
         */
        public SearchLoyaltyEventsResponse build() {
            SearchLoyaltyEventsResponse model = new SearchLoyaltyEventsResponse(errors,
                events,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
