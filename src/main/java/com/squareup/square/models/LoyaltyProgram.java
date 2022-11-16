
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgram type.
 */
public class LoyaltyProgram {
    private final String id;
    private final String status;
    private final List<LoyaltyProgramRewardTier> rewardTiers;
    private final LoyaltyProgramExpirationPolicy expirationPolicy;
    private final LoyaltyProgramTerminology terminology;
    private final OptionalNullable<List<String>> locationIds;
    private final String createdAt;
    private final String updatedAt;
    private final List<LoyaltyProgramAccrualRule> accrualRules;

    /**
     * Initialization constructor.
     * @param  rewardTiers  List of LoyaltyProgramRewardTier value for rewardTiers.
     * @param  terminology  LoyaltyProgramTerminology value for terminology.
     * @param  accrualRules  List of LoyaltyProgramAccrualRule value for accrualRules.
     * @param  id  String value for id.
     * @param  status  String value for status.
     * @param  expirationPolicy  LoyaltyProgramExpirationPolicy value for expirationPolicy.
     * @param  locationIds  List of String value for locationIds.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public LoyaltyProgram(
            @JsonProperty("reward_tiers") List<LoyaltyProgramRewardTier> rewardTiers,
            @JsonProperty("terminology") LoyaltyProgramTerminology terminology,
            @JsonProperty("accrual_rules") List<LoyaltyProgramAccrualRule> accrualRules,
            @JsonProperty("id") String id,
            @JsonProperty("status") String status,
            @JsonProperty("expiration_policy") LoyaltyProgramExpirationPolicy expirationPolicy,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.status = status;
        this.rewardTiers = rewardTiers;
        this.expirationPolicy = expirationPolicy;
        this.terminology = terminology;
        this.locationIds = OptionalNullable.of(locationIds);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.accrualRules = accrualRules;
    }

    /**
     * Internal initialization constructor.
     */
    protected LoyaltyProgram(List<LoyaltyProgramRewardTier> rewardTiers,
            LoyaltyProgramTerminology terminology, List<LoyaltyProgramAccrualRule> accrualRules,
            String id, String status, LoyaltyProgramExpirationPolicy expirationPolicy,
            OptionalNullable<List<String>> locationIds, String createdAt, String updatedAt) {
        this.id = id;
        this.status = status;
        this.rewardTiers = rewardTiers;
        this.expirationPolicy = expirationPolicy;
        this.terminology = terminology;
        this.locationIds = locationIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.accrualRules = accrualRules;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty program. Updates to the loyalty program do not modify
     * the identifier.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Status.
     * Indicates whether the program is currently active.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for RewardTiers.
     * The list of rewards for buyers, sorted by ascending points.
     * @return Returns the List of LoyaltyProgramRewardTier
     */
    @JsonGetter("reward_tiers")
    public List<LoyaltyProgramRewardTier> getRewardTiers() {
        return rewardTiers;
    }

    /**
     * Getter for ExpirationPolicy.
     * Describes when the loyalty program expires.
     * @return Returns the LoyaltyProgramExpirationPolicy
     */
    @JsonGetter("expiration_policy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramExpirationPolicy getExpirationPolicy() {
        return expirationPolicy;
    }

    /**
     * Getter for Terminology.
     * Represents the naming used for loyalty points.
     * @return Returns the LoyaltyProgramTerminology
     */
    @JsonGetter("terminology")
    public LoyaltyProgramTerminology getTerminology() {
        return terminology;
    }

    /**
     * Internal Getter for LocationIds.
     * The [locations]($m/Location) at which the program is active.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * The [locations]($m/Location) at which the program is active.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the program was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the reward was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AccrualRules.
     * Defines how buyers can earn loyalty points from the base loyalty program. To check for
     * associated [loyalty promotions]($m/LoyaltyPromotion) that enable buyers to earn extra points,
     * call [ListLoyaltyPromotions]($e/Loyalty/ListLoyaltyPromotions).
     * @return Returns the List of LoyaltyProgramAccrualRule
     */
    @JsonGetter("accrual_rules")
    public List<LoyaltyProgramAccrualRule> getAccrualRules() {
        return accrualRules;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, rewardTiers, expirationPolicy, terminology, locationIds,
                createdAt, updatedAt, accrualRules);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgram)) {
            return false;
        }
        LoyaltyProgram other = (LoyaltyProgram) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(status, other.status)
            && Objects.equals(rewardTiers, other.rewardTiers)
            && Objects.equals(expirationPolicy, other.expirationPolicy)
            && Objects.equals(terminology, other.terminology)
            && Objects.equals(locationIds, other.locationIds)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(accrualRules, other.accrualRules);
    }

    /**
     * Converts this LoyaltyProgram into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgram [" + "rewardTiers=" + rewardTiers + ", terminology=" + terminology
                + ", accrualRules=" + accrualRules + ", id=" + id + ", status=" + status
                + ", expirationPolicy=" + expirationPolicy + ", locationIds=" + locationIds
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgram.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgram.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(rewardTiers, terminology, accrualRules)
                .id(getId())
                .status(getStatus())
                .expirationPolicy(getExpirationPolicy())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        builder.locationIds = internalGetLocationIds();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgram}.
     */
    public static class Builder {
        private List<LoyaltyProgramRewardTier> rewardTiers;
        private LoyaltyProgramTerminology terminology;
        private List<LoyaltyProgramAccrualRule> accrualRules;
        private String id;
        private String status;
        private LoyaltyProgramExpirationPolicy expirationPolicy;
        private OptionalNullable<List<String>> locationIds;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor.
         * @param  rewardTiers  List of LoyaltyProgramRewardTier value for rewardTiers.
         * @param  terminology  LoyaltyProgramTerminology value for terminology.
         * @param  accrualRules  List of LoyaltyProgramAccrualRule value for accrualRules.
         */
        public Builder(List<LoyaltyProgramRewardTier> rewardTiers,
                LoyaltyProgramTerminology terminology,
                List<LoyaltyProgramAccrualRule> accrualRules) {
            this.rewardTiers = rewardTiers;
            this.terminology = terminology;
            this.accrualRules = accrualRules;
        }

        /**
         * Setter for rewardTiers.
         * @param  rewardTiers  List of LoyaltyProgramRewardTier value for rewardTiers.
         * @return Builder
         */
        public Builder rewardTiers(List<LoyaltyProgramRewardTier> rewardTiers) {
            this.rewardTiers = rewardTiers;
            return this;
        }

        /**
         * Setter for terminology.
         * @param  terminology  LoyaltyProgramTerminology value for terminology.
         * @return Builder
         */
        public Builder terminology(LoyaltyProgramTerminology terminology) {
            this.terminology = terminology;
            return this;
        }

        /**
         * Setter for accrualRules.
         * @param  accrualRules  List of LoyaltyProgramAccrualRule value for accrualRules.
         * @return Builder
         */
        public Builder accrualRules(List<LoyaltyProgramAccrualRule> accrualRules) {
            this.accrualRules = accrualRules;
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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for expirationPolicy.
         * @param  expirationPolicy  LoyaltyProgramExpirationPolicy value for expirationPolicy.
         * @return Builder
         */
        public Builder expirationPolicy(LoyaltyProgramExpirationPolicy expirationPolicy) {
            this.expirationPolicy = expirationPolicy;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgram} object using the set fields.
         * @return {@link LoyaltyProgram}
         */
        public LoyaltyProgram build() {
            return new LoyaltyProgram(rewardTiers, terminology, accrualRules, id, status,
                    expirationPolicy, locationIds, createdAt, updatedAt);
        }
    }
}
