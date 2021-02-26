
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchShiftsResponse type.
 */
public class SearchShiftsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Shift> shifts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  shifts  List of Shift value for shifts.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Shifts.
     * Shifts
     * @return Returns the List of Shift
     */
    @JsonGetter("shifts")
    public List<Shift> getShifts() {
        return shifts;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page.
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
        return Objects.hash(shifts, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchShiftsResponse)) {
            return false;
        }
        SearchShiftsResponse other = (SearchShiftsResponse) obj;
        return Objects.equals(shifts, other.shifts)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this SearchShiftsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchShiftsResponse [" + "shifts=" + shifts + ", cursor=" + cursor + ", errors="
                + errors + "]";
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
     * Class to build instances of {@link SearchShiftsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Shift> shifts;
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
         * Setter for shifts.
         * @param  shifts  List of Shift value for shifts.
         * @return Builder
         */
        public Builder shifts(List<Shift> shifts) {
            this.shifts = shifts;
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
         * Builds a new {@link SearchShiftsResponse} object using the set fields.
         * @return {@link SearchShiftsResponse}
         */
        public SearchShiftsResponse build() {
            SearchShiftsResponse model =
                    new SearchShiftsResponse(shifts, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
