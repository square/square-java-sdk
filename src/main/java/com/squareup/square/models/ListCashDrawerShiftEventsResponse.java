
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
 * This is a model class for ListCashDrawerShiftEventsResponse type.
 */
public class ListCashDrawerShiftEventsResponse {
    private HttpContext httpContext;
    private final String cursor;
    private final List<Error> errors;
    private final List<CashDrawerShiftEvent> cashDrawerShiftEvents;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     * @param  cashDrawerShiftEvents  List of CashDrawerShiftEvent value for cashDrawerShiftEvents.
     */
    @JsonCreator
    public ListCashDrawerShiftEventsResponse(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cash_drawer_shift_events") List<CashDrawerShiftEvent> cashDrawerShiftEvents) {
        this.cursor = cursor;
        this.errors = errors;
        this.cashDrawerShiftEvents = cashDrawerShiftEvents;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page. Cursor is not present in the last page of results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
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
     * Getter for CashDrawerShiftEvents.
     * All of the events (payments, refunds, etc.) for a cash drawer during the shift.
     * @return Returns the List of CashDrawerShiftEvent
     */
    @JsonGetter("cash_drawer_shift_events")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CashDrawerShiftEvent> getCashDrawerShiftEvents() {
        return cashDrawerShiftEvents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, errors, cashDrawerShiftEvents);
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
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors)
            && Objects.equals(cashDrawerShiftEvents, other.cashDrawerShiftEvents);
    }

    /**
     * Converts this ListCashDrawerShiftEventsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftEventsResponse [" + "cursor=" + cursor + ", errors=" + errors
                + ", cashDrawerShiftEvents=" + cashDrawerShiftEvents + "]";
    }

    /**
     * Builds a new {@link ListCashDrawerShiftEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .errors(getErrors())
                .cashDrawerShiftEvents(getCashDrawerShiftEvents());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftEventsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String cursor;
        private List<Error> errors;
        private List<CashDrawerShiftEvent> cashDrawerShiftEvents;



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
         * Setter for cashDrawerShiftEvents.
         * @param  cashDrawerShiftEvents  List of CashDrawerShiftEvent value for
         *         cashDrawerShiftEvents.
         * @return Builder
         */
        public Builder cashDrawerShiftEvents(List<CashDrawerShiftEvent> cashDrawerShiftEvents) {
            this.cashDrawerShiftEvents = cashDrawerShiftEvents;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftEventsResponse} object using the set fields.
         * @return {@link ListCashDrawerShiftEventsResponse}
         */
        public ListCashDrawerShiftEventsResponse build() {
            ListCashDrawerShiftEventsResponse model =
                    new ListCashDrawerShiftEventsResponse(cursor, errors, cashDrawerShiftEvents);
            model.httpContext = httpContext;
            return model;
        }
    }
}
