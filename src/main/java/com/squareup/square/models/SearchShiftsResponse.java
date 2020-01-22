package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchShiftsResponse type.
 */
public class SearchShiftsResponse {

    /**
     * Initialization constructor.
     * @param shifts
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public SearchShiftsResponse(
            @JsonProperty("shifts") List<Shift> shifts,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.shifts = shifts;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Shift> shifts;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Shifts.
     * Shifts
     */
    @JsonGetter("shifts")
    public List<Shift> getShifts() {
        return this.shifts;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page.
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
        return Objects.hash(shifts, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchShiftsResponse)) {
            return false;
        }
        SearchShiftsResponse searchShiftsResponse = (SearchShiftsResponse) obj;
        return Objects.equals(shifts, searchShiftsResponse.shifts) &&
            Objects.equals(cursor, searchShiftsResponse.cursor) &&
            Objects.equals(errors, searchShiftsResponse.errors);
    }

    /**
     * Builds a new {@link SearchShiftsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchShiftsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .shifts(getShifts())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchShiftsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Shift> shifts;
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
         * Setter for shifts
         * @param shifts
         * @return Builder
         */
        public Builder shifts(List<Shift> shifts) {
            this.shifts = shifts;
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
         * Builds a new {@link SearchShiftsResponse} object using the set fields.
         * @return {@link SearchShiftsResponse}
         */
        public SearchShiftsResponse build() {
            SearchShiftsResponse model = new SearchShiftsResponse(shifts,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
