
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListCashDrawerShiftsResponse type.
 */
public class ListCashDrawerShiftsResponse {
    private HttpContext httpContext;
    private final List<CashDrawerShiftSummary> items;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param items List of CashDrawerShiftSummary value for items.
     * @param cursor String value for cursor.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public ListCashDrawerShiftsResponse(
            @JsonProperty("items") List<CashDrawerShiftSummary> items,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.items = items;
        this.cursor = cursor;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Items.
     * A collection of CashDrawerShiftSummary objects for shifts that match the query.
     * @return Returns the List of CashDrawerShiftSummary
     */
    @JsonGetter("items")
    public List<CashDrawerShiftSummary> getItems() {
        return this.items;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page of results. Cursor is not present in the last page
     * of results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCashDrawerShiftsResponse)) {
            return false;
        }
        ListCashDrawerShiftsResponse other = (ListCashDrawerShiftsResponse) obj;
        return Objects.equals(items, other.items)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListCashDrawerShiftsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftsResponse [" + "items=" + items + ", cursor=" + cursor
                + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListCashDrawerShiftsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .items(getItems())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftSummary> items;
        private String cursor;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for items.
         * @param items List of CashDrawerShiftSummary value for items.
         * @return Builder
         */
        public Builder items(List<CashDrawerShiftSummary> items) {
            this.items = items;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftsResponse} object using the set fields.
         * @return {@link ListCashDrawerShiftsResponse}
         */
        public ListCashDrawerShiftsResponse build() {
            ListCashDrawerShiftsResponse model =
                    new ListCashDrawerShiftsResponse(items, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
