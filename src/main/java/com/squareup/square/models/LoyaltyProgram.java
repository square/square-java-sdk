package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyProgram type.
 */
public class LoyaltyProgram {

    /**
     * Initialization constructor.
     * @param id
     * @param status
     * @param rewardTiers
     * @param terminology
     * @param locationIds
     * @param createdAt
     * @param updatedAt
     * @param accrualRules
     * @param expirationPolicy
     */
    @JsonCreator
    public LoyaltyProgram(
            @JsonProperty("id") String id,
            @JsonProperty("status") String status,
            @JsonProperty("reward_tiers") List<LoyaltyProgramRewardTier> rewardTiers,
            @JsonProperty("terminology") LoyaltyProgramTerminology terminology,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("accrual_rules") List<LoyaltyProgramAccrualRule> accrualRules,
            @JsonProperty("expiration_policy") LoyaltyProgramExpirationPolicy expirationPolicy) {
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

    private final String id;
    private final String status;
    private final List<LoyaltyProgramRewardTier> rewardTiers;
    private final LoyaltyProgramExpirationPolicy expirationPolicy;
    private final LoyaltyProgramTerminology terminology;
    private final List<String> locationIds;
    private final String createdAt;
    private final String updatedAt;
    private final List<LoyaltyProgramAccrualRule> accrualRules;
    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty program. Updates to 
     * the loyalty program do not modify the identifier.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Status.
     * Whether the program is currently active.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for RewardTiers.
     * The list of rewards for buyers, sorted by ascending points.
     */
    @JsonGetter("reward_tiers")
    public List<LoyaltyProgramRewardTier> getRewardTiers() {
        return this.rewardTiers;
    }

    /**
     * Getter for ExpirationPolicy.
     * Describes when the loyalty program expires.
     */
    @JsonGetter("expiration_policy")
    public LoyaltyProgramExpirationPolicy getExpirationPolicy() {
        return this.expirationPolicy;
    }

    /**
     * Getter for Terminology.
     */
    @JsonGetter("terminology")
    public LoyaltyProgramTerminology getTerminology() {
        return this.terminology;
    }

    /**
     * Getter for LocationIds.
     * The [locations](#type-Location) at which the program is active.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the program was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the reward was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for AccrualRules.
     * Defines how buyers can earn loyalty points.
     */
    @JsonGetter("accrual_rules")
    public List<LoyaltyProgramAccrualRule> getAccrualRules() {
        return this.accrualRules;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, status, rewardTiers, expirationPolicy, terminology, locationIds,
            createdAt, updatedAt, accrualRules);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyProgram)) {
            return false;
        }
        LoyaltyProgram loyaltyProgram = (LoyaltyProgram) obj;
        return Objects.equals(id, loyaltyProgram.id) &&
            Objects.equals(status, loyaltyProgram.status) &&
            Objects.equals(rewardTiers, loyaltyProgram.rewardTiers) &&
            Objects.equals(expirationPolicy, loyaltyProgram.expirationPolicy) &&
            Objects.equals(terminology, loyaltyProgram.terminology) &&
            Objects.equals(locationIds, loyaltyProgram.locationIds) &&
            Objects.equals(createdAt, loyaltyProgram.createdAt) &&
            Objects.equals(updatedAt, loyaltyProgram.updatedAt) &&
            Objects.equals(accrualRules, loyaltyProgram.accrualRules);
    }

    /**
     * Builds a new {@link LoyaltyProgram.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgram.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            status,
            rewardTiers,
            terminology,
            locationIds,
            createdAt,
            updatedAt,
            accrualRules)
            .expirationPolicy(getExpirationPolicy());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgram}
     */
    public static class Builder {
        private String id;
        private String status;
        private List<LoyaltyProgramRewardTier> rewardTiers;
        private LoyaltyProgramTerminology terminology;
        private List<String> locationIds;
        private String createdAt;
        private String updatedAt;
        private List<LoyaltyProgramAccrualRule> accrualRules;
        private LoyaltyProgramExpirationPolicy expirationPolicy;

        /**
         * Initialization constructor
         */
        public Builder(String id,
                String status,
                List<LoyaltyProgramRewardTier> rewardTiers,
                LoyaltyProgramTerminology terminology,
                List<String> locationIds,
                String createdAt,
                String updatedAt,
                List<LoyaltyProgramAccrualRule> accrualRules) {
            this.id = id;
            this.status = status;
            this.rewardTiers = rewardTiers;
            this.terminology = terminology;
            this.locationIds = locationIds;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.accrualRules = accrualRules;
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        /**
         * Setter for rewardTiers
         * @param rewardTiers
         * @return Builder
         */
        public Builder rewardTiers(List<LoyaltyProgramRewardTier> rewardTiers) {
            this.rewardTiers = rewardTiers;
            return this;
        }
        /**
         * Setter for terminology
         * @param terminology
         * @return Builder
         */
        public Builder terminology(LoyaltyProgramTerminology terminology) {
            this.terminology = terminology;
            return this;
        }
        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for accrualRules
         * @param accrualRules
         * @return Builder
         */
        public Builder accrualRules(List<LoyaltyProgramAccrualRule> accrualRules) {
            this.accrualRules = accrualRules;
            return this;
        }
        /**
         * Setter for expirationPolicy
         * @param expirationPolicy
         * @return Builder
         */
        public Builder expirationPolicy(LoyaltyProgramExpirationPolicy expirationPolicy) {
            this.expirationPolicy = expirationPolicy;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgram} object using the set fields.
         * @return {@link LoyaltyProgram}
         */
        public LoyaltyProgram build() {
            return new LoyaltyProgram(id,
                status,
                rewardTiers,
                terminology,
                locationIds,
                createdAt,
                updatedAt,
                accrualRules,
                expirationPolicy);
        }
    }
}
