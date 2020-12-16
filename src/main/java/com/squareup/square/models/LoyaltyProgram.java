
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private final List<String> locationIds;
    private final String createdAt;
    private final String updatedAt;
    private final List<LoyaltyProgramAccrualRule> accrualRules;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param status String value for status.
     * @param rewardTiers List of LoyaltyProgramRewardTier value for rewardTiers.
     * @param terminology LoyaltyProgramTerminology value for terminology.
     * @param locationIds List of String value for locationIds.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
     * @param accrualRules List of LoyaltyProgramAccrualRule value for accrualRules.
     * @param expirationPolicy LoyaltyProgramExpirationPolicy value for expirationPolicy.
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

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty program. Updates to the loyalty program do not modify
     * the identifier.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Status.
     * Indicates whether the program is currently active.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for RewardTiers.
     * The list of rewards for buyers, sorted by ascending points.
     * @return Returns the List of LoyaltyProgramRewardTier
     */
    @JsonGetter("reward_tiers")
    public List<LoyaltyProgramRewardTier> getRewardTiers() {
        return this.rewardTiers;
    }

    /**
     * Getter for ExpirationPolicy.
     * Describes when the loyalty program expires.
     * @return Returns the LoyaltyProgramExpirationPolicy
     */
    @JsonGetter("expiration_policy")
    public LoyaltyProgramExpirationPolicy getExpirationPolicy() {
        return this.expirationPolicy;
    }

    /**
     * Getter for Terminology.
     * @return Returns the LoyaltyProgramTerminology
     */
    @JsonGetter("terminology")
    public LoyaltyProgramTerminology getTerminology() {
        return this.terminology;
    }

    /**
     * Getter for LocationIds.
     * The [locations](#type-Location) at which the program is active.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the program was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the reward was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for AccrualRules.
     * Defines how buyers can earn loyalty points.
     * @return Returns the List of LoyaltyProgramAccrualRule
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
        return "LoyaltyProgram [" + "id=" + id + ", status=" + status + ", rewardTiers="
                + rewardTiers + ", terminology=" + terminology + ", locationIds=" + locationIds
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", accrualRules="
                + accrualRules + ", expirationPolicy=" + expirationPolicy + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgram.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgram.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, status, rewardTiers, terminology, locationIds, createdAt,
                updatedAt, accrualRules)
                .expirationPolicy(getExpirationPolicy());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgram}.
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
         * Initialization constructor.
         * @param id String value for id.
         * @param status String value for status.
         * @param rewardTiers List of LoyaltyProgramRewardTier value for rewardTiers.
         * @param terminology LoyaltyProgramTerminology value for terminology.
         * @param locationIds List of String value for locationIds.
         * @param createdAt String value for createdAt.
         * @param updatedAt String value for updatedAt.
         * @param accrualRules List of LoyaltyProgramAccrualRule value for accrualRules.
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
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for rewardTiers.
         * @param rewardTiers List of LoyaltyProgramRewardTier value for rewardTiers.
         * @return Builder
         */
        public Builder rewardTiers(List<LoyaltyProgramRewardTier> rewardTiers) {
            this.rewardTiers = rewardTiers;
            return this;
        }

        /**
         * Setter for terminology.
         * @param terminology LoyaltyProgramTerminology value for terminology.
         * @return Builder
         */
        public Builder terminology(LoyaltyProgramTerminology terminology) {
            this.terminology = terminology;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param locationIds List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param updatedAt String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for accrualRules.
         * @param accrualRules List of LoyaltyProgramAccrualRule value for accrualRules.
         * @return Builder
         */
        public Builder accrualRules(List<LoyaltyProgramAccrualRule> accrualRules) {
            this.accrualRules = accrualRules;
            return this;
        }

        /**
         * Setter for expirationPolicy.
         * @param expirationPolicy LoyaltyProgramExpirationPolicy value for expirationPolicy.
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
            return new LoyaltyProgram(id, status, rewardTiers, terminology, locationIds, createdAt,
                    updatedAt, accrualRules, expirationPolicy);
        }
    }
}
