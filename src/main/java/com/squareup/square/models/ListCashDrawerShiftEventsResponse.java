package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCashDrawerShiftEventsResponse type.
 */
public class ListCashDrawerShiftEventsResponse {

    /**
     * Initialization constructor.
     * @param events
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public ListCashDrawerShiftEventsResponse(
            @JsonProperty("events") List<CashDrawerShiftEvent> events,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.events = events;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<CashDrawerShiftEvent> events;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Events.
     * All of the events (payments, refunds, etc.) for a cash drawer during
     * the shift.
     */
    @JsonGetter("events")
    public List<CashDrawerShiftEvent> getEvents() {
        return this.events;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page. Cursor is not present in
     * the last page of results.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(events, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCashDrawerShiftEventsResponse)) {
            return false;
        }
        ListCashDrawerShiftEventsResponse listCashDrawerShiftEventsResponse = (ListCashDrawerShiftEventsResponse) obj;
        return Objects.equals(events, listCashDrawerShiftEventsResponse.events) &&
            Objects.equals(cursor, listCashDrawerShiftEventsResponse.cursor) &&
            Objects.equals(errors, listCashDrawerShiftEventsResponse.errors);
    }

    /**
     * Builds a new {@link ListCashDrawerShiftEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .events(getEvents())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftEventsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftEvent> events;
        private String cursor;
        private List<Error> errors;

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
         * Setter for events
         * @param events
         * @return Builder
         */
        public Builder events(List<CashDrawerShiftEvent> events) {
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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftEventsResponse} object using the set fields.
         * @return {@link ListCashDrawerShiftEventsResponse}
         */
        public ListCashDrawerShiftEventsResponse build() {
            ListCashDrawerShiftEventsResponse model = new ListCashDrawerShiftEventsResponse(events,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
