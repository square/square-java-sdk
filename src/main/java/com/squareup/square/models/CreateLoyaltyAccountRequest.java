
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateLoyaltyAccountRequest type.
 */
public class CreateLoyaltyAccountRequest {
    private final LoyaltyAccount loyaltyAccount;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param loyaltyAccount LoyaltyAccount value for loyaltyAccount.
     * @param idempotencyKey String value for idempotencyKey.
     */
    @JsonCreator
    public CreateLoyaltyAccountRequest(
            @JsonProperty("loyalty_account") LoyaltyAccount loyaltyAccount,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.loyaltyAccount = loyaltyAccount;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for LoyaltyAccount.
     * Describes a loyalty account. For more information, see [Loyalty
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @return Returns the LoyaltyAccount
     */
    @JsonGetter("loyalty_account")
    public LoyaltyAccount getLoyaltyAccount() {
        return this.loyaltyAccount;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateLoyaltyAccount` request. Keys can be any valid
     * string, but must be unique for every request.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateLoyaltyAccountRequest)) {
            return false;
        }
        CreateLoyaltyAccountRequest other = (CreateLoyaltyAccountRequest) obj;
        return Objects.equals(loyaltyAccount, other.loyaltyAccount)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateLoyaltyAccountRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateLoyaltyAccountRequest [" + "loyaltyAccount=" + loyaltyAccount
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateLoyaltyAccountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyAccountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccount, idempotencyKey);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyAccountRequest}.
     */
    public static class Builder {
        private LoyaltyAccount loyaltyAccount;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param loyaltyAccount LoyaltyAccount value for loyaltyAccount.
         * @param idempotencyKey String value for idempotencyKey.
         */
        public Builder(LoyaltyAccount loyaltyAccount,
                String idempotencyKey) {
            this.loyaltyAccount = loyaltyAccount;
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for loyaltyAccount.
         * @param loyaltyAccount LoyaltyAccount value for loyaltyAccount.
         * @return Builder
         */
        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount) {
            this.loyaltyAccount = loyaltyAccount;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
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
            return new CreateLoyaltyAccountRequest(loyaltyAccount, idempotencyKey);
        }
    }
}
