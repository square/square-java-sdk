package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1AdjustInventoryRequest type.
 */
public class V1AdjustInventoryRequest {

    /**
     * Initialization constructor.
     * @param quantityDelta
     * @param adjustmentType
     * @param memo
     */
    @JsonCreator
    public V1AdjustInventoryRequest(
            @JsonProperty("quantity_delta") Double quantityDelta,
            @JsonProperty("adjustment_type") String adjustmentType,
            @JsonProperty("memo") String memo) {
        this.quantityDelta = quantityDelta;
        this.adjustmentType = adjustmentType;
        this.memo = memo;
    }

    private final Double quantityDelta;
    private final String adjustmentType;
    private final String memo;
    /**
     * Getter for QuantityDelta.
     * The number to adjust the variation's quantity by.
     */
    @JsonGetter("quantity_delta")
    public Double getQuantityDelta() {
        return this.quantityDelta;
    }

    /**
     * Getter for AdjustmentType.
     */
    @JsonGetter("adjustment_type")
    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    /**
     * Getter for Memo.
     * A note about the inventory adjustment.
     */
    @JsonGetter("memo")
    public String getMemo() {
        return this.memo;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(quantityDelta, adjustmentType, memo);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1AdjustInventoryRequest)) {
            return false;
        }
        V1AdjustInventoryRequest v1AdjustInventoryRequest = (V1AdjustInventoryRequest) obj;
        return Objects.equals(quantityDelta, v1AdjustInventoryRequest.quantityDelta) &&
            Objects.equals(adjustmentType, v1AdjustInventoryRequest.adjustmentType) &&
            Objects.equals(memo, v1AdjustInventoryRequest.memo);
    }

    /**
     * Builds a new {@link V1AdjustInventoryRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1AdjustInventoryRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .quantityDelta(getQuantityDelta())
            .adjustmentType(getAdjustmentType())
            .memo(getMemo());
            return builder;
    }

    /**
     * Class to build instances of {@link V1AdjustInventoryRequest}
     */
    public static class Builder {
        private Double quantityDelta;
        private String adjustmentType;
        private String memo;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for quantityDelta
         * @param quantityDelta
         * @return Builder
         */
        public Builder quantityDelta(Double quantityDelta) {
            this.quantityDelta = quantityDelta;
            return this;
        }
        /**
         * Setter for adjustmentType
         * @param adjustmentType
         * @return Builder
         */
        public Builder adjustmentType(String adjustmentType) {
            this.adjustmentType = adjustmentType;
            return this;
        }
        /**
         * Setter for memo
         * @param memo
         * @return Builder
         */
        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        /**
         * Builds a new {@link V1AdjustInventoryRequest} object using the set fields.
         * @return {@link V1AdjustInventoryRequest}
         */
        public V1AdjustInventoryRequest build() {
            return new V1AdjustInventoryRequest(quantityDelta,
                adjustmentType,
                memo);
        }
    }
}
