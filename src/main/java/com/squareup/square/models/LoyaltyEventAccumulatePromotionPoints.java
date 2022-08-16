
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventAccumulatePromotionPoints type.
 */
public class LoyaltyEventAccumulatePromotionPoints {
    private final String loyaltyProgramId;
    private final String loyaltyPromotionId;
    private final int points;
    private final String orderId;

    /**
     * Initialization constructor.
     * @param  points  int value for points.
     * @param  orderId  String value for orderId.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  loyaltyPromotionId  String value for loyaltyPromotionId.
     */
    @JsonCreator
    public LoyaltyEventAccumulatePromotionPoints(
            @JsonProperty("points") int points,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("loyalty_promotion_id") String loyaltyPromotionId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.loyaltyPromotionId = loyaltyPromotionId;
        this.points = points;
        this.orderId = orderId;
    }

    /**
     * Getter for LoyaltyProgramId.
     * The Square-assigned ID of the [loyalty program]($m/LoyaltyProgram).
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * Getter for LoyaltyPromotionId.
     * The Square-assigned ID of the [loyalty promotion]($m/LoyaltyPromotion).
     * @return Returns the String
     */
    @JsonGetter("loyalty_promotion_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLoyaltyPromotionId() {
        return loyaltyPromotionId;
    }

    /**
     * Getter for Points.
     * The number of points earned by the event.
     * @return Returns the int
     */
    @JsonGetter("points")
    public int getPoints() {
        return points;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order]($m/Order) for which the buyer earned the promotion points. Only
     * applications that use the Orders API to process orders can trigger this event.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, loyaltyPromotionId, points, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventAccumulatePromotionPoints)) {
            return false;
        }
        LoyaltyEventAccumulatePromotionPoints other = (LoyaltyEventAccumulatePromotionPoints) obj;
        return Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
            && Objects.equals(loyaltyPromotionId, other.loyaltyPromotionId)
            && Objects.equals(points, other.points)
            && Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this LoyaltyEventAccumulatePromotionPoints into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventAccumulatePromotionPoints [" + "points=" + points + ", orderId="
                + orderId + ", loyaltyProgramId=" + loyaltyProgramId + ", loyaltyPromotionId="
                + loyaltyPromotionId + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventAccumulatePromotionPoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventAccumulatePromotionPoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(points, orderId)
                .loyaltyProgramId(getLoyaltyProgramId())
                .loyaltyPromotionId(getLoyaltyPromotionId());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventAccumulatePromotionPoints}.
     */
    public static class Builder {
        private int points;
        private String orderId;
        private String loyaltyProgramId;
        private String loyaltyPromotionId;

        /**
         * Initialization constructor.
         * @param  points  int value for points.
         * @param  orderId  String value for orderId.
         */
        public Builder(int points, String orderId) {
            this.points = points;
            this.orderId = orderId;
        }

        /**
         * Setter for points.
         * @param  points  int value for points.
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for loyaltyProgramId.
         * @param  loyaltyProgramId  String value for loyaltyProgramId.
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        /**
         * Setter for loyaltyPromotionId.
         * @param  loyaltyPromotionId  String value for loyaltyPromotionId.
         * @return Builder
         */
        public Builder loyaltyPromotionId(String loyaltyPromotionId) {
            this.loyaltyPromotionId = loyaltyPromotionId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventAccumulatePromotionPoints} object using the set fields.
         * @return {@link LoyaltyEventAccumulatePromotionPoints}
         */
        public LoyaltyEventAccumulatePromotionPoints build() {
            return new LoyaltyEventAccumulatePromotionPoints(points, orderId, loyaltyProgramId,
                    loyaltyPromotionId);
        }
    }
}
