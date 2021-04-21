
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyAccountMapping type.
 */
public class LoyaltyAccountMapping {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String phoneNumber;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  type  String value for type.
     * @param  value  String value for value.
     * @param  createdAt  String value for createdAt.
     * @param  phoneNumber  String value for phoneNumber.
     */
    @JsonCreator
    public LoyaltyAccountMapping(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("value") String value,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("phone_number") String phoneNumber) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the mapping.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * The type of mapping.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Value.
     * The mapping value, which is used with `type` to represent a phone number mapping. The value
     * can be a phone number in E.164 format. For example, "+14155551111". When specifying a
     * mapping, the `phone_number` field is preferred to using `type` and `value`.
     * @return Returns the String
     */
    @JsonGetter("value")
    public String getValue() {
        return value;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the mapping was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the buyer, in E.164 format. For example, "+14155551111". When specifying
     * a mapping, this `phone_number` field is preferred to using `type` and `value`.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, createdAt, phoneNumber);
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
            && Objects.equals(type, other.type)
            && Objects.equals(value, other.value)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(phoneNumber, other.phoneNumber);
    }

    /**
     * Converts this LoyaltyAccountMapping into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyAccountMapping [" + "id=" + id + ", type=" + type + ", value=" + value
                + ", createdAt=" + createdAt + ", phoneNumber=" + phoneNumber + "]";
    }

    /**
     * Builds a new {@link LoyaltyAccountMapping.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccountMapping.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .type(getType())
                .value(getValue())
                .createdAt(getCreatedAt())
                .phoneNumber(getPhoneNumber());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccountMapping}.
     */
    public static class Builder {
        private String id;
        private String type;
        private String value;
        private String createdAt;
        private String phoneNumber;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for value.
         * @param  value  String value for value.
         * @return Builder
         */
        public Builder value(String value) {
            this.value = value;
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
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyAccountMapping} object using the set fields.
         * @return {@link LoyaltyAccountMapping}
         */
        public LoyaltyAccountMapping build() {
            return new LoyaltyAccountMapping(id, type, value, createdAt, phoneNumber);
        }
    }
}
