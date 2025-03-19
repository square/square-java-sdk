package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventAccumulatePoints type.
 */
public class LoyaltyEventAccumulatePoints {
    private final String loyaltyProgramId;
    private final OptionalNullable<Integer> points;
    private final OptionalNullable<String> orderId;

    /**
     * Initialization constructor.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  points  Integer value for points.
     * @param  orderId  String value for orderId.
     */
    @JsonCreator
    public LoyaltyEventAccumulatePoints(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("points") Integer points,
            @JsonProperty("order_id") String orderId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = OptionalNullable.of(points);
        this.orderId = OptionalNullable.of(orderId);
    }

    /**
     * Initialization constructor.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  points  Integer value for points.
     * @param  orderId  String value for orderId.
     */
    protected LoyaltyEventAccumulatePoints(
            String loyaltyProgramId, OptionalNullable<Integer> points, OptionalNullable<String> orderId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.orderId = orderId;
    }

    /**
     * Getter for LoyaltyProgramId.
     * The ID of the [loyalty program](entity:LoyaltyProgram).
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * Internal Getter for Points.
     * The number of points accumulated by the event.
     * @return Returns the Internal Integer
     */
    @JsonGetter("points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetPoints() {
        return this.points;
    }

    /**
     * Getter for Points.
     * The number of points accumulated by the event.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getPoints() {
        return OptionalNullable.getFrom(points);
    }

    /**
     * Internal Getter for OrderId.
     * The ID of the [order](entity:Order) for which the buyer accumulated the points. This field is
     * returned only if the Orders API is used to process orders.
     * @return Returns the Internal String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderId() {
        return this.orderId;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order](entity:Order) for which the buyer accumulated the points. This field is
     * returned only if the Orders API is used to process orders.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, points, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventAccumulatePoints)) {
            return false;
        }
        LoyaltyEventAccumulatePoints other = (LoyaltyEventAccumulatePoints) obj;
        return Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
                && Objects.equals(points, other.points)
                && Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this LoyaltyEventAccumulatePoints into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventAccumulatePoints [" + "loyaltyProgramId=" + loyaltyProgramId + ", points=" + points
                + ", orderId=" + orderId + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventAccumulatePoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventAccumulatePoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().loyaltyProgramId(getLoyaltyProgramId());
        builder.points = internalGetPoints();
        builder.orderId = internalGetOrderId();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventAccumulatePoints}.
     */
    public static class Builder {
        private String loyaltyProgramId;
        private OptionalNullable<Integer> points;
        private OptionalNullable<String> orderId;

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
         * Setter for points.
         * @param  points  Integer value for points.
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = OptionalNullable.of(points);
            return this;
        }

        /**
         * UnSetter for points.
         * @return Builder
         */
        public Builder unsetPoints() {
            points = null;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = OptionalNullable.of(orderId);
            return this;
        }

        /**
         * UnSetter for orderId.
         * @return Builder
         */
        public Builder unsetOrderId() {
            orderId = null;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventAccumulatePoints} object using the set fields.
         * @return {@link LoyaltyEventAccumulatePoints}
         */
        public LoyaltyEventAccumulatePoints build() {
            return new LoyaltyEventAccumulatePoints(loyaltyProgramId, points, orderId);
        }
    }
}
