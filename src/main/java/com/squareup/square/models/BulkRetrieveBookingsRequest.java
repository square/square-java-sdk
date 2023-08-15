
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveBookingsRequest type.
 */
public class BulkRetrieveBookingsRequest {
    private final List<String> bookingIds;

    /**
     * Initialization constructor.
     * @param  bookingIds  List of String value for bookingIds.
     */
    @JsonCreator
    public BulkRetrieveBookingsRequest(
            @JsonProperty("booking_ids") List<String> bookingIds) {
        this.bookingIds = bookingIds;
    }

    /**
     * Getter for BookingIds.
     * A non-empty list of [Booking](entity:Booking) IDs specifying bookings to retrieve.
     * @return Returns the List of String
     */
    @JsonGetter("booking_ids")
    public List<String> getBookingIds() {
        return bookingIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveBookingsRequest)) {
            return false;
        }
        BulkRetrieveBookingsRequest other = (BulkRetrieveBookingsRequest) obj;
        return Objects.equals(bookingIds, other.bookingIds);
    }

    /**
     * Converts this BulkRetrieveBookingsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveBookingsRequest [" + "bookingIds=" + bookingIds + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveBookingsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveBookingsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(bookingIds);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveBookingsRequest}.
     */
    public static class Builder {
        private List<String> bookingIds;

        /**
         * Initialization constructor.
         * @param  bookingIds  List of String value for bookingIds.
         */
        public Builder(List<String> bookingIds) {
            this.bookingIds = bookingIds;
        }

        /**
         * Setter for bookingIds.
         * @param  bookingIds  List of String value for bookingIds.
         * @return Builder
         */
        public Builder bookingIds(List<String> bookingIds) {
            this.bookingIds = bookingIds;
            return this;
        }

        /**
         * Builds a new {@link BulkRetrieveBookingsRequest} object using the set fields.
         * @return {@link BulkRetrieveBookingsRequest}
         */
        public BulkRetrieveBookingsRequest build() {
            return new BulkRetrieveBookingsRequest(bookingIds);
        }
    }
}
