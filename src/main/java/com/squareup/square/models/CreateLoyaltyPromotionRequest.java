
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateLoyaltyPromotionRequest type.
 */
public class CreateLoyaltyPromotionRequest {
    private final LoyaltyPromotion loyaltyPromotion;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  loyaltyPromotion  LoyaltyPromotion value for loyaltyPromotion.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateLoyaltyPromotionRequest(
            @JsonProperty("loyalty_promotion") LoyaltyPromotion loyaltyPromotion,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.loyaltyPromotion = loyaltyPromotion;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for LoyaltyPromotion.
     * Represents a promotion for a [loyalty program]($m/LoyaltyProgram). Loyalty promotions enable
     * buyers to earn extra points on top of those earned from the base program. A loyalty program
     * can have a maximum of 10 loyalty promotions with an `ACTIVE` or `SCHEDULED` status.
     * @return Returns the LoyaltyPromotion
     */
    @JsonGetter("loyalty_promotion")
    public LoyaltyPromotion getLoyaltyPromotion() {
        return loyaltyPromotion;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique identifier for this request, which is used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyPromotion, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateLoyaltyPromotionRequest)) {
            return false;
        }
        CreateLoyaltyPromotionRequest other = (CreateLoyaltyPromotionRequest) obj;
        return Objects.equals(loyaltyPromotion, other.loyaltyPromotion)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateLoyaltyPromotionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateLoyaltyPromotionRequest [" + "loyaltyPromotion=" + loyaltyPromotion
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateLoyaltyPromotionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyPromotionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyPromotion, idempotencyKey);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyPromotionRequest}.
     */
    public static class Builder {
        private LoyaltyPromotion loyaltyPromotion;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  loyaltyPromotion  LoyaltyPromotion value for loyaltyPromotion.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(LoyaltyPromotion loyaltyPromotion, String idempotencyKey) {
            this.loyaltyPromotion = loyaltyPromotion;
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for loyaltyPromotion.
         * @param  loyaltyPromotion  LoyaltyPromotion value for loyaltyPromotion.
         * @return Builder
         */
        public Builder loyaltyPromotion(LoyaltyPromotion loyaltyPromotion) {
            this.loyaltyPromotion = loyaltyPromotion;
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
         * Builds a new {@link CreateLoyaltyPromotionRequest} object using the set fields.
         * @return {@link CreateLoyaltyPromotionRequest}
         */
        public CreateLoyaltyPromotionRequest build() {
            return new CreateLoyaltyPromotionRequest(loyaltyPromotion, idempotencyKey);
        }
    }
}
