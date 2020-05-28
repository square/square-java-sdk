package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateLoyaltyAccountRequest type.
 */
public class CreateLoyaltyAccountRequest {

    /**
     * Initialization constructor.
     * @param loyaltyAccount
     * @param idempotencyKey
     */
    @JsonCreator
    public CreateLoyaltyAccountRequest(
            @JsonProperty("loyalty_account") LoyaltyAccount loyaltyAccount,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.loyaltyAccount = loyaltyAccount;
        this.idempotencyKey = idempotencyKey;
    }

    private final LoyaltyAccount loyaltyAccount;
    private final String idempotencyKey;
    /**
     * Getter for LoyaltyAccount.
     * Describes a loyalty account. For more information, see 
     * [Loyalty Overview](https://developer.squareup.com/docs/docs/loyalty/overview).
     */
    @JsonGetter("loyalty_account")
    public LoyaltyAccount getLoyaltyAccount() {
        return this.loyaltyAccount;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateLoyaltyAccount` request. 
     * Keys can be any valid string, but must be unique for every request.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccount, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateLoyaltyAccountRequest)) {
            return false;
        }
        CreateLoyaltyAccountRequest createLoyaltyAccountRequest = (CreateLoyaltyAccountRequest) obj;
        return Objects.equals(loyaltyAccount, createLoyaltyAccountRequest.loyaltyAccount) &&
            Objects.equals(idempotencyKey, createLoyaltyAccountRequest.idempotencyKey);
    }

    /**
     * Builds a new {@link CreateLoyaltyAccountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyAccountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccount,
            idempotencyKey);
            return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyAccountRequest}
     */
    public static class Builder {
        private LoyaltyAccount loyaltyAccount;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder(LoyaltyAccount loyaltyAccount,
                String idempotencyKey) {
            this.loyaltyAccount = loyaltyAccount;
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for loyaltyAccount
         * @param loyaltyAccount
         * @return Builder
         */
        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount) {
            this.loyaltyAccount = loyaltyAccount;
            return this;
        }
        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateLoyaltyAccountRequest} object using the set fields.
         * @return {@link CreateLoyaltyAccountRequest}
         */
        public CreateLoyaltyAccountRequest build() {
            return new CreateLoyaltyAccountRequest(loyaltyAccount,
                idempotencyKey);
        }
    }
}
