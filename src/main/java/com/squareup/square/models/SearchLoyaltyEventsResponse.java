
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
 * This is a model class for SearchLoyaltyEventsResponse type.
 */
public class SearchLoyaltyEventsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyEvent> events;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  events  List of LoyaltyEvent value for events.
     * @param  cursor  String value for cursor.
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
     * Getter for Events.
     * The loyalty events that satisfy the search criteria.
     * @return Returns the List of LoyaltyEvent
     */
    @JsonGetter("events")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LoyaltyEvent> getEvents() {
        return events;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, events, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyEventsResponse)) {
            return false;
        }
        SearchLoyaltyEventsResponse other = (SearchLoyaltyEventsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(events, other.events)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchLoyaltyEventsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyEventsResponse [" + "errors=" + errors + ", events=" + events
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link SearchLoyaltyEventsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyEvent> events;
        private String cursor;



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
         * Setter for events.
         * @param  events  List of LoyaltyEvent value for events.
         * @return Builder
         */
        public Builder events(List<LoyaltyEvent> events) {
            this.events = events;
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
         * Builds a new {@link SearchLoyaltyEventsResponse} object using the set fields.
         * @return {@link SearchLoyaltyEventsResponse}
         */
        public SearchLoyaltyEventsResponse build() {
            SearchLoyaltyEventsResponse model =
                    new SearchLoyaltyEventsResponse(errors, events, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
