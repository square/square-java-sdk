
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateGiftCardRequest type.
 */
public class CreateGiftCardRequest {
    private final String idempotencyKey;
    private final String locationId;
    private final GiftCard giftCard;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  locationId  String value for locationId.
     * @param  giftCard  GiftCard value for giftCard.
     */
    @JsonCreator
    public CreateGiftCardRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("gift_card") GiftCard giftCard) {
        this.idempotencyKey = idempotencyKey;
        this.locationId = locationId;
        this.giftCard = giftCard;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique identifier for this request, used to ensure idempotency. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The ID of the [location]($m/Location) where the gift card should be registered for reporting
     * purposes. Gift cards can be redeemed at any of the seller's locations.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for GiftCard.
     * Represents a Square gift card.
     * @return Returns the GiftCard
     */
    @JsonGetter("gift_card")
    public GiftCard getGiftCard() {
        return giftCard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, locationId, giftCard);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateGiftCardRequest)) {
            return false;
        }
        CreateGiftCardRequest other = (CreateGiftCardRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(giftCard, other.giftCard);
    }

    /**
     * Converts this CreateGiftCardRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateGiftCardRequest [" + "idempotencyKey=" + idempotencyKey + ", locationId="
                + locationId + ", giftCard=" + giftCard + "]";
    }

    /**
     * Builds a new {@link CreateGiftCardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateGiftCardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, locationId, giftCard);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateGiftCardRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String locationId;
        private GiftCard giftCard;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  locationId  String value for locationId.
         * @param  giftCard  GiftCard value for giftCard.
         */
        public Builder(String idempotencyKey, String locationId, GiftCard giftCard) {
            this.idempotencyKey = idempotencyKey;
            this.locationId = locationId;
            this.giftCard = giftCard;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for giftCard.
         * @param  giftCard  GiftCard value for giftCard.
         * @return Builder
         */
        public Builder giftCard(GiftCard giftCard) {
            this.giftCard = giftCard;
            return this;
        }

        /**
         * Builds a new {@link CreateGiftCardRequest} object using the set fields.
         * @return {@link CreateGiftCardRequest}
         */
        public CreateGiftCardRequest build() {
            return new CreateGiftCardRequest(idempotencyKey, locationId, giftCard);
        }
    }
}
