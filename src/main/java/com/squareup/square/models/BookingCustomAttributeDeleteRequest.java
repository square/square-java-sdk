
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BookingCustomAttributeDeleteRequest type.
 */
public class BookingCustomAttributeDeleteRequest {
    private final String bookingId;
    private final String key;

    /**
     * Initialization constructor.
     * @param  bookingId  String value for bookingId.
     * @param  key  String value for key.
     */
    @JsonCreator
    public BookingCustomAttributeDeleteRequest(
            @JsonProperty("booking_id") String bookingId,
            @JsonProperty("key") String key) {
        this.bookingId = bookingId;
        this.key = key;
    }

    /**
     * Getter for BookingId.
     * The ID of the target [booking](entity:Booking).
     * @return Returns the String
     */
    @JsonGetter("booking_id")
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Getter for Key.
     * The key of the custom attribute to delete. This key must match the `key` of a custom
     * attribute definition in the Square seller account. If the requesting application is not the
     * definition owner, you must use the qualified key.
     * @return Returns the String
     */
    @JsonGetter("key")
    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, key);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingCustomAttributeDeleteRequest)) {
            return false;
        }
        BookingCustomAttributeDeleteRequest other = (BookingCustomAttributeDeleteRequest) obj;
        return Objects.equals(bookingId, other.bookingId)
            && Objects.equals(key, other.key);
    }

    /**
     * Converts this BookingCustomAttributeDeleteRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BookingCustomAttributeDeleteRequest [" + "bookingId=" + bookingId + ", key=" + key
                + "]";
    }

    /**
     * Builds a new {@link BookingCustomAttributeDeleteRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BookingCustomAttributeDeleteRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(bookingId, key);
        return builder;
    }

    /**
     * Class to build instances of {@link BookingCustomAttributeDeleteRequest}.
     */
    public static class Builder {
        private String bookingId;
        private String key;

        /**
         * Initialization constructor.
         * @param  bookingId  String value for bookingId.
         * @param  key  String value for key.
         */
        public Builder(String bookingId, String key) {
            this.bookingId = bookingId;
            this.key = key;
        }

        /**
         * Setter for bookingId.
         * @param  bookingId  String value for bookingId.
         * @return Builder
         */
        public Builder bookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        /**
         * Setter for key.
         * @param  key  String value for key.
         * @return Builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Builds a new {@link BookingCustomAttributeDeleteRequest} object using the set fields.
         * @return {@link BookingCustomAttributeDeleteRequest}
         */
        public BookingCustomAttributeDeleteRequest build() {
            return new BookingCustomAttributeDeleteRequest(bookingId, key);
        }
    }
}
