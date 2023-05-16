
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
 * This is a model class for LoyaltyAccountMapping type.
 */
public class LoyaltyAccountMapping {
    private final String id;
    private final String createdAt;
    private final OptionalNullable<String> phoneNumber;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  phoneNumber  String value for phoneNumber.
     */
    @JsonCreator
    public LoyaltyAccountMapping(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("phone_number") String phoneNumber) {
        this.id = id;
        this.createdAt = createdAt;
        this.phoneNumber = OptionalNullable.of(phoneNumber);
    }

    /**
     * Internal initialization constructor.
     */
    protected LoyaltyAccountMapping(String id, String createdAt,
            OptionalNullable<String> phoneNumber) {
        this.id = id;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the mapping.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the mapping was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for PhoneNumber.
     * The phone number of the buyer, in E.164 format. For example, "+14155551111".
     * @return Returns the Internal String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the buyer, in E.164 format. For example, "+14155551111".
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyAccountMapping)) {
            return false;
        }
        LoyaltyAccountMapping other = (LoyaltyAccountMapping) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(phoneNumber, other.phoneNumber);
    }

    /**
     * Converts this LoyaltyAccountMapping into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyAccountMapping [" + "id=" + id + ", createdAt=" + createdAt
                + ", phoneNumber=" + phoneNumber + "]";
    }

    /**
     * Builds a new {@link LoyaltyAccountMapping.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccountMapping.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .createdAt(getCreatedAt());
        builder.phoneNumber = internalGetPhoneNumber();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccountMapping}.
     */
    public static class Builder {
        private String id;
        private String createdAt;
        private OptionalNullable<String> phoneNumber;



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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = OptionalNullable.of(phoneNumber);
            return this;
        }

        /**
         * UnSetter for phoneNumber.
         * @return Builder
         */
        public Builder unsetPhoneNumber() {
            phoneNumber = null;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyAccountMapping} object using the set fields.
         * @return {@link LoyaltyAccountMapping}
         */
        public LoyaltyAccountMapping build() {
            return new LoyaltyAccountMapping(id, createdAt, phoneNumber);
        }
    }
}
