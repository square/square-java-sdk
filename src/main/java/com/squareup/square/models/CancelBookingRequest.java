
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CancelBookingRequest type.
 */
public class CancelBookingRequest {
    private final OptionalNullable<String> idempotencyKey;
    private final OptionalNullable<Integer> bookingVersion;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  bookingVersion  Integer value for bookingVersion.
     */
    @JsonCreator
    public CancelBookingRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("booking_version") Integer bookingVersion) {
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
        this.bookingVersion = OptionalNullable.of(bookingVersion);
    }

    /**
     * Internal initialization constructor.
     */
    protected CancelBookingRequest(OptionalNullable<String> idempotencyKey,
            OptionalNullable<Integer> bookingVersion) {
        this.idempotencyKey = idempotencyKey;
        this.bookingVersion = bookingVersion;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A unique key to make this request an idempotent operation.
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique key to make this request an idempotent operation.
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    /**
     * Internal Getter for BookingVersion.
     * The revision number for the booking used for optimistic concurrency.
     * @return Returns the Internal Integer
     */
    @JsonGetter("booking_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetBookingVersion() {
        return this.bookingVersion;
    }

    /**
     * Getter for BookingVersion.
     * The revision number for the booking used for optimistic concurrency.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getBookingVersion() {
        return OptionalNullable.getFrom(bookingVersion);
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
        Builder builder = new Builder();
        builder.idempotencyKey = internalGetIdempotencyKey();
        builder.bookingVersion = internalGetBookingVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link CancelBookingRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> idempotencyKey;
        private OptionalNullable<Integer> bookingVersion;



        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Setter for bookingVersion.
         * @param  bookingVersion  Integer value for bookingVersion.
         * @return Builder
         */
        public Builder bookingVersion(Integer bookingVersion) {
            this.bookingVersion = OptionalNullable.of(bookingVersion);
            return this;
        }

        /**
         * UnSetter for bookingVersion.
         * @return Builder
         */
        public Builder unsetBookingVersion() {
            bookingVersion = null;
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
