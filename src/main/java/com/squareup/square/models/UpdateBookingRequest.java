
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateBookingRequest type.
 */
public class UpdateBookingRequest {
    private final String idempotencyKey;
    private final Booking booking;

    /**
     * Initialization constructor.
     * @param booking Booking value for booking.
     * @param idempotencyKey String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateBookingRequest(
            @JsonProperty("booking") Booking booking,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.booking = booking;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique key to make this request an idempotent operation.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
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
        return this.booking;
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
        if (!(obj instanceof UpdateBookingRequest)) {
            return false;
        }
        UpdateBookingRequest other = (UpdateBookingRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(booking, other.booking);
    }

    /**
     * Converts this UpdateBookingRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateBookingRequest [" + "booking=" + booking + ", idempotencyKey="
                + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link UpdateBookingRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateBookingRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(booking)
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateBookingRequest}.
     */
    public static class Builder {
        private Booking booking;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param booking Booking value for booking.
         */
        public Builder(Booking booking) {
            this.booking = booking;
        }

        /**
         * Setter for booking.
         * @param booking Booking value for booking.
         * @return Builder
         */
        public Builder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link UpdateBookingRequest} object using the set fields.
         * @return {@link UpdateBookingRequest}
         */
        public UpdateBookingRequest build() {
            return new UpdateBookingRequest(booking, idempotencyKey);
        }
    }
}
