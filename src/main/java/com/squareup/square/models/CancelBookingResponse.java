
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
 * This is a model class for CancelBookingResponse type.
 */
public class CancelBookingResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Booking booking;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  booking  Booking value for booking.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CancelBookingResponse(
            @JsonProperty("booking") Booking booking,
            @JsonProperty("errors") List<Error> errors) {
        this.booking = booking;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Booking.
     * Represents a booking as a time-bound service contract for a seller's staff member to provide
     * a specified service at a given location to a requesting customer in one or more appointment
     * segments.
     * @return Returns the Booking
     */
    @JsonGetter("booking")
    public Booking getBooking() {
        return booking;
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
        return Objects.hash(booking, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelBookingResponse)) {
            return false;
        }
        CancelBookingResponse other = (CancelBookingResponse) obj;
        return Objects.equals(booking, other.booking)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CancelBookingResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CancelBookingResponse [" + "booking=" + booking + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link CancelBookingResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelBookingResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .booking(getBooking())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CancelBookingResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Booking booking;
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
         * Setter for booking.
         * @param  booking  Booking value for booking.
         * @return Builder
         */
        public Builder booking(Booking booking) {
            this.booking = booking;
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
         * Builds a new {@link CancelBookingResponse} object using the set fields.
         * @return {@link CancelBookingResponse}
         */
        public CancelBookingResponse build() {
            CancelBookingResponse model =
                    new CancelBookingResponse(booking, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
