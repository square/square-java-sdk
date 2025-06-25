package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyAccount type.
 */
public class LoyaltyAccount {
    private final String id;
    private final String programId;
    private final Integer balance;
    private final Integer lifetimePoints;
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<String> enrolledAt;
    private final String createdAt;
    private final String updatedAt;
    private final LoyaltyAccountMapping mapping;
    private final OptionalNullable<List<LoyaltyAccountExpiringPointDeadline>> expiringPointDeadlines;

    /**
     * Initialization constructor.
     * @param  programId  String value for programId.
     * @param  id  String value for id.
     * @param  balance  Integer value for balance.
     * @param  lifetimePoints  Integer value for lifetimePoints.
     * @param  customerId  String value for customerId.
     * @param  enrolledAt  String value for enrolledAt.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  mapping  LoyaltyAccountMapping value for mapping.
     * @param  expiringPointDeadlines  List of LoyaltyAccountExpiringPointDeadline value for
     *         expiringPointDeadlines.
     */
    @JsonCreator
    public LoyaltyAccount(
            @JsonProperty("program_id") String programId,
            @JsonProperty("id") String id,
            @JsonProperty("balance") Integer balance,
            @JsonProperty("lifetime_points") Integer lifetimePoints,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("enrolled_at") String enrolledAt,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("mapping") LoyaltyAccountMapping mapping,
            @JsonProperty("expiring_point_deadlines")
                    List<LoyaltyAccountExpiringPointDeadline> expiringPointDeadlines) {
        this.id = id;
        this.programId = programId;
        this.balance = balance;
        this.lifetimePoints = lifetimePoints;
        this.customerId = OptionalNullable.of(customerId);
        this.enrolledAt = OptionalNullable.of(enrolledAt);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mapping = mapping;
        this.expiringPointDeadlines = OptionalNullable.of(expiringPointDeadlines);
    }

    /**
     * Initialization constructor.
     * @param  programId  String value for programId.
     * @param  id  String value for id.
     * @param  balance  Integer value for balance.
     * @param  lifetimePoints  Integer value for lifetimePoints.
     * @param  customerId  String value for customerId.
     * @param  enrolledAt  String value for enrolledAt.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  mapping  LoyaltyAccountMapping value for mapping.
     * @param  expiringPointDeadlines  List of LoyaltyAccountExpiringPointDeadline value for
     *         expiringPointDeadlines.
     */
    protected LoyaltyAccount(
            String programId,
            String id,
            Integer balance,
            Integer lifetimePoints,
            OptionalNullable<String> customerId,
            OptionalNullable<String> enrolledAt,
            String createdAt,
            String updatedAt,
            LoyaltyAccountMapping mapping,
            OptionalNullable<List<LoyaltyAccountExpiringPointDeadline>> expiringPointDeadlines) {
        this.id = id;
        this.programId = programId;
        this.balance = balance;
        this.lifetimePoints = lifetimePoints;
        this.customerId = customerId;
        this.enrolledAt = enrolledAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mapping = mapping;
        this.expiringPointDeadlines = expiringPointDeadlines;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty account.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for ProgramId.
     * The Square-assigned ID of the [loyalty program](entity:LoyaltyProgram) to which the account
     * belongs.
     * @return Returns the String
     */
    @JsonGetter("program_id")
    public String getProgramId() {
        return programId;
    }

    /**
     * Getter for Balance.
     * The available point balance in the loyalty account. If points are scheduled to expire, they
     * are listed in the `expiring_point_deadlines` field. Your application should be able to handle
     * loyalty accounts that have a negative point balance (`balance` is less than 0). This might
     * occur if a seller makes a manual adjustment or as a result of a refund or exchange.
     * @return Returns the Integer
     */
    @JsonGetter("balance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getBalance() {
        return balance;
    }

    /**
     * Getter for LifetimePoints.
     * The total points accrued during the lifetime of the account.
     * @return Returns the Integer
     */
    @JsonGetter("lifetime_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLifetimePoints() {
        return lifetimePoints;
    }

    /**
     * Internal Getter for CustomerId.
     * The Square-assigned ID of the [customer](entity:Customer) that is associated with the
     * account.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The Square-assigned ID of the [customer](entity:Customer) that is associated with the
     * account.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for EnrolledAt.
     * The timestamp when the buyer joined the loyalty program, in RFC 3339 format. This field is
     * used to display the **Enrolled On** or **Member Since** date in first-party Square products.
     * If this field is not set in a `CreateLoyaltyAccount` request, Square populates it after the
     * buyer's first action on their account (when `AccumulateLoyaltyPoints` or
     * `CreateLoyaltyReward` is called). In first-party flows, Square populates the field when the
     * buyer agrees to the terms of service in Square Point of Sale. This field is typically
     * specified in a `CreateLoyaltyAccount` request when creating a loyalty account for a buyer who
     * already interacted with their account. For example, you would set this field when migrating
     * accounts from an external system. The timestamp in the request can represent a current or
     * previous date and time, but it cannot be set for the future.
     * @return Returns the Internal String
     */
    @JsonGetter("enrolled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEnrolledAt() {
        return this.enrolledAt;
    }

    /**
     * Getter for EnrolledAt.
     * The timestamp when the buyer joined the loyalty program, in RFC 3339 format. This field is
     * used to display the **Enrolled On** or **Member Since** date in first-party Square products.
     * If this field is not set in a `CreateLoyaltyAccount` request, Square populates it after the
     * buyer's first action on their account (when `AccumulateLoyaltyPoints` or
     * `CreateLoyaltyReward` is called). In first-party flows, Square populates the field when the
     * buyer agrees to the terms of service in Square Point of Sale. This field is typically
     * specified in a `CreateLoyaltyAccount` request when creating a loyalty account for a buyer who
     * already interacted with their account. For example, you would set this field when migrating
     * accounts from an external system. The timestamp in the request can represent a current or
     * previous date and time, but it cannot be set for the future.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEnrolledAt() {
        return OptionalNullable.getFrom(enrolledAt);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the loyalty account was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the loyalty account was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for Mapping.
     * Represents the mapping that associates a loyalty account with a buyer. Currently, a loyalty
     * account can only be mapped to a buyer by phone number. For more information, see [Loyalty
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @return Returns the LoyaltyAccountMapping
     */
    @JsonGetter("mapping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyAccountMapping getMapping() {
        return mapping;
    }

    /**
     * Internal Getter for ExpiringPointDeadlines.
     * The schedule for when points expire in the loyalty account balance. This field is present
     * only if the account has points that are scheduled to expire. The total number of points in
     * this field equals the number of points in the `balance` field.
     * @return Returns the Internal List of LoyaltyAccountExpiringPointDeadline
     */
    @JsonGetter("expiring_point_deadlines")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<LoyaltyAccountExpiringPointDeadline>> internalGetExpiringPointDeadlines() {
        return this.expiringPointDeadlines;
    }

    /**
     * Getter for ExpiringPointDeadlines.
     * The schedule for when points expire in the loyalty account balance. This field is present
     * only if the account has points that are scheduled to expire. The total number of points in
     * this field equals the number of points in the `balance` field.
     * @return Returns the List of LoyaltyAccountExpiringPointDeadline
     */
    @JsonIgnore
    public List<LoyaltyAccountExpiringPointDeadline> getExpiringPointDeadlines() {
        return OptionalNullable.getFrom(expiringPointDeadlines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                programId,
                balance,
                lifetimePoints,
                customerId,
                enrolledAt,
                createdAt,
                updatedAt,
                mapping,
                expiringPointDeadlines);
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
                && Objects.equals(programId, other.programId)
                && Objects.equals(balance, other.balance)
                && Objects.equals(lifetimePoints, other.lifetimePoints)
                && Objects.equals(customerId, other.customerId)
                && Objects.equals(enrolledAt, other.enrolledAt)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(mapping, other.mapping)
                && Objects.equals(expiringPointDeadlines, other.expiringPointDeadlines);
    }

    /**
     * Converts this LoyaltyAccount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyAccount [" + "programId=" + programId + ", id=" + id + ", balance=" + balance
                + ", lifetimePoints=" + lifetimePoints + ", customerId=" + customerId
                + ", enrolledAt=" + enrolledAt + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", mapping=" + mapping + ", expiringPointDeadlines="
                + expiringPointDeadlines + "]";
    }

    /**
     * Builds a new {@link LoyaltyAccount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(programId)
                .id(getId())
                .balance(getBalance())
                .lifetimePoints(getLifetimePoints())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .mapping(getMapping());
        builder.customerId = internalGetCustomerId();
        builder.enrolledAt = internalGetEnrolledAt();
        builder.expiringPointDeadlines = internalGetExpiringPointDeadlines();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccount}.
     */
    public static class Builder {
        private String programId;
        private String id;
        private Integer balance;
        private Integer lifetimePoints;
        private OptionalNullable<String> customerId;
        private OptionalNullable<String> enrolledAt;
        private String createdAt;
        private String updatedAt;
        private LoyaltyAccountMapping mapping;
        private OptionalNullable<List<LoyaltyAccountExpiringPointDeadline>> expiringPointDeadlines;

        /**
         * Initialization constructor.
         * @param  programId  String value for programId.
         */
        public Builder(String programId) {
            this.programId = programId;
        }

        /**
         * Setter for programId.
         * @param  programId  String value for programId.
         * @return Builder
         */
        public Builder programId(String programId) {
            this.programId = programId;
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
         * Setter for balance.
         * @param  balance  Integer value for balance.
         * @return Builder
         */
        public Builder balance(Integer balance) {
            this.balance = balance;
            return this;
        }

        /**
         * Setter for lifetimePoints.
         * @param  lifetimePoints  Integer value for lifetimePoints.
         * @return Builder
         */
        public Builder lifetimePoints(Integer lifetimePoints) {
            this.lifetimePoints = lifetimePoints;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for enrolledAt.
         * @param  enrolledAt  String value for enrolledAt.
         * @return Builder
         */
        public Builder enrolledAt(String enrolledAt) {
            this.enrolledAt = OptionalNullable.of(enrolledAt);
            return this;
        }

        /**
         * UnSetter for enrolledAt.
         * @return Builder
         */
        public Builder unsetEnrolledAt() {
            enrolledAt = null;
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
         * Setter for mapping.
         * @param  mapping  LoyaltyAccountMapping value for mapping.
         * @return Builder
         */
        public Builder mapping(LoyaltyAccountMapping mapping) {
            this.mapping = mapping;
            return this;
        }

        /**
         * Setter for expiringPointDeadlines.
         * @param  expiringPointDeadlines  List of LoyaltyAccountExpiringPointDeadline value for
         *         expiringPointDeadlines.
         * @return Builder
         */
        public Builder expiringPointDeadlines(List<LoyaltyAccountExpiringPointDeadline> expiringPointDeadlines) {
            this.expiringPointDeadlines = OptionalNullable.of(expiringPointDeadlines);
            return this;
        }

        /**
         * UnSetter for expiringPointDeadlines.
         * @return Builder
         */
        public Builder unsetExpiringPointDeadlines() {
            expiringPointDeadlines = null;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyAccount} object using the set fields.
         * @return {@link LoyaltyAccount}
         */
        public LoyaltyAccount build() {
            return new LoyaltyAccount(
                    programId,
                    id,
                    balance,
                    lifetimePoints,
                    customerId,
                    enrolledAt,
                    createdAt,
                    updatedAt,
                    mapping,
                    expiringPointDeadlines);
        }
    }
}
