
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for LoyaltyAccount type.
 */
public class LoyaltyAccount {
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
     * Initialization constructor.
     * @param mappings List of LoyaltyAccountMapping value for mappings.
     * @param programId String value for programId.
     * @param id String value for id.
     * @param balance Integer value for balance.
     * @param lifetimePoints Integer value for lifetimePoints.
     * @param customerId String value for customerId.
     * @param enrolledAt String value for enrolledAt.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
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

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty account.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Mappings.
     * The list of mappings that the account is associated with. Currently, a buyer can only be
     * mapped to a loyalty account using a phone number. Therefore, the list can only have one
     * mapping.
     * @return Returns the List of LoyaltyAccountMapping
     */
    @JsonGetter("mappings")
    public List<LoyaltyAccountMapping> getMappings() {
        return this.mappings;
    }

    /**
     * Getter for ProgramId.
     * The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram) to which the account
     * belongs.
     * @return Returns the String
     */
    @JsonGetter("program_id")
    public String getProgramId() {
        return this.programId;
    }

    /**
     * Getter for Balance.
     * The available point balance in the loyalty account. Your application should be able to handle
     * loyalty accounts that have a negative point balance (`balance` is less than 0). This might
     * occur if a seller makes a manual adjustment or as a result of a refund or exchange.
     * @return Returns the Integer
     */
    @JsonGetter("balance")
    public Integer getBalance() {
        return this.balance;
    }

    /**
     * Getter for LifetimePoints.
     * The total points accrued during the lifetime of the account.
     * @return Returns the Integer
     */
    @JsonGetter("lifetime_points")
    public Integer getLifetimePoints() {
        return this.lifetimePoints;
    }

    /**
     * Getter for CustomerId.
     * The Square-assigned ID of the [customer](#type-Customer) that is associated with the account.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for EnrolledAt.
     * The timestamp when enrollment occurred, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("enrolled_at")
    public String getEnrolledAt() {
        return this.enrolledAt;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the loyalty account was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the loyalty account was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, mappings, programId, balance, lifetimePoints, customerId,
                enrolledAt, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyAccount)) {
            return false;
        }
        LoyaltyAccount other = (LoyaltyAccount) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(mappings, other.mappings)
            && Objects.equals(programId, other.programId)
            && Objects.equals(balance, other.balance)
            && Objects.equals(lifetimePoints, other.lifetimePoints)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(enrolledAt, other.enrolledAt)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
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
     * Class to build instances of {@link LoyaltyAccount}.
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
         * Initialization constructor.
         * @param mappings List of LoyaltyAccountMapping value for mappings.
         * @param programId String value for programId.
         */
        public Builder(List<LoyaltyAccountMapping> mappings,
                String programId) {
            this.mappings = mappings;
            this.programId = programId;
        }

        /**
         * Setter for mappings.
         * @param mappings List of LoyaltyAccountMapping value for mappings.
         * @return Builder
         */
        public Builder mappings(List<LoyaltyAccountMapping> mappings) {
            this.mappings = mappings;
            return this;
        }

        /**
         * Setter for programId.
         * @param programId String value for programId.
         * @return Builder
         */
        public Builder programId(String programId) {
            this.programId = programId;
            return this;
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
         * Setter for balance.
         * @param balance Integer value for balance.
         * @return Builder
         */
        public Builder balance(Integer balance) {
            this.balance = balance;
            return this;
        }

        /**
         * Setter for lifetimePoints.
         * @param lifetimePoints Integer value for lifetimePoints.
         * @return Builder
         */
        public Builder lifetimePoints(Integer lifetimePoints) {
            this.lifetimePoints = lifetimePoints;
            return this;
        }

        /**
         * Setter for customerId.
         * @param customerId String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for enrolledAt.
         * @param enrolledAt String value for enrolledAt.
         * @return Builder
         */
        public Builder enrolledAt(String enrolledAt) {
            this.enrolledAt = enrolledAt;
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
