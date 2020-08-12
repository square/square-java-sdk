package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListSubscriptionEventsResponse type.
 */
public class ListSubscriptionEventsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param subscriptionEvents
     * @param cursor
     */
    @JsonCreator
    public ListSubscriptionEventsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscription_events") List<SubscriptionEvent> subscriptionEvents,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.subscriptionEvents = subscriptionEvents;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<SubscriptionEvent> subscriptionEvents;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for SubscriptionEvents.
     * The `SubscriptionEvents` retrieved.
     */
    @JsonGetter("subscription_events")
    public List<SubscriptionEvent> getSubscriptionEvents() {
        return this.subscriptionEvents;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can 
     * use in a subsequent request to fetch the next set of events. 
     * If empty, this is the final response.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, subscriptionEvents, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListSubscriptionEventsResponse)) {
            return false;
        }
        ListSubscriptionEventsResponse listSubscriptionEventsResponse = (ListSubscriptionEventsResponse) obj;
        return Objects.equals(errors, listSubscriptionEventsResponse.errors) &&
            Objects.equals(subscriptionEvents, listSubscriptionEventsResponse.subscriptionEvents) &&
            Objects.equals(cursor, listSubscriptionEventsResponse.cursor);
    }

    /**
     * Builds a new {@link ListSubscriptionEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListSubscriptionEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .subscriptionEvents(getSubscriptionEvents())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListSubscriptionEventsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<SubscriptionEvent> subscriptionEvents;
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
         * Setter for subscriptionEvents
         * @param subscriptionEvents
         * @return Builder
         */
        public Builder subscriptionEvents(List<SubscriptionEvent> subscriptionEvents) {
            this.subscriptionEvents = subscriptionEvents;
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
         * Builds a new {@link ListSubscriptionEventsResponse} object using the set fields.
         * @return {@link ListSubscriptionEventsResponse}
         */
        public ListSubscriptionEventsResponse build() {
            ListSubscriptionEventsResponse model = new ListSubscriptionEventsResponse(errors,
                subscriptionEvents,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
