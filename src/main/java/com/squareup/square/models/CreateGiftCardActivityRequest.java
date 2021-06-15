
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateGiftCardActivityRequest type.
 */
public class CreateGiftCardActivityRequest {
    private final String idempotencyKey;
    private final GiftCardActivity giftCardActivity;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  giftCardActivity  GiftCardActivity value for giftCardActivity.
     */
    @JsonCreator
    public CreateGiftCardActivityRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("gift_card_activity") GiftCardActivity giftCardActivity) {
        this.idempotencyKey = idempotencyKey;
        this.giftCardActivity = giftCardActivity;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `CreateGiftCardActivity` request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for GiftCardActivity.
     * Represents an action performed on a gift card that affects its state or balance.
     * @return Returns the GiftCardActivity
     */
    @JsonGetter("gift_card_activity")
    public GiftCardActivity getGiftCardActivity() {
        return giftCardActivity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, giftCardActivity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateGiftCardActivityRequest)) {
            return false;
        }
        CreateGiftCardActivityRequest other = (CreateGiftCardActivityRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(giftCardActivity, other.giftCardActivity);
    }

    /**
     * Converts this CreateGiftCardActivityRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateGiftCardActivityRequest [" + "idempotencyKey=" + idempotencyKey
                + ", giftCardActivity=" + giftCardActivity + "]";
    }

    /**
     * Builds a new {@link CreateGiftCardActivityRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateGiftCardActivityRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, giftCardActivity);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateGiftCardActivityRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private GiftCardActivity giftCardActivity;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  giftCardActivity  GiftCardActivity value for giftCardActivity.
         */
        public Builder(String idempotencyKey, GiftCardActivity giftCardActivity) {
            this.idempotencyKey = idempotencyKey;
            this.giftCardActivity = giftCardActivity;
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
         * Setter for giftCardActivity.
         * @param  giftCardActivity  GiftCardActivity value for giftCardActivity.
         * @return Builder
         */
        public Builder giftCardActivity(GiftCardActivity giftCardActivity) {
            this.giftCardActivity = giftCardActivity;
            return this;
        }

        /**
         * Builds a new {@link CreateGiftCardActivityRequest} object using the set fields.
         * @return {@link CreateGiftCardActivityRequest}
         */
        public CreateGiftCardActivityRequest build() {
            return new CreateGiftCardActivityRequest(idempotencyKey, giftCardActivity);
        }
    }
}
