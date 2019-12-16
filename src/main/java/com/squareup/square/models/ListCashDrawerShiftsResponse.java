package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListCashDrawerShiftsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(items, cursor, errors);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCashDrawerShiftsResponse)) {
            return false;
        }
        ListCashDrawerShiftsResponse listCashDrawerShiftsResponse = (ListCashDrawerShiftsResponse) o;
        return Objects.equals(items, listCashDrawerShiftsResponse.items) &&
            Objects.equals(cursor, listCashDrawerShiftsResponse.cursor) &&
            Objects.equals(errors, listCashDrawerShiftsResponse.errors);
    }
    

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<CashDrawerShiftSummary> items;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder items(List<CashDrawerShiftSummary> value) {
            items = value;
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

        public ListCashDrawerShiftsResponse build() {
            ListCashDrawerShiftsResponse model = new ListCashDrawerShiftsResponse(items,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
