package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveBookingsResponse type.
 */
public class BulkRetrieveBookingsResponse {
    private HttpContext httpContext;
    private final Map<String, RetrieveBookingResponse> bookings;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bookings  Map of String, value for bookings.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkRetrieveBookingsResponse(
            @JsonProperty("bookings") Map<String, RetrieveBookingResponse> bookings,
            @JsonProperty("errors") List<Error> errors) {
        this.bookings = bookings;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Bookings.
     * Requested bookings returned as a map containing `booking_id` as the key and
     * `RetrieveBookingResponse` as the value.
     * @return Returns the Map of String, RetrieveBookingResponse
     */
    @JsonGetter("bookings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, RetrieveBookingResponse> getBookings() {
        return bookings;
    }

    /**
     * Getter for Errors.
     * Errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookings, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveBookingsResponse)) {
            return false;
        }
        BulkRetrieveBookingsResponse other = (BulkRetrieveBookingsResponse) obj;
        return Objects.equals(bookings, other.bookings) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkRetrieveBookingsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveBookingsResponse [" + "bookings=" + bookings + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveBookingsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveBookingsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().bookings(getBookings()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveBookingsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, RetrieveBookingResponse> bookings;
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
         * @param  bookings  Map of String, value for bookings.
         * @return Builder
         */
        public Builder bookings(Map<String, RetrieveBookingResponse> bookings) {
            this.bookings = bookings;
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
         * Builds a new {@link BulkRetrieveBookingsResponse} object using the set fields.
         * @return {@link BulkRetrieveBookingsResponse}
         */
        public BulkRetrieveBookingsResponse build() {
            BulkRetrieveBookingsResponse model = new BulkRetrieveBookingsResponse(bookings, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
