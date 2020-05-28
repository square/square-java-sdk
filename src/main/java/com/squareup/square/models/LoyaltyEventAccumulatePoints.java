package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventAccumulatePoints type.
 */
public class LoyaltyEventAccumulatePoints {

    /**
     * Initialization constructor.
     * @param loyaltyProgramId
     * @param points
     * @param orderId
     */
    @JsonCreator
    public LoyaltyEventAccumulatePoints(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("points") Integer points,
            @JsonProperty("order_id") String orderId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.orderId = orderId;
    }

    private final String loyaltyProgramId;
    private final Integer points;
    private final String orderId;
    /**
     * Getter for LoyaltyProgramId.
     * The ID of the [loyalty program](#type-LoyaltyProgram).
     */
    @JsonGetter("loyalty_program_id")
    public String getLoyaltyProgramId() {
        return this.loyaltyProgramId;
    }

    /**
     * Getter for Points.
     * The number of points accumulated by the event.
     */
    @JsonGetter("points")
    public Integer getPoints() {
        return this.points;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order](#type-Order) for which the buyer accumulated the points.
     * This field is returned only if the Orders API is used to process orders.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, points, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventAccumulatePoints)) {
            return false;
        }
        LoyaltyEventAccumulatePoints loyaltyEventAccumulatePoints = (LoyaltyEventAccumulatePoints) obj;
        return Objects.equals(loyaltyProgramId, loyaltyEventAccumulatePoints.loyaltyProgramId) &&
            Objects.equals(points, loyaltyEventAccumulatePoints.points) &&
            Objects.equals(orderId, loyaltyEventAccumulatePoints.orderId);
    }

    /**
     * Builds a new {@link LoyaltyEventAccumulatePoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventAccumulatePoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .loyaltyProgramId(getLoyaltyProgramId())
            .points(getPoints())
            .orderId(getOrderId());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventAccumulatePoints}
     */
    public static class Builder {
        private String loyaltyProgramId;
        private Integer points;
        private String orderId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for loyaltyProgramId
         * @param loyaltyProgramId
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }
        /**
         * Setter for points
         * @param points
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }
        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventAccumulatePoints} object using the set fields.
         * @return {@link LoyaltyEventAccumulatePoints}
         */
        public LoyaltyEventAccumulatePoints build() {
            return new LoyaltyEventAccumulatePoints(loyaltyProgramId,
                points,
                orderId);
        }
    }
}
