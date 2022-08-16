
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotion type.
 */
public class LoyaltyPromotion {
    private final String id;
    private final String name;
    private final LoyaltyPromotionIncentive incentive;
    private final LoyaltyPromotionAvailableTimeData availableTime;
    private final LoyaltyPromotionTriggerLimit triggerLimit;
    private final String status;
    private final String createdAt;
    private final String canceledAt;
    private final String updatedAt;
    private final String loyaltyProgramId;
    private final Money minimumSpendAmountMoney;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  incentive  LoyaltyPromotionIncentive value for incentive.
     * @param  availableTime  LoyaltyPromotionAvailableTimeData value for availableTime.
     * @param  id  String value for id.
     * @param  triggerLimit  LoyaltyPromotionTriggerLimit value for triggerLimit.
     * @param  status  String value for status.
     * @param  createdAt  String value for createdAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  minimumSpendAmountMoney  Money value for minimumSpendAmountMoney.
     */
    @JsonCreator
    public LoyaltyPromotion(
            @JsonProperty("name") String name,
            @JsonProperty("incentive") LoyaltyPromotionIncentive incentive,
            @JsonProperty("available_time") LoyaltyPromotionAvailableTimeData availableTime,
            @JsonProperty("id") String id,
            @JsonProperty("trigger_limit") LoyaltyPromotionTriggerLimit triggerLimit,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("canceled_at") String canceledAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("minimum_spend_amount_money") Money minimumSpendAmountMoney) {
        this.id = id;
        this.name = name;
        this.incentive = incentive;
        this.availableTime = availableTime;
        this.triggerLimit = triggerLimit;
        this.status = status;
        this.createdAt = createdAt;
        this.canceledAt = canceledAt;
        this.updatedAt = updatedAt;
        this.loyaltyProgramId = loyaltyProgramId;
        this.minimumSpendAmountMoney = minimumSpendAmountMoney;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the promotion.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * The name of the promotion.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Incentive.
     * Represents how points for a [loyalty promotion]($m/LoyaltyPromotion) are calculated, either
     * by multiplying the points earned from the base program or by adding a specified number of
     * points to the points earned from the base program.
     * @return Returns the LoyaltyPromotionIncentive
     */
    @JsonGetter("incentive")
    public LoyaltyPromotionIncentive getIncentive() {
        return incentive;
    }

    /**
     * Getter for AvailableTime.
     * Represents scheduling information that determines when purchases can qualify to earn points
     * from a [loyalty promotion]($m/LoyaltyPromotion).
     * @return Returns the LoyaltyPromotionAvailableTimeData
     */
    @JsonGetter("available_time")
    public LoyaltyPromotionAvailableTimeData getAvailableTime() {
        return availableTime;
    }

    /**
     * Getter for TriggerLimit.
     * Represents the number of times a buyer can earn points during a [loyalty
     * promotion]($m/LoyaltyPromotion). If this field is not set, buyers can trigger the promotion
     * an unlimited number of times to earn points during the time that the promotion is available.
     * A purchase that is disqualified from earning points because of this limit might qualify for
     * another active promotion.
     * @return Returns the LoyaltyPromotionTriggerLimit
     */
    @JsonGetter("trigger_limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyPromotionTriggerLimit getTriggerLimit() {
        return triggerLimit;
    }

    /**
     * Getter for Status.
     * Indicates the status of a [loyalty promotion]($m/LoyaltyPromotion).
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the promotion was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for CanceledAt.
     * The timestamp of when the promotion was canceled, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("canceled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the promotion was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for LoyaltyProgramId.
     * The ID of the [loyalty program]($m/LoyaltyProgram) associated with the promotion.
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * Getter for MinimumSpendAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("minimum_spend_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getMinimumSpendAmountMoney() {
        return minimumSpendAmountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, incentive, availableTime, triggerLimit, status, createdAt,
                canceledAt, updatedAt, loyaltyProgramId, minimumSpendAmountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotion)) {
            return false;
        }
        LoyaltyPromotion other = (LoyaltyPromotion) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(incentive, other.incentive)
            && Objects.equals(availableTime, other.availableTime)
            && Objects.equals(triggerLimit, other.triggerLimit)
            && Objects.equals(status, other.status)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(canceledAt, other.canceledAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
            && Objects.equals(minimumSpendAmountMoney, other.minimumSpendAmountMoney);
    }

    /**
     * Converts this LoyaltyPromotion into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotion [" + "name=" + name + ", incentive=" + incentive
                + ", availableTime=" + availableTime + ", id=" + id + ", triggerLimit="
                + triggerLimit + ", status=" + status + ", createdAt=" + createdAt + ", canceledAt="
                + canceledAt + ", updatedAt=" + updatedAt + ", loyaltyProgramId=" + loyaltyProgramId
                + ", minimumSpendAmountMoney=" + minimumSpendAmountMoney + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotion.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotion.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name, incentive, availableTime)
                .id(getId())
                .triggerLimit(getTriggerLimit())
                .status(getStatus())
                .createdAt(getCreatedAt())
                .canceledAt(getCanceledAt())
                .updatedAt(getUpdatedAt())
                .loyaltyProgramId(getLoyaltyProgramId())
                .minimumSpendAmountMoney(getMinimumSpendAmountMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotion}.
     */
    public static class Builder {
        private String name;
        private LoyaltyPromotionIncentive incentive;
        private LoyaltyPromotionAvailableTimeData availableTime;
        private String id;
        private LoyaltyPromotionTriggerLimit triggerLimit;
        private String status;
        private String createdAt;
        private String canceledAt;
        private String updatedAt;
        private String loyaltyProgramId;
        private Money minimumSpendAmountMoney;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         * @param  incentive  LoyaltyPromotionIncentive value for incentive.
         * @param  availableTime  LoyaltyPromotionAvailableTimeData value for availableTime.
         */
        public Builder(String name, LoyaltyPromotionIncentive incentive,
                LoyaltyPromotionAvailableTimeData availableTime) {
            this.name = name;
            this.incentive = incentive;
            this.availableTime = availableTime;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for incentive.
         * @param  incentive  LoyaltyPromotionIncentive value for incentive.
         * @return Builder
         */
        public Builder incentive(LoyaltyPromotionIncentive incentive) {
            this.incentive = incentive;
            return this;
        }

        /**
         * Setter for availableTime.
         * @param  availableTime  LoyaltyPromotionAvailableTimeData value for availableTime.
         * @return Builder
         */
        public Builder availableTime(LoyaltyPromotionAvailableTimeData availableTime) {
            this.availableTime = availableTime;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for triggerLimit.
         * @param  triggerLimit  LoyaltyPromotionTriggerLimit value for triggerLimit.
         * @return Builder
         */
        public Builder triggerLimit(LoyaltyPromotionTriggerLimit triggerLimit) {
            this.triggerLimit = triggerLimit;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for canceledAt.
         * @param  canceledAt  String value for canceledAt.
         * @return Builder
         */
        public Builder canceledAt(String canceledAt) {
            this.canceledAt = canceledAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
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
         * Setter for minimumSpendAmountMoney.
         * @param  minimumSpendAmountMoney  Money value for minimumSpendAmountMoney.
         * @return Builder
         */
        public Builder minimumSpendAmountMoney(Money minimumSpendAmountMoney) {
            this.minimumSpendAmountMoney = minimumSpendAmountMoney;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotion} object using the set fields.
         * @return {@link LoyaltyPromotion}
         */
        public LoyaltyPromotion build() {
            return new LoyaltyPromotion(name, incentive, availableTime, id, triggerLimit, status,
                    createdAt, canceledAt, updatedAt, loyaltyProgramId, minimumSpendAmountMoney);
        }
    }
}
