
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListCashDrawerShiftEventsResponse type.
 */
public class ListCashDrawerShiftEventsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CashDrawerShiftEvent> events;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  events  List of CashDrawerShiftEvent value for events.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Events.
     * All of the events (payments, refunds, etc.) for a cash drawer during the shift.
     * @return Returns the List of CashDrawerShiftEvent
     */
    @JsonGetter("events")
    public List<CashDrawerShiftEvent> getEvents() {
        return events;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page. Cursor is not present in the last page of results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCashDrawerShiftEventsResponse)) {
            return false;
        }
        ListCashDrawerShiftEventsResponse other = (ListCashDrawerShiftEventsResponse) obj;
        return Objects.equals(events, other.events)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListCashDrawerShiftEventsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftEventsResponse [" + "events=" + events + ", cursor=" + cursor
                + ", errors=" + errors + "]";
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
     * Class to build instances of {@link ListCashDrawerShiftEventsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftEvent> events;
        private String cursor;
        private List<Error> errors;



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
         * Setter for events.
         * @param  events  List of CashDrawerShiftEvent value for events.
         * @return Builder
         */
        public Builder events(List<CashDrawerShiftEvent> events) {
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
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
            ListCashDrawerShiftEventsResponse model =
                    new ListCashDrawerShiftEventsResponse(events, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
