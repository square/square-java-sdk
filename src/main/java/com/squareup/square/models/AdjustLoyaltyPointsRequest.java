
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
 * This is a model class for AdjustLoyaltyPointsRequest type.
 */
public class AdjustLoyaltyPointsRequest {
    private final String idempotencyKey;
    private final LoyaltyEventAdjustPoints adjustPoints;
    private final OptionalNullable<Boolean> allowNegativeBalance;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
     * @param  allowNegativeBalance  Boolean value for allowNegativeBalance.
     */
    @JsonCreator
    public AdjustLoyaltyPointsRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("adjust_points") LoyaltyEventAdjustPoints adjustPoints,
            @JsonProperty("allow_negative_balance") Boolean allowNegativeBalance) {
        this.idempotencyKey = idempotencyKey;
        this.adjustPoints = adjustPoints;
        this.allowNegativeBalance = OptionalNullable.of(allowNegativeBalance);
    }

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
     * @param  allowNegativeBalance  Boolean value for allowNegativeBalance.
     */

    protected AdjustLoyaltyPointsRequest(String idempotencyKey,
            LoyaltyEventAdjustPoints adjustPoints,
            OptionalNullable<Boolean> allowNegativeBalance) {
        this.idempotencyKey = idempotencyKey;
        this.adjustPoints = adjustPoints;
        this.allowNegativeBalance = allowNegativeBalance;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `AdjustLoyaltyPoints` request. Keys can be any valid
     * string, but must be unique for every request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for AdjustPoints.
     * Provides metadata when the event `type` is `ADJUST_POINTS`.
     * @return Returns the LoyaltyEventAdjustPoints
     */
    @JsonGetter("adjust_points")
    public LoyaltyEventAdjustPoints getAdjustPoints() {
        return adjustPoints;
    }

    /**
     * Internal Getter for AllowNegativeBalance.
     * Indicates whether to allow a negative adjustment to result in a negative balance. If `true`,
     * a negative balance is allowed when subtracting points. If `false`, Square returns a
     * `BAD_REQUEST` error when subtracting the specified number of points would result in a
     * negative balance. The default value is `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("allow_negative_balance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllowNegativeBalance() {
        return this.allowNegativeBalance;
    }

    /**
     * Getter for AllowNegativeBalance.
     * Indicates whether to allow a negative adjustment to result in a negative balance. If `true`,
     * a negative balance is allowed when subtracting points. If `false`, Square returns a
     * `BAD_REQUEST` error when subtracting the specified number of points would result in a
     * negative balance. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllowNegativeBalance() {
        return OptionalNullable.getFrom(allowNegativeBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, adjustPoints, allowNegativeBalance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdjustLoyaltyPointsRequest)) {
            return false;
        }
        AdjustLoyaltyPointsRequest other = (AdjustLoyaltyPointsRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(adjustPoints, other.adjustPoints)
            && Objects.equals(allowNegativeBalance, other.allowNegativeBalance);
    }

    /**
     * Converts this AdjustLoyaltyPointsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AdjustLoyaltyPointsRequest [" + "idempotencyKey=" + idempotencyKey
                + ", adjustPoints=" + adjustPoints + ", allowNegativeBalance="
                + allowNegativeBalance + "]";
    }

    /**
     * Builds a new {@link AdjustLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdjustLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, adjustPoints);
        builder.allowNegativeBalance = internalGetAllowNegativeBalance();
        return builder;
    }

    /**
     * Class to build instances of {@link AdjustLoyaltyPointsRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private LoyaltyEventAdjustPoints adjustPoints;
        private OptionalNullable<Boolean> allowNegativeBalance;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
         */
        public Builder(String idempotencyKey, LoyaltyEventAdjustPoints adjustPoints) {
            this.idempotencyKey = idempotencyKey;
            this.adjustPoints = adjustPoints;
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
         * Setter for adjustPoints.
         * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
         * @return Builder
         */
        public Builder adjustPoints(LoyaltyEventAdjustPoints adjustPoints) {
            this.adjustPoints = adjustPoints;
            return this;
        }

        /**
         * Setter for allowNegativeBalance.
         * @param  allowNegativeBalance  Boolean value for allowNegativeBalance.
         * @return Builder
         */
        public Builder allowNegativeBalance(Boolean allowNegativeBalance) {
            this.allowNegativeBalance = OptionalNullable.of(allowNegativeBalance);
            return this;
        }

        /**
         * UnSetter for allowNegativeBalance.
         * @return Builder
         */
        public Builder unsetAllowNegativeBalance() {
            allowNegativeBalance = null;
            return this;
        }

        /**
         * Builds a new {@link AdjustLoyaltyPointsRequest} object using the set fields.
         * @return {@link AdjustLoyaltyPointsRequest}
         */
        public AdjustLoyaltyPointsRequest build() {
            return new AdjustLoyaltyPointsRequest(idempotencyKey, adjustPoints,
                    allowNegativeBalance);
        }
    }
}
