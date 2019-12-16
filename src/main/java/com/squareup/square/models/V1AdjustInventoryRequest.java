package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1AdjustInventoryRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(quantityDelta, adjustmentType, memo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1AdjustInventoryRequest)) {
            return false;
        }
        V1AdjustInventoryRequest v1AdjustInventoryRequest = (V1AdjustInventoryRequest) o;
        return Objects.equals(quantityDelta, v1AdjustInventoryRequest.quantityDelta) &&
            Objects.equals(adjustmentType, v1AdjustInventoryRequest.adjustmentType) &&
            Objects.equals(memo, v1AdjustInventoryRequest.memo);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .quantityDelta(getQuantityDelta())
            .adjustmentType(getAdjustmentType())
            .memo(getMemo());
            return builder;
    }

    public static class Builder {
        private Double quantityDelta;
        private String adjustmentType;
        private String memo;

        public Builder() { }

        public Builder quantityDelta(Double value) {
            quantityDelta = value;
            return this;
        }
        public Builder adjustmentType(String value) {
            adjustmentType = value;
            return this;
        }
        public Builder memo(String value) {
            memo = value;
            return this;
        }

        public V1AdjustInventoryRequest build() {
            return new V1AdjustInventoryRequest(quantityDelta,
                adjustmentType,
                memo);
        }
    }
}
