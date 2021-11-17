
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
 * This is a model class for ListBookingsResponse type.
 */
public class ListBookingsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Booking> bookings;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bookings  List of Booking value for bookings.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListBookingsResponse(
            @JsonProperty("bookings") List<Booking> bookings,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.bookings = bookings;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Bookings.
     * The list of targeted bookings.
     * @return Returns the List of Booking
     */
    @JsonGetter("bookings")
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in the following request to get the next page of the
     * results. Stop retrieving the next page of the results when the cursor is not set.
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
        return Objects.hash(bookings, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBookingsResponse)) {
            return false;
        }
        ListBookingsResponse other = (ListBookingsResponse) obj;
        return Objects.equals(bookings, other.bookings)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListBookingsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBookingsResponse [" + "bookings=" + bookings + ", cursor=" + cursor
                + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListBookingsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBookingsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .bookings(getBookings())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListBookingsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Booking> bookings;
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
         * Setter for bookings.
         * @param  bookings  List of Booking value for bookings.
         * @return Builder
         */
        public Builder bookings(List<Booking> bookings) {
            this.bookings = bookings;
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
         * Builds a new {@link ListBookingsResponse} object using the set fields.
         * @return {@link ListBookingsResponse}
         */
        public ListBookingsResponse build() {
            ListBookingsResponse model =
                    new ListBookingsResponse(bookings, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
