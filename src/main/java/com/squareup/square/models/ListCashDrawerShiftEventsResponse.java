package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListCashDrawerShiftEventsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(events, cursor, errors);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCashDrawerShiftEventsResponse)) {
            return false;
        }
        ListCashDrawerShiftEventsResponse listCashDrawerShiftEventsResponse = (ListCashDrawerShiftEventsResponse) o;
        return Objects.equals(events, listCashDrawerShiftEventsResponse.events) &&
            Objects.equals(cursor, listCashDrawerShiftEventsResponse.cursor) &&
            Objects.equals(errors, listCashDrawerShiftEventsResponse.errors);
    }
    

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .events(getEvents())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftEvent> events;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder events(List<CashDrawerShiftEvent> value) {
            events = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public ListCashDrawerShiftEventsResponse build() {
            ListCashDrawerShiftEventsResponse model = new ListCashDrawerShiftEventsResponse(events,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
