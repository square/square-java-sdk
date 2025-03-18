package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListSubscriptionEventsResponse type.
 */
public class ListSubscriptionEventsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<SubscriptionEvent> subscriptionEvents;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  subscriptionEvents  List of SubscriptionEvent value for subscriptionEvents.
     * @param  cursor  String value for cursor.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for SubscriptionEvents.
     * The retrieved subscription events.
     * @return Returns the List of SubscriptionEvent
     */
    @JsonGetter("subscription_events")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SubscriptionEvent> getSubscriptionEvents() {
        return subscriptionEvents;
    }

    /**
     * Getter for Cursor.
     * When the total number of resulting subscription events exceeds the limit of a paged response,
     * the response includes a cursor for you to use in a subsequent request to fetch the next set
     * of events. If the cursor is unset, the response contains the last page of the results. For
     * more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, subscriptionEvents, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListSubscriptionEventsResponse)) {
            return false;
        }
        ListSubscriptionEventsResponse other = (ListSubscriptionEventsResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(subscriptionEvents, other.subscriptionEvents)
                && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListSubscriptionEventsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListSubscriptionEventsResponse [" + "errors=" + errors + ", subscriptionEvents=" + subscriptionEvents
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListSubscriptionEventsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<SubscriptionEvent> subscriptionEvents;
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
         * Setter for subscriptionEvents.
         * @param  subscriptionEvents  List of SubscriptionEvent value for subscriptionEvents.
         * @return Builder
         */
        public Builder subscriptionEvents(List<SubscriptionEvent> subscriptionEvents) {
            this.subscriptionEvents = subscriptionEvents;
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
         * Builds a new {@link ListSubscriptionEventsResponse} object using the set fields.
         * @return {@link ListSubscriptionEventsResponse}
         */
        public ListSubscriptionEventsResponse build() {
            ListSubscriptionEventsResponse model =
                    new ListSubscriptionEventsResponse(errors, subscriptionEvents, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
