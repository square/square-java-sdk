
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BookingCustomAttributeUpsertRequest type.
 */
public class BookingCustomAttributeUpsertRequest {
    private final String bookingId;
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  bookingId  String value for bookingId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public BookingCustomAttributeUpsertRequest(
            @JsonProperty("booking_id") String bookingId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.bookingId = bookingId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Initialization constructor.
     * @param  bookingId  String value for bookingId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */

    protected BookingCustomAttributeUpsertRequest(String bookingId, CustomAttribute customAttribute,
            OptionalNullable<String> idempotencyKey) {
        this.bookingId = bookingId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
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
     * Getter for CustomAttribute.
     * A custom attribute value. Each custom attribute value has a corresponding
     * `CustomAttributeDefinition` object.
     * @return Returns the CustomAttribute
     */
    @JsonGetter("custom_attribute")
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
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
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingCustomAttributeUpsertRequest)) {
            return false;
        }
        BookingCustomAttributeUpsertRequest other = (BookingCustomAttributeUpsertRequest) obj;
        return Objects.equals(bookingId, other.bookingId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this BookingCustomAttributeUpsertRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BookingCustomAttributeUpsertRequest [" + "bookingId=" + bookingId
                + ", customAttribute=" + customAttribute + ", idempotencyKey=" + idempotencyKey
                + "]";
    }

    /**
     * Builds a new {@link BookingCustomAttributeUpsertRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BookingCustomAttributeUpsertRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(bookingId, customAttribute);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link BookingCustomAttributeUpsertRequest}.
     */
    public static class Builder {
        private String bookingId;
        private CustomAttribute customAttribute;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  bookingId  String value for bookingId.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         */
        public Builder(String bookingId, CustomAttribute customAttribute) {
            this.bookingId = bookingId;
            this.customAttribute = customAttribute;
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
         * Setter for customAttribute.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @return Builder
         */
        public Builder customAttribute(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
            return this;
        }

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
         * Builds a new {@link BookingCustomAttributeUpsertRequest} object using the set fields.
         * @return {@link BookingCustomAttributeUpsertRequest}
         */
        public BookingCustomAttributeUpsertRequest build() {
            return new BookingCustomAttributeUpsertRequest(bookingId, customAttribute,
                    idempotencyKey);
        }
    }
}
