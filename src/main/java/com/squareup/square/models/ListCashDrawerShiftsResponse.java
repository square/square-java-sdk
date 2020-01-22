package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCashDrawerShiftsResponse type.
 */
public class ListCashDrawerShiftsResponse {

    /**
     * Initialization constructor.
     * @param items
     * @param cursor
     * @param errors
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

    private HttpContext httpContext;
    private final List<CashDrawerShiftSummary> items;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Items.
     * A collection of CashDrawerShiftSummary objects for shifts that match
     * the query.
     */
    @JsonGetter("items")
    public List<CashDrawerShiftSummary> getItems() {
        return this.items;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page of results. Cursor is not
     * present in the last page of results.
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
        return Objects.hash(items, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCashDrawerShiftsResponse)) {
            return false;
        }
        ListCashDrawerShiftsResponse listCashDrawerShiftsResponse = (ListCashDrawerShiftsResponse) obj;
        return Objects.equals(items, listCashDrawerShiftsResponse.items) &&
            Objects.equals(cursor, listCashDrawerShiftsResponse.cursor) &&
            Objects.equals(errors, listCashDrawerShiftsResponse.errors);
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
     * Class to build instances of {@link ListCashDrawerShiftsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftSummary> items;
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
         * Setter for items
         * @param items
         * @return Builder
         */
        public Builder items(List<CashDrawerShiftSummary> items) {
            this.items = items;
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
         * Builds a new {@link ListCashDrawerShiftsResponse} object using the set fields.
         * @return {@link ListCashDrawerShiftsResponse}
         */
        public ListCashDrawerShiftsResponse build() {
            ListCashDrawerShiftsResponse model = new ListCashDrawerShiftsResponse(items,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
