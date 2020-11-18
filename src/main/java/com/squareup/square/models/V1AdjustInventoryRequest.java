
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1AdjustInventoryRequest type.
 */
public class V1AdjustInventoryRequest {
    private final Double quantityDelta;
    private final String adjustmentType;
    private final String memo;

    /**
     * Initialization constructor.
     * @param quantityDelta Double value for quantityDelta.
     * @param adjustmentType String value for adjustmentType.
     * @param memo String value for memo.
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

    /**
     * Getter for QuantityDelta.
     * The number to adjust the variation's quantity by.
     * @return Returns the Double
     */
    @JsonGetter("quantity_delta")
    public Double getQuantityDelta() {
        return this.quantityDelta;
    }

    /**
     * Getter for AdjustmentType.
     * @return Returns the String
     */
    @JsonGetter("adjustment_type")
    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    /**
     * Getter for Memo.
     * A note about the inventory adjustment.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1AdjustInventoryRequest)) {
            return false;
        }
        V1AdjustInventoryRequest other = (V1AdjustInventoryRequest) obj;
        return Objects.equals(quantityDelta, other.quantityDelta)
            && Objects.equals(adjustmentType, other.adjustmentType)
            && Objects.equals(memo, other.memo);
    }

    /**
     * Converts this V1AdjustInventoryRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1AdjustInventoryRequest [" + "quantityDelta=" + quantityDelta + ", adjustmentType="
                + adjustmentType + ", memo=" + memo + "]";
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
     * Class to build instances of {@link V1AdjustInventoryRequest}.
     */
    public static class Builder {
        private Double quantityDelta;
        private String adjustmentType;
        private String memo;



        /**
         * Setter for quantityDelta.
         * @param quantityDelta Double value for quantityDelta.
         * @return Builder
         */
        public Builder quantityDelta(Double quantityDelta) {
            this.quantityDelta = quantityDelta;
            return this;
        }

        /**
         * Setter for adjustmentType.
         * @param adjustmentType String value for adjustmentType.
         * @return Builder
         */
        public Builder adjustmentType(String adjustmentType) {
            this.adjustmentType = adjustmentType;
            return this;
        }

        /**
         * Setter for memo.
         * @param memo String value for memo.
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
            return new V1AdjustInventoryRequest(quantityDelta, adjustmentType, memo);
        }
    }
}
