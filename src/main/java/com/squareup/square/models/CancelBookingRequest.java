
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CancelBookingRequest type.
 */
public class CancelBookingRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer bookingVersion;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  bookingVersion  Integer value for bookingVersion.
     */
    @JsonCreator
    public CancelBookingRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("booking_version") Integer bookingVersion) {
        this.idempotencyKey = idempotencyKey;
        this.bookingVersion = bookingVersion;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique key to make this request an idempotent operation.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for BookingVersion.
     * The revision number for the booking used for optimistic concurrency.
     * @return Returns the Integer
     */
    @JsonGetter("booking_version")
    public Integer getBookingVersion() {
        return bookingVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, bookingVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelBookingRequest)) {
            return false;
        }
        CancelBookingRequest other = (CancelBookingRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(bookingVersion, other.bookingVersion);
    }

    /**
     * Converts this CancelBookingRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CancelBookingRequest [" + "idempotencyKey=" + idempotencyKey + ", bookingVersion="
                + bookingVersion + "]";
    }

    /**
     * Builds a new {@link CancelBookingRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelBookingRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey())
                .bookingVersion(getBookingVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link CancelBookingRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Integer bookingVersion;



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
         * Setter for bookingVersion.
         * @param  bookingVersion  Integer value for bookingVersion.
         * @return Builder
         */
        public Builder bookingVersion(Integer bookingVersion) {
            this.bookingVersion = bookingVersion;
            return this;
        }

        /**
         * Builds a new {@link CancelBookingRequest} object using the set fields.
         * @return {@link CancelBookingRequest}
         */
        public CancelBookingRequest build() {
            return new CancelBookingRequest(idempotencyKey, bookingVersion);
        }
    }
}
