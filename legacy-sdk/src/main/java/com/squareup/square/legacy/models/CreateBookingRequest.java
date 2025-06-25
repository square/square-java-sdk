package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateBookingRequest type.
 */
public class CreateBookingRequest {
    private final String idempotencyKey;
    private final Booking booking;

    /**
     * Initialization constructor.
     * @param  booking  Booking value for booking.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateBookingRequest(
            @JsonProperty("booking") Booking booking, @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.booking = booking;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique key to make this request an idempotent operation.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
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

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, booking);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateBookingRequest)) {
            return false;
        }
        CreateBookingRequest other = (CreateBookingRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey) && Objects.equals(booking, other.booking);
    }

    /**
     * Converts this CreateBookingRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateBookingRequest [" + "booking=" + booking + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateBookingRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateBookingRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(booking).idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateBookingRequest}.
     */
    public static class Builder {
        private Booking booking;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  booking  Booking value for booking.
         */
        public Builder(Booking booking) {
            this.booking = booking;
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
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateBookingRequest} object using the set fields.
         * @return {@link CreateBookingRequest}
         */
        public CreateBookingRequest build() {
            return new CreateBookingRequest(booking, idempotencyKey);
        }
    }
}
