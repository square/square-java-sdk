package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyAccount type.
 */
public class LoyaltyAccount {

    /**
     * Initialization constructor.
     * @param mappings
     * @param programId
     * @param id
     * @param balance
     * @param lifetimePoints
     * @param customerId
     * @param enrolledAt
     * @param createdAt
     * @param updatedAt
     */
    @JsonCreator
    public LoyaltyAccount(
            @JsonProperty("mappings") List<LoyaltyAccountMapping> mappings,
            @JsonProperty("program_id") String programId,
            @JsonProperty("id") String id,
            @JsonProperty("balance") Integer balance,
            @JsonProperty("lifetime_points") Integer lifetimePoints,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("enrolled_at") String enrolledAt,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.mappings = mappings;
        this.programId = programId;
        this.balance = balance;
        this.lifetimePoints = lifetimePoints;
        this.customerId = customerId;
        this.enrolledAt = enrolledAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final String id;
    private final List<LoyaltyAccountMapping> mappings;
    private final String programId;
    private final Integer balance;
    private final Integer lifetimePoints;
    private final String customerId;
    private final String enrolledAt;
    private final String createdAt;
    private final String updatedAt;
    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty account.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Mappings.
     * The list of mappings that the account is associated with. 
     * Currently, a buyer can only be mapped to a loyalty account using 
     * a phone number. Therefore, the list can only have one mapping.
     */
    @JsonGetter("mappings")
    public List<LoyaltyAccountMapping> getMappings() {
        return this.mappings;
    }

    /**
     * Getter for ProgramId.
     * The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram) to which the account belongs.
     */
    @JsonGetter("program_id")
    public String getProgramId() {
        return this.programId;
    }

    /**
     * Getter for Balance.
     * The available point balance in the loyalty account.
     */
    @JsonGetter("balance")
    public Integer getBalance() {
        return this.balance;
    }

    /**
     * Getter for LifetimePoints.
     * The total points accrued during the lifetime of the account.
     */
    @JsonGetter("lifetime_points")
    public Integer getLifetimePoints() {
        return this.lifetimePoints;
    }

    /**
     * Getter for CustomerId.
     * The Square-assigned ID of the [customer](#type-Customer) that is associated with the account.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for EnrolledAt.
     * The timestamp when enrollment occurred, in RFC 3339 format.
     */
    @JsonGetter("enrolled_at")
    public String getEnrolledAt() {
        return this.enrolledAt;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the loyalty account was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the loyalty account was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, mappings, programId, balance, lifetimePoints, customerId, enrolledAt,
            createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyAccount)) {
            return false;
        }
        LoyaltyAccount loyaltyAccount = (LoyaltyAccount) obj;
        return Objects.equals(id, loyaltyAccount.id) &&
            Objects.equals(mappings, loyaltyAccount.mappings) &&
            Objects.equals(programId, loyaltyAccount.programId) &&
            Objects.equals(balance, loyaltyAccount.balance) &&
            Objects.equals(lifetimePoints, loyaltyAccount.lifetimePoints) &&
            Objects.equals(customerId, loyaltyAccount.customerId) &&
            Objects.equals(enrolledAt, loyaltyAccount.enrolledAt) &&
            Objects.equals(createdAt, loyaltyAccount.createdAt) &&
            Objects.equals(updatedAt, loyaltyAccount.updatedAt);
    }

    /**
     * Builds a new {@link LoyaltyAccount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(mappings,
            programId)
            .id(getId())
            .balance(getBalance())
            .lifetimePoints(getLifetimePoints())
            .customerId(getCustomerId())
            .enrolledAt(getEnrolledAt())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccount}
     */
    public static class Builder {
        private List<LoyaltyAccountMapping> mappings;
        private String programId;
        private String id;
        private Integer balance;
        private Integer lifetimePoints;
        private String customerId;
        private String enrolledAt;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor
         */
        public Builder(List<LoyaltyAccountMapping> mappings,
                String programId) {
            this.mappings = mappings;
            this.programId = programId;
        }

        /**
         * Setter for mappings
         * @param mappings
         * @return Builder
         */
        public Builder mappings(List<LoyaltyAccountMapping> mappings) {
            this.mappings = mappings;
            return this;
        }
        /**
         * Setter for programId
         * @param programId
         * @return Builder
         */
        public Builder programId(String programId) {
            this.programId = programId;
            return this;
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
         * Setter for balance
         * @param balance
         * @return Builder
         */
        public Builder balance(Integer balance) {
            this.balance = balance;
            return this;
        }
        /**
         * Setter for lifetimePoints
         * @param lifetimePoints
         * @return Builder
         */
        public Builder lifetimePoints(Integer lifetimePoints) {
            this.lifetimePoints = lifetimePoints;
            return this;
        }
        /**
         * Setter for customerId
         * @param customerId
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        /**
         * Setter for enrolledAt
         * @param enrolledAt
         * @return Builder
         */
        public Builder enrolledAt(String enrolledAt) {
            this.enrolledAt = enrolledAt;
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
         * Builds a new {@link LoyaltyAccount} object using the set fields.
         * @return {@link LoyaltyAccount}
         */
        public LoyaltyAccount build() {
            return new LoyaltyAccount(mappings,
                programId,
                id,
                balance,
                lifetimePoints,
                customerId,
                enrolledAt,
                createdAt,
                updatedAt);
        }
    }
}
